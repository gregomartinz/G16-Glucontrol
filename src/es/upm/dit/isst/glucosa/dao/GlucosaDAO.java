package es.upm.dit.isst.glucosa.dao;

import java.util.ArrayList;

import es.upm.dit.isst.glucosa.model.Usuario;

public interface GlucosaDAO {

	public void create(String dni, String correo, String nombre, String genero, 
			String fechaDiagnostico, String fechaNacimiento, ArrayList<String> datos);
	public Usuario read(String dni);
	public void update();
	public void delete(Usuario user);
	
}
