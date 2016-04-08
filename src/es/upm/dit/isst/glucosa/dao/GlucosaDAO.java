package es.upm.dit.isst.glucosa.dao;

import java.util.ArrayList;

import es.upm.dit.isst.glucosa.model.Usuario;

public interface GlucosaDAO {

	public void create(String dni, String correo, String nombre, String genero, 
			String fechaDiagnostico, String fechaNacimiento, ArrayList<String> datos, String password);
	public Usuario readDni(String dni);
	public ArrayList<Usuario> readGenero(String genero);
	public ArrayList<Usuario> read();
	public void update(Usuario user);
	public void delete(Usuario user);
	void create(String dni, String correo, String nombre, String genero,
			String fechaDiagnostico, String fechaNacimiento,
			ArrayList<String> datos, String password, boolean admin);
	
}
