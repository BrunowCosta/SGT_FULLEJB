package br.com.empresa.sgt.business.remote;

import java.util.List;

import javax.ejb.Remote;

import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.model.acesso.Usuario;
import br.com.empresa.sgt.model.arq.Modelo;

@Remote
public interface CrudBusiness<T extends Modelo> {
	
	public T cadastrar(T obj, Usuario usuario) throws BusinessException;
	
	public void alterar(T obj, Usuario usuario) throws BusinessException;
	
	public T encontrar(Integer id) throws BusinessException;
	
	public void remover(Integer id, Usuario usuario) throws BusinessException;
	
	public void ativarInativar(Integer id, boolean ativo, Usuario usuario) throws BusinessException;
	
	public List<T> pesquisar(T obj) throws BusinessException;
	
}
