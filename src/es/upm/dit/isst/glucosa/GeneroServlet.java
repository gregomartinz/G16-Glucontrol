package es.upm.dit.isst.glucosa;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.glucosa.dao.GlucosaDAO;
import es.upm.dit.isst.glucosa.dao.GlucosaDAOImpl;
import es.upm.dit.isst.glucosa.model.Usuario;

public class GeneroServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		GlucosaDAO dao = GlucosaDAOImpl.getInstance();
		TreeMap<Long,String> genero = new TreeMap<Long,String>();
		TreeMap<Long,String> calculos = new TreeMap<Long,String>();
		List<Usuario> stats = dao.readGenero(req.getParameter("genero"));
		
		for(Usuario u: stats){
			System.out.println(u.getNombre());
			TreeMap<Long,String> aux = (TreeMap<Long,String>)u.getDatos();
			if (aux == null) {
				continue;
			}
			Iterator it = aux.keySet().iterator();
			while(it.hasNext()){
				Long key = (Long)it.next();
				if(calculos.containsKey(key)){
					String dato = calculos.get(key);
					dato = dato + "/" + aux.get(key);
					calculos.put(key, dato);
				}else{
					calculos.put(key, aux.get(key));
				}
			}
		}
		Iterator iter = calculos.keySet().iterator();
		while(iter.hasNext()){
			Long clave = (Long)iter.next();
			int desayuno = 0;
			int comida = 0;
			int cena = 0;
			String [] a = calculos.get(clave).split("/");
			for(int i = 0; i<a.length;i++){
				String [] b = a[i].split(",");
				desayuno += Integer.parseInt(b[0]);
				comida += Integer.parseInt(b[1]);
				cena += Integer.parseInt(b[2]);
			}
			genero.put(clave, desayuno/a.length + "," + comida/a.length + "," + cena/a.length + ",");
		}
		req.getSession().setAttribute("stats",genero);

		RequestDispatcher view = req.getRequestDispatcher("Genero.jsp");
		view.forward(req, resp);
	
	}
}