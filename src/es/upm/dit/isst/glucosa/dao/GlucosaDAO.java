package es.upm.dit.isst.glucosa.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.dit.isst.glucosa.model.Usuario;

public interface GlucosaDAO {

	public Usuario readDni(String dni);
	public List<Usuario> readGenero(String genero);
	public List<Usuario> read();
	public void update(Usuario user);
	public void delete(Usuario user);
	void create(String dni, String correo, String nombre, String genero,
			String fechaDiagnostico, String fechaNacimiento,
			HashMap<Integer, String> datos, String password, boolean admin);
	
}
