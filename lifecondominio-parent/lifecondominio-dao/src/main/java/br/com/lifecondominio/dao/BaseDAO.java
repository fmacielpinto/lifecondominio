package br.com.lifecondominio.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import br.com.lifecondominio.model.BaseModel;

@Stateless
public class BaseDAO<T extends BaseModel> {

	private EntityManager em;

	private Class<T> entityClass;

	public BaseDAO(Class<T> entityClass) {
		this.entityClass = entityClass;

	}

	public void commit() {
		em.getTransaction().commit();
	}

	public void rollback() {
		em.getTransaction().rollback();
	}

	public void closeTransaction() {
		em.close();
	}

	public void commitAndCloseTransaction() {
		commit();
		closeTransaction();
	}

	public void flush() {
		em.flush();
	}

	/*
	 * public void joinTransaction() { em = emf.createEntityManager();
	 * em.joinTransaction(); }
	 */

	public void save(T entity) {
		em.persist(entity);
	}

	public void delete(Object id, Class<T> classe) {
		T entityToBeRemoved = em.getReference(classe, id);

		em.remove(entityToBeRemoved);
	}

	public T update(T entity) {
		return em.merge(entity);
	}

	public T find(int entityID) {
		return em.find(entityClass, entityID);
	}

	public T find(String entityID) {
		return em.find(entityClass, entityID);
	}

	public T findReferenceOnly(int entityID) {
		return em.getReference(entityClass, entityID);
	}

	public T findReferenceOnly(String entityID) {
		return em.getReference(entityClass, entityID);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}

	@SuppressWarnings("unchecked")
	protected List<T> findListResult(String namedQuery, Map<String, Object> parameters) {
		List<T> result = null;

		try {

			Query query = em.createQuery(namedQuery);

			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}

			result = query.getResultList();

		} catch (NoResultException e) {
			System.out.println("Nenhum resultado encontrado para consulta: " + namedQuery);
		} catch (Exception e) {
			System.out.println("Erro durante a execução da consulta: " + e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public T findOneResult(String namedQuery, Map<String, Object> parameters) {
		T result = null;

		try {
			// Query query = em.createNamedQuery(namedQuery);
			Query query = em.createQuery(namedQuery);

			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}

			result = (T) query.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("Nenhum resultado encontrado para consulta: " + namedQuery);
		} catch (Exception e) {
			System.out.println("Erro durante a execução da consulta: " + e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	private void populateQueryParameters(Query query, Map<String, Object> parameters) {
		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}
}
