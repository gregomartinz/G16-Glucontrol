package es.upm.dit.isst.glucosa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.glucosa.dao.GlucosaDAO;
import es.upm.dit.isst.glucosa.dao.GlucosaDAOImpl;
import es.upm.dit.isst.glucosa.model.Usuario;

public class ProfileServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		GlucosaDAO dao = GlucosaDAOImpl.getInstance();
		String dni = (String) req.getSession().getAttribute("dni");
		Usuario user = dao.readDni(dni);
		String nombre = req.getParameter("nombre");
		String fechaD = req.getParameter("fechaD");
		if(!nombre.equals("")){
			user.setNombre(nombre);
			req.getSession().setAttribute("usuario", nombre);
		}
		if(!fechaD.equals("")){
			user.setFechaDiagnostico(fechaD);	
		}
		dao.update(user);
		req.setAttribute("fechaD", fechaD);
		req.setAttribute("nombre", nombre);
		RequestDispatcher view = req.getRequestDispatcher("Index.jsp");
		view.forward(req, resp);
	}
}