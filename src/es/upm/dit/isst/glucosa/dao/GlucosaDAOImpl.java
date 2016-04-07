package es.upm.dit.isst.glucosa.dao;

import java.util.ArrayList;

import es.upm.dit.isst.glucosa.model.Usuario;

public class GlucosaDAOImpl implements GlucosaDAO{

	public GlucosaDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(String dni, String correo, String nombre, String genero,
			String fechaDiagnostico, String fechaNacimiento,
			ArrayList<String> datos) {
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario read(String dni) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Usuario> readGenero(String genero){
		
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Usuario user) {
		// TODO Auto-generated method stub
		
	}

}
