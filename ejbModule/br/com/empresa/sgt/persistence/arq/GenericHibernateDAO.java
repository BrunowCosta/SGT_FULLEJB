package br.com.empresa.sgt.persistence.arq;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.criterion.Example;


// Adapter Pattern
public abstract class GenericHibernateDAO<T, ID extends Serializable> implements GenericDao <T, ID> {

//	private EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("SGTDB");
	
	@PersistenceContext(unitName="SGT")
	private EntityManager manager;
	
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public GenericHibernateDAO() {
		this.setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	@Override
	public void persist(T obj) {
		getManager().persist(obj);
		getManager().flush();
	}

	@Override
	public void remove(T obj) {
		getManager().remove(obj);
	}

	@Override
	public T merge(T obj) {
		obj = this.getManager().merge(obj);
		return obj;
	}

	@Override
	public void refresh(T obj) {
		this.getManager().refresh(obj);
	}

	@Override
	public T findById(ID id) {
		return this.getManager().find(this.getEntityClass(), id);
	}
	
	@Override
	public T findMaxField(String field) {
		
//		Query query = manager .createQuery("select c from Class as c where c. = :value");
//		query.setParameter("field", field);
//		query.set
//		
		return null;
	}

	@Override
	public T findMinId(ID id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		CriteriaQuery cq = this.getManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return this.getManager().createQuery(cq).getResultList();
	}
	
	protected Integer countByQuery(String namedQuery, Map<String, Object> parameters) {
		Integer result = null;

		try {
			Query query = this.getManager().createNamedQuery(namedQuery);
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}

			result = query.getMaxResults();

		} catch (NoResultException e) {
			// TODO trocar isso aqui para log
			System.out.println("No result found for named query: " + namedQuery);
		} catch (Exception e) {
			// TODO trocar isso aqui para log
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByExample(T exampleEntity) {
	    Example example = Example.create(exampleEntity).excludeZeroes().enableLike();
	    return this.getSession().createCriteria(this.getClass()).add(example).list();
	}
	
	@SuppressWarnings("unchecked")
	protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
		T result = null;

		try {
			// HQL MAPEADA
			Query query = this.getManager().createNamedQuery(namedQuery);

			// Method that will populate parameters if they are passed not null and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}

			result = (T) query.getSingleResult();

		} catch (NoResultException e) {
			// TODO trocar isso aqui para log
			System.out.println("No result found for named query: " + namedQuery);
		} catch (Exception e) {
			// TODO trocar isso aqui para log
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}

		return result;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public T findOneByField(String field, String condition, Object value) {
		
		// JPQL HQL
		Query query = this.getManager().createQuery("select c from " 
					+ this.getEntityClass().getSimpleName() 
					+ " as c where c." + field + " " + condition + " :value");
		query.setParameter("value", value);
		
		try {  
			return (T) query.getSingleResult();  
	    } catch (NoResultException e ) {  
	        return null;  
	    }  
	}

	private void populateQueryParameters(Query query, Map<String, Object> parameters) {
		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}
	
	public T findOneByField(String campo, String condicao, String valor) 	{
		T result = null;
		
		try {
			Query query = this.getManager().createQuery("select x from " + entityClass.getSimpleName() + " x " + "where x." + campo + " " + condicao + ":value");
			query.setParameter(campo, valor);
			result = (T) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO trocar isso aqui para log
			System.out.println("No result found");
		} catch (Exception e) {
			// TODO trocar isso aqui para log
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
	
	protected Session getSession() {
		return this.getManager().unwrap(Session.class);
	}
	
	protected EntityManager getManager() {
		return manager;
	}

	private Class<T> getEntityClass() {
		return entityClass;
	}

	private void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
