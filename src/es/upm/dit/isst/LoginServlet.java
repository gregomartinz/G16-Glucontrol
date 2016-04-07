package es.upm.dit.isst;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.upm.dit.isst.glucosa.dao.GlucosaDAO;
import es.upm.dit.isst.glucosa.dao.GlucosaDAOImpl;
import es.upm.dit.isst.glucosa.model.Usuario;

public class LoginServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		GlucosaDAO dao;
		
		String name = req.getParameter("nombre");
		String pass = req.getParameter("password");
		
		HttpSession session = req.getSession(false);
		
//		List<Usuario> users ;
//		for(Usuario u: users) {
//			if (u.getName != null){
//				if (pass == u.getPass()){
//					//LOGIN
//				}
//			}
//			//NO LOGIN
//			resp.getWriter().println(t.toString(t));
//		}
		
		
	}

}
