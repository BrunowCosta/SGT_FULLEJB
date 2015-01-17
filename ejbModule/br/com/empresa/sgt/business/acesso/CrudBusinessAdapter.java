package br.com.empresa.sgt.business.acesso;

import br.com.empresa.sgt.business.remote.CrudBusiness;
import br.com.empresa.sgt.enumeration.TipoErroNegocio;
import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.model.acesso.Usuario;
import br.com.empresa.sgt.model.arq.Modelo;

public abstract class CrudBusinessAdapter implements CrudBusiness<Modelo>{

	@Override
	public void cadastrar(Modelo modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(TipoErroNegocio.funcaoNaoImplementada.getDescricao(), 
									TipoErroNegocio.prefixoErroGenerico.getDescricao(), 
									BusinessException.SEVERITY_FATAL, null);
	}
	
	@Override
	public void alterar(Modelo modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(TipoErroNegocio.funcaoNaoImplementada.getDescricao(), 
				TipoErroNegocio.prefixoErroGenerico.getDescricao(), 
				BusinessException.SEVERITY_FATAL, null);
	}

	@Override
	public Modelo visualizar(Integer id) throws BusinessException {
		throw new BusinessException(TipoErroNegocio.funcaoNaoImplementada.getDescricao(), 
				TipoErroNegocio.prefixoErroGenerico.getDescricao(), 
				BusinessException.SEVERITY_FATAL, null);
	}
	
	@Override
	public void remover(Modelo modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(TipoErroNegocio.funcaoNaoImplementada.getDescricao(), 
				TipoErroNegocio.prefixoErroGenerico.getDescricao(), 
				BusinessException.SEVERITY_FATAL, null);
	}
	
	@Override
	public void ativar(Modelo modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(TipoErroNegocio.funcaoNaoImplementada.getDescricao(), 
				TipoErroNegocio.prefixoErroGenerico.getDescricao(), 
				BusinessException.SEVERITY_FATAL, null);
	}

	@Override
	public void inativar(Modelo modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(TipoErroNegocio.funcaoNaoImplementada.getDescricao(), 
				TipoErroNegocio.prefixoErroGenerico.getDescricao(), 
				BusinessException.SEVERITY_FATAL, null);
	}
}
