package es.upm.dit.isst.glucosa;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.upm.dit.isst.glucosa.dao.GlucosaDAO;
import es.upm.dit.isst.glucosa.dao.GlucosaDAOImpl;
import es.upm.dit.isst.glucosa.model.Usuario;

public class LoginServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		GlucosaDAO dao = GlucosaDAOImpl.getInstance();
//		dao.create("1", "admin@gmail.com", "admin", "hombre", "", "", null, "admin", true,"Básico");
//		dao.create("2", "admin@gmail.com", "Antonio", "hombre", "", "", null, "1234", false,"Básico");
//		dao.create("3", "admin@gmail.com", "Jesus", "hombre", "", "", null, "1234", false,"Básico");
//		dao.create("4", "admin@gmail.com", "Sara", "mujer", "", "", null, "1234", false,"Básico");
//		dao.create("5", "admin@gmail.com", "Rosa", "mujer", "", "", null, "1234", false,"Básico");

		String name = req.getParameter("user");
		String pass = req.getParameter("password");
		
		HttpSession session = req.getSession();
		
		String url = "Login.jsp";
		
		List<Usuario> users =  dao.read();
		
		for(Usuario u: users) {
			if (u.getNombre().equals(name)){
				if (u.getPassword().equals(pass)){
					session.setAttribute("usuario", name);
					session.setAttribute("medico", u.isMedico());
					session.setAttribute("tratamiento", u.getTratamiento());
					session.setAttribute("fechaD", u.getFechaDiagnostico());
					session.setAttribute("dni",u.getDni());  
					url = "Index.jsp";
					//LOGIN
				}
			}
		}
		//NO LOGIN
		resp.sendRedirect(url);
	}
}
