package es.upm.dit.isst.glucosa.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFService {

	private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("transactions-optional");
	
	public EMFService() {
		// TODO Auto-generated constructor stub
	}

	public static EntityManagerFactory get() {
		return emfInstance;
	}
}
