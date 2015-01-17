package br.com.empresa.sgt.business.remote;

import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.model.acesso.Usuario;
import br.com.empresa.sgt.model.arq.Modelo;

public interface CrudBusiness<T> {
	
	public void cadastrar(T obj, Usuario usuario) throws BusinessException;
	
	public void alterar(Modelo obj, Usuario usuario) throws BusinessException;
	
	public Modelo visualizar(Integer id) throws BusinessException;
	
	public void remover(Modelo obj, Usuario usuario) throws BusinessException;
	
	public void ativar(Modelo obj, Usuario usuario) throws BusinessException;
	
	public void inativar(Modelo obj, Usuario usuario) throws BusinessException;
	
	
}
