package br.com.empresa.sgt.persistence.arq;

import java.util.List;

import br.com.empresa.sgt.exception.BusinessException;

public interface GenericDao<T, ID> {
	
	//TODO Verificar se precisa disso aqui
	public static final String CONDICAO_IGUAL = "=";
	
	public void persist(T obj) throws BusinessException;
	
	public void remove(T obj) throws BusinessException ;
	
	public T merge(T obj) throws BusinessException;
	
	public void refresh(T obj);
	
	public List<T> findAll();
	
	public List<T> findByExample(T obj);
	
	public T findById(ID id);
	
	public T findMaxField(String field);
	
	public T findMinId(ID id);
	
	public T findOneByField(String field, String codition, Object Value);

}
