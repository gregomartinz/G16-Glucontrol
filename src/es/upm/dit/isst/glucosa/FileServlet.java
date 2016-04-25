package es.upm.dit.isst.glucosa;

import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RespectBinding;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import es.upm.dit.isst.glucosa.dao.GlucosaDAO;
import es.upm.dit.isst.glucosa.dao.GlucosaDAOImpl;
import es.upm.dit.isst.glucosa.model.Usuario;

public class FileServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	Date[] fechas;
	String[] medidas;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        GlucosaDAO dao = GlucosaDAOImpl.getInstance();
        String dni = (String) req.getSession().getAttribute("dni");
        Usuario user = dao.readDni(dni);

        Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        TreeMap<Long, String> datos = user.getDatos();
		if(datos == null){
			datos = new TreeMap<Long,String>();
		}
        List<BlobKey> blobKeys = blobs.get("myFile");
        BlobKey blobKey = new BlobKey(blobKeys.get(0).getKeyString());
        
        byte[] b= blobstoreService.fetchData(blobKey, 0, blobstoreService.MAX_BLOB_FETCH_SIZE-1);
        String str = new String(b);
        String prueba []= str.split("\n");
        
        for (int i = 0; i < prueba.length; i++) {
        	//aux[0] es la fecha y aux[1] las medidas
        	String[] aux = prueba[i].split(";");
        	//fecha[0] es el día, fecha [1] es el mes y fecha[2] el año
        	String[] fecha = aux[0].split("/");
        	Integer ano = Integer.valueOf(fecha[2]);
        	Integer mes = Integer.valueOf(fecha[1]);
        	Integer dia = Integer.valueOf(fecha[0]);
        	@SuppressWarnings("deprecation")
			Date date = new Date(ano + 2000, mes, dia);
        	Long time = date.getTime();
        	
        	datos.put(time, aux[1]);
        	user.setDatos(datos);
        	dao.update(user);
        	
        	System.out.println(time);
        	System.out.println(aux[1]);
        	
//        	res.getWriter().print(time + " " +aux[1]);
        	
		}
                      
		req.getSession().setAttribute("datos", datos);

		res.sendRedirect("/Index.jsp");
    }
}