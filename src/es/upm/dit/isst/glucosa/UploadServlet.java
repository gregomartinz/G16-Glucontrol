package es.upm.dit.isst.glucosa;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.glucosa.dao.GlucosaDAO;
import es.upm.dit.isst.glucosa.dao.GlucosaDAOImpl;
import es.upm.dit.isst.glucosa.model.Usuario;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class UploadServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
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
		String formato_desayuno = desayuno + "--" + horaDesayuno + "de-";
		String formato_comida = comida + "--" + horaComida + "co-";
		String formato_cena = cena + "--" + horaCena + "ce-";
		String formato_dato =  formato_fecha + "-f" +  formato_desayuno +  formato_comida + formato_cena;

		Usuario user = dao.readDni(dni);
		ArrayList<String> datos = user.getDatos();
		datos.add(formato_dato);
		
		int d = Integer.parseInt(desayuno);
		int co = Integer.parseInt(comida);
		int ce = Integer.parseInt(cena);
		if (d > 100 || co > 100 || ce > 100) {
			try {
				mail(user.correo);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}	
	

		user.setDatos(datos);
		dao.update(user);
		
		req.getSession().setAttribute("datos", datos);
		//FALTA LA LECTURA DEL FICHERO Y COMPROBAR QUE LOS DATOS NO SON NULL
		
		RequestDispatcher view = req.getRequestDispatcher("Index.jsp");
		view.forward(req, resp);
		
	}
	
	private void mail(String correo) throws UnsupportedEncodingException, MessagingException{
		Properties props = new Properties();
	    Session session = Session.getDefaultInstance(props, null);

	    String msgBody = "El nivel de glucosa del paciente es muy alto";
	    
		Message msg = new MimeMessage(session);
	    msg.setFrom(new InternetAddress("gregomartinz@gmail.com", "Example.com Admin"));
	    msg.addRecipient(Message.RecipientType.TO,
	     new InternetAddress(correo, "Mr. User"));
	    msg.setSubject("GluControl");
	    msg.setText(msgBody);
	    Transport.send(msg);
	}

}