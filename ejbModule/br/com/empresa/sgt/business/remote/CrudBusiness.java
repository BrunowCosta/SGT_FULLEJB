package br.com.empresa.sgt.business.remote;

import java.util.List;

import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.model.acesso.Usuario;

public interface CrudBusiness<T> {
	
	public void cadastrar(T obj, Usuario usuario) throws BusinessException;
	
	public void alterar(T obj, Usuario usuario) throws BusinessException;
	
	public T visualizar(Integer id) throws BusinessException;
	
	public void remover(T obj, Usuario usuario) throws BusinessException;
	
	public void ativar(T obj, Usuario usuario) throws BusinessException;
	
	public void inativar(T	 obj, Usuario usuario) throws BusinessException;
	
	public List<T> pesquisar(T	 obj, Usuario usuario) throws BusinessException;
	
}
