package es.upm.dit.isst.glucosa;

import java.io.IOException;
import java.util.List;
import javax.jdo.annotations.Transactional;
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
		dao.create("1", "admin@gmail.com", "admin", "hombre", "", "", null, "admin", true);
		String name = req.getParameter("user");
		String pass = req.getParameter("password");
		
		HttpSession session = req.getSession(false);
		
		String url = "asas";
		
		List<Usuario> users =  dao.read();
		
		for(Usuario u: users) {
			if (u.getNombre().equals(name)){
				if (u.getPassword().equals(pass)){
					url = "Index.jsp";
					//LOGIN
				}
			}
		}
		//NO LOGIN
		resp.sendRedirect(url);
	}
}
