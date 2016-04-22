package es.upm.dit.isst.glucosa;

import java.io.IOException;
import java.util.TreeMap;

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

		TreeMap<Long,String> stats = dao.readDni((String) req.getSession().getAttribute("dni")).getDatos();
//		resp.getWriter().print(stats);
		req.getSession().setAttribute("stats",stats);

		RequestDispatcher view = req.getRequestDispatcher("Stats.jsp");
		view.forward(req, resp);
	
	}
}
