package br.com.empresa.sgt.business.acesso;

import br.com.empresa.sgt.business.remote.CrudBusiness;
import br.com.empresa.sgt.enumeration.ErroNegocioEnum;
import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.exception.BusinessException.ErroNegocioPrefixoEnum;
import br.com.empresa.sgt.exception.BusinessException.ErroNegocioServidadeEnum;
import br.com.empresa.sgt.model.acesso.Usuario;
import br.com.empresa.sgt.model.arq.Modelo;

public abstract class CrudBusinessAdapter<T extends Modelo> implements CrudBusiness<T>{

	@Override
	public void cadastrar(T modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(ErroNegocioEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA.getDescricao(),
									ErroNegocioEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA,
									ErroNegocioPrefixoEnum.GENERICO, 
									ErroNegocioServidadeEnum.FATAL, null);
	}
	
	@Override
	public void alterar(T modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(ErroNegocioEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA.getDescricao(),
									ErroNegocioEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA,
									ErroNegocioPrefixoEnum.GENERICO, 
									ErroNegocioServidadeEnum.FATAL, null);
	}

	@Override
	public T visualizar(Integer id) throws BusinessException {
		throw new BusinessException(ErroNegocioEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA.getDescricao(),
									ErroNegocioEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA,
									ErroNegocioPrefixoEnum.GENERICO, 
									ErroNegocioServidadeEnum.FATAL, null);
	}
	
	@Override
	public void remover(T modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(ErroNegocioEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA.getDescricao(),
									ErroNegocioEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA,
									ErroNegocioPrefixoEnum.GENERICO, 
									ErroNegocioServidadeEnum.FATAL, null);
	}
	
	@Override
	public void ativar(T modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(ErroNegocioEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA.getDescricao(),
									ErroNegocioEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA,
									ErroNegocioPrefixoEnum.GENERICO, 
									ErroNegocioServidadeEnum.FATAL, null);
	}

	@Override
	public void inativar(T modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(ErroNegocioEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA.getDescricao(),
									ErroNegocioEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA, 
									ErroNegocioPrefixoEnum.GENERICO, 
									ErroNegocioServidadeEnum.FATAL, null);
	}
}
