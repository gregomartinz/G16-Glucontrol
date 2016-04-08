package es.upm.dit.isst;

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

public class UploadServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		GlucosaDAO dao = GlucosaDAOImpl.getInstance();
		
		String dni = (String) req.getSession().getAttribute("dni");
		String desayuno = req.getParameter("glucosaDesayuno");
		String comida = req.getParameter("glucosaComida");
		String cena = req.getParameter("glucosaCena");
		String horaDesayuno = req.getParameter("horaDesayuno");
		String horaComida = req.getParameter("horaComida");
		String horaCena = req.getParameter("horaCena");
		String fechaDia = req.getParameter("fecha_dia");
		String fechaMes = req.getParameter("fecha_mes");
		String fechaAno = req.getParameter("fecha_ano");
		// formato estandar de los datos ya que tomamos tanto la fecha como las horas de forma modular
		String formato_fecha = fechaDia + "/" + fechaMes + "/" + fechaAno;
		String formato_desayuno = desayuno + "%-" + horaDesayuno + "de-";
		String formato_comida = comida + "%-" + horaComida + "co-";
		String formato_cena = cena + "%-" + horaCena + "ce-";
		String formato_dato = "$f" + formato_fecha + "$m" + formato_desayuno + formato_comida + formato_cena;

		Usuario user = dao.readDni(dni);
		ArrayList<String> datos = user.getDatos();
		datos.add(formato_dato);
		
		user.setDatos(datos);
		dao.update(user);
		//FALTA LA LECTURA DEL FICHERO Y COMPROBAR QUE LOS DATOS NO SON NULL
		
		RequestDispatcher view = req.getRequestDispatcher("Formulario.jsp");
		view.forward(req, resp);
		
	}

}