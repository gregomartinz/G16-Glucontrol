package es.upm.dit.isst.glucosa;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.glucosa.dao.GlucosaDAO;
import es.upm.dit.isst.glucosa.dao.GlucosaDAOImpl;

public class StatsServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		GlucosaDAO dao = GlucosaDAOImpl.getInstance();
		String [] fecha;
		String [] m1;
		String [] m2;
		String [] m3;
		String [] hora1;
		String [] hora2;
		String [] hora3;
		ArrayList<String> stats = new ArrayList<String>();
		ArrayList<String> aux = dao.readDni((String) req.getSession().getAttribute("dni")).getDatos();

		resp.getWriter().print(aux.get(0).split("-").toString());

		for (String s : aux) {
			fecha = s.split("-f");
			
			m1 = fecha[1].split("de-"); 
			m2 = fecha[1].split("co-"); 
			m3 = fecha[1].split("ce-"); 
			//resp.getWriter().print(m1);
			//resp.getWriter().print(m2);
			//resp.getWriter().print(m3);
			

//			hora1 = m1[1].split("--");
//			hora2 = m2[1].split("--");
//			hora3 = m3[1].split("--");
//			stats.add(fecha[0]);
//			stats.add(hora1[0]);
//			stats.add(m1[0]);
//			stats.add(hora2[0]);
//			stats.add(m2[0]);
//			stats.add(hora3[0]);
//			stats.add(m3[0]);
		}
		//resp.getWriter().print(stats);
		req.getSession().setAttribute("stats", stats);
		
//		
//		RequestDispatcher view = req.getRequestDispatcher("Stats.jsp");
//		view.forward(req, resp);
	
	}
}
