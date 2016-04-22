package es.upm.dit.isst.glucosa;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.glucosa.dao.GlucosaDAO;
import es.upm.dit.isst.glucosa.dao.GlucosaDAOImpl;

public class SemanaServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		GlucosaDAO dao = GlucosaDAOImpl.getInstance();
		TreeMap<Long,String> semana = new TreeMap<Long,String>();
		TreeMap<Long,String> stats = dao.readDni((String) req.getSession().getAttribute("dni")).getDatos();
		
		Calendar calendario = new GregorianCalendar();
		Date date = new Date(calendario.get(calendario.YEAR),calendario.get(calendario.MONTH)+1,calendario.get(calendario.DAY_OF_MONTH));
		
		Iterator it = stats.keySet().iterator();
		while(it.hasNext()){
			Long key = (Long)it.next();
			if((date.getTime()-key) < 604800000){
				semana.put(key, stats.get(key));
			}
		}
//		resp.getWriter().print(stats);
		req.getSession().setAttribute("stats",semana);

		RequestDispatcher view = req.getRequestDispatcher("Stats.jsp");
		view.forward(req, resp);
	
	}
}