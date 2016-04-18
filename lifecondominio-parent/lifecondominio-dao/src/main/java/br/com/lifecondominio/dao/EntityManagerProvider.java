package br.com.lifecondominio.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe utilizada para fazer realizar as operações Singleton
 */
public final class EntityManagerProvider {

	private static final EntityManagerProvider INSTANCE = new EntityManagerProvider();

	private final EntityManagerFactory factory;

	private EntityManagerProvider() {
		this.factory = Persistence.createEntityManagerFactory("sdapi");
	}

	public static EntityManagerProvider getInstance() {
		return INSTANCE;
	}

	public EntityManagerFactory getFactory() {
		return factory;
	}

	public EntityManager createManager() {
		return factory.createEntityManager();
	}
}