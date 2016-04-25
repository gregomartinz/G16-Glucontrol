package es.upm.dit.isst.glucosa;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RespectBinding;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import es.upm.dit.isst.glucosa.dao.GlucosaDAO;
import es.upm.dit.isst.glucosa.dao.GlucosaDAOImpl;
import es.upm.dit.isst.glucosa.model.Usuario;

public class FileServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        GlucosaDAO dao = GlucosaDAOImpl.getInstance();
        String dni = (String) req.getSession().getAttribute("dni");
        Usuario user = dao.readDni(dni);

        Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        TreeMap<Long, String> datos = new TreeMap<Long,String>();
        
        List<BlobKey> blobKeys = blobs.get("myFile");
        BlobKey blobKey = new BlobKey(blobKeys.get(0).getKeyString());
        
        byte[] b= blobstoreService.fetchData(blobKey, 0, blobstoreService.MAX_BLOB_FETCH_SIZE-1);
        String str = new String(b);
        String prueba []= str.split("\n");
        System.out.print(prueba[0]);
        System.out.print(prueba[1]);
        System.out.print(prueba[2]);
        
        for (int i = 0; i < prueba.length; i++) {
			res.getWriter().print(prueba[i]);
		}
        
        //Una vez aquí sólo hay que sacar los datos del blobs y mirar que sale.
        
        //List<BlobKey> datos = blobs.get("myFile");

//        if (datos == null || datos.isEmpty()) {
//            res.sendRedirect("/");
//        } else {
//            res.sendRedirect("/serve?blob-key=" + datos.get(0).getKeyString());
//        }
//
//        datos.put((Long) fecha.getTime(), formato_dato);
//        user.setDatos(datos.get(0).getKeyString());
//        dao.update(user);
//        
//        req.getSession().setAttribute("datos", datos);
//        RequestDispatcher view = req.getRequestDispatcher("Index.jsp");
//        view.forward(req, resp);
    }
}