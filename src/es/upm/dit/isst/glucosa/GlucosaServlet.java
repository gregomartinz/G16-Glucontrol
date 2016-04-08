package es.upm.dit.isst.glucosa;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.*;

import es.upm.dit.isst.glucosa.dao.GlucosaDAO;
import es.upm.dit.isst.glucosa.dao.GlucosaDAOImpl;

@SuppressWarnings("serial")
public class GlucosaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		GlucosaDAO dao = GlucosaDAOImpl.getInstance();
		
		ArrayList<String> aux = null;
		dao.create("1", "admin@gmail.com", "admin", "hombre", "", "", aux, "admin", true);
	}
}
