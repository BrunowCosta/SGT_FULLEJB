package br.com.empresa.sgt.business.acesso;

import br.com.empresa.sgt.business.remote.CrudBusiness;
import br.com.empresa.sgt.enumeration.TipoErroNegocio;
import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.model.acesso.Usuario;

public abstract class CrudBusinessAdapter<T> implements CrudBusiness<T>{

	@Override
	public void cadastrar(T modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(TipoErroNegocio.funcaoNaoImplementada.getDescricao(), 
									TipoErroNegocio.prefixoErroGenerico.getDescricao(), 
									BusinessException.SEVERITY_FATAL, null);
	}
	
	@Override
	public void alterar(T modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(TipoErroNegocio.funcaoNaoImplementada.getDescricao(), 
				TipoErroNegocio.prefixoErroGenerico.getDescricao(), 
				BusinessException.SEVERITY_FATAL, null);
	}

	@Override
	public T visualizar(Integer id) throws BusinessException {
		throw new BusinessException(TipoErroNegocio.funcaoNaoImplementada.getDescricao(), 
				TipoErroNegocio.prefixoErroGenerico.getDescricao(), 
				BusinessException.SEVERITY_FATAL, null);
	}
	
	@Override
	public void remover(T modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(TipoErroNegocio.funcaoNaoImplementada.getDescricao(), 
				TipoErroNegocio.prefixoErroGenerico.getDescricao(), 
				BusinessException.SEVERITY_FATAL, null);
	}
	
	@Override
	public void ativar(T modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(TipoErroNegocio.funcaoNaoImplementada.getDescricao(), 
				TipoErroNegocio.prefixoErroGenerico.getDescricao(), 
				BusinessException.SEVERITY_FATAL, null);
	}

	@Override
	public void inativar(T modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(TipoErroNegocio.funcaoNaoImplementada.getDescricao(), 
				TipoErroNegocio.prefixoErroGenerico.getDescricao(), 
				BusinessException.SEVERITY_FATAL, null);
	}
}
