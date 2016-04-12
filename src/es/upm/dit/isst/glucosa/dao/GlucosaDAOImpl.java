package es.upm.dit.isst.glucosa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.upm.dit.isst.glucosa.model.Usuario;

public class GlucosaDAOImpl implements GlucosaDAO{

	private static GlucosaDAOImpl instance;
	
	private GlucosaDAOImpl () {
	}
	
	public static GlucosaDAOImpl getInstance() {
		if (instance == null)
			instance = new GlucosaDAOImpl();
		return instance;
	}

	@Override
	public void create(String dni, String correo, String nombre, String genero,
			String fechaDiagnostico, String fechaNacimiento,
			ArrayList<String> datos, String password, boolean admin) {
		
		EntityManager em = EMFService.get().createEntityManager();
		Usuario user = new Usuario(dni, correo, nombre, genero, fechaDiagnostico, fechaNacimiento, datos, password, admin);

		em.persist(user);
		em.close();
	}

	@Override
	public Usuario readDni(String dni) {
		Usuario user = null;
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from Usuario m where m.dni = :dni");
		q.setParameter("dni", dni);
		try{
			user = (Usuario)q.getSingleResult();
		}catch(Exception e){
			//System.out.println("no hay nadie con ese dni");
		}
		em.close();
		return user;
	}
	
	@Override
	public List<Usuario> readGenero(String genero) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from Usuario m where m.genero = :genero");
		q.setParameter("genero", genero);
		List<Usuario> lista = q.getResultList();
		em.close();
		return lista;
	}
	
	@Override
	public List<Usuario> read(){
		
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from Usuario m");

		
		List<Usuario> lista = q.getResultList();
		
		em.close();
		return lista;
	}

	@Override
	public void update(Usuario user) {
		EntityManager em = EMFService.get().createEntityManager();
		try{
			em.merge(user);
		}catch(Exception e){
			//System.out.println("no se ha podido actualizar");
		}
		em.close();
	}

	@Override
	public void delete(Usuario user) {
		EntityManager em = EMFService.get().createEntityManager();
		try{
			em.remove(user);
		}catch(Exception e){
			//System.out.println("no se ha podido borrar");
		}
		em.close();		
	}

}
