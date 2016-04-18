package br.com.lifecondominio.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutorEntityManager {
	 private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("SDAPI");
	 
	   @Produces  @RequestScoped
	   public EntityManager criaEntityManager() {
	      return factory.createEntityManager();
	   }

}
