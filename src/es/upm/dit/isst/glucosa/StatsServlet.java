package es.upm.dit.isst.glucosa;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.orsoncharts.util.json.parser.JSONParser;

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
		ArrayList<String> statsFecha = new ArrayList<String>();
		ArrayList<String> statsMedidas = new ArrayList<String>();
		ArrayList<String> statsHoras = new ArrayList<String>();


		ArrayList<String> aux = dao.readDni((String) req.getSession().getAttribute("dni")).getDatos();

		for (String s : aux) {
			fecha = s.split("-f");
			m1 = fecha[1].split("de-"); 
			m2 = m1[1].split("co-"); 
			m3 = m2[1].split("ce-"); 
			hora1 = m1[0].split("--");
			m1[0] = hora1[0];
			hora1[0] = hora1[1];
			
			hora2 = m2[0].split("--");
			m2[0] = hora2[0];
			hora2[0] = hora2[1];
			
			hora3 = m3[0].split("--");
			m3[0] = hora3[0];
			hora3[0] = hora3[1];
			
			statsFecha.add(fecha[0]);
			statsHoras.add(hora1[0]);
			statsMedidas.add(m1[0]);
			statsHoras.add(hora2[0]);
			statsMedidas.add(m2[0]);
			statsHoras.add(hora3[0]);
			statsMedidas.add(m3[0]);
		}
		
		
		JSONArray jsfecha = new JSONArray(statsFecha);
		JSONArray jsmedida = new JSONArray(statsMedidas);
		JSONArray jshora = new JSONArray(statsHoras);

		
//		resp.getWriter().print(stats);
		req.getSession().setAttribute("statsFecha", jsfecha);
		req.getSession().setAttribute("statsMedidas", jsmedida);
		req.getSession().setAttribute("statsHoras", jshora);

		RequestDispatcher view = req.getRequestDispatcher("Stats.jsp");
		view.forward(req, resp);
	
	}
}
