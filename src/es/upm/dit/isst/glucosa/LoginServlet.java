package es.upm.dit.isst.glucosa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.upm.dit.isst.glucosa.dao.GlucosaDAO;
import es.upm.dit.isst.glucosa.dao.GlucosaDAOImpl;
import es.upm.dit.isst.glucosa.model.Usuario;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		GlucosaDAO dao = GlucosaDAOImpl.getInstance();
		
		ArrayList<String> aux = null;
		dao.create("1", "admin@gmail.com", "admin", "hombre", "", "", aux, "admin", true);
		
		String name = req.getParameter("nombre");
		String pass = req.getParameter("password");
		
		HttpSession session = req.getSession(false);
		
		String url = "";
		
		List<Usuario> users =  dao.read();
		for(Usuario u: users) {
			if (u.getNombre() != null){
				if (pass == u.getPassword()){
					url = "Index.jsp";
					//LOGIN
				}
			}
			//NO LOGIN
			RequestDispatcher	view =	req.getRequestDispatcher(url);
			view.forward(req,	resp);
			resp.getWriter().println(url + "url");
		}
	}
}
