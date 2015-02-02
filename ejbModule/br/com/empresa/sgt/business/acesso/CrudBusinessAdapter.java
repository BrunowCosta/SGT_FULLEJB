package br.com.empresa.sgt.business.acesso;

import java.util.List;

import br.com.empresa.sgt.business.remote.CrudBusiness;
import br.com.empresa.sgt.enumeration.MensagemEnum;
import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.exception.BusinessException.ErroNegocioServidadeEnum;
import br.com.empresa.sgt.model.acesso.Usuario;
import br.com.empresa.sgt.model.arq.Modelo;

public abstract class CrudBusinessAdapter<T extends Modelo> implements CrudBusiness<T>{

	@Override
	public void cadastrar(T modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(ErroNegocioServidadeEnum.FATAL, null, MensagemEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA);
	}
	
	@Override
	public void alterar(T modelo, Usuario usuario) throws BusinessException {
		throw new BusinessException(ErroNegocioServidadeEnum.FATAL, null, MensagemEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA);
	}

	@Override
	public T encontrar(Integer id) throws BusinessException {
		throw new BusinessException(ErroNegocioServidadeEnum.FATAL, null, MensagemEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA);
	}
	
	@Override
	public void remover(Integer id, Usuario usuario) throws BusinessException {
		throw new BusinessException(ErroNegocioServidadeEnum.FATAL, null, MensagemEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA);
	}
	
	@Override	
	public void ativarInativar(Integer id, boolean ativo, Usuario usuario) throws BusinessException {
		throw new BusinessException(ErroNegocioServidadeEnum.FATAL, null, MensagemEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA);
	}
	
	@Override
	public List<T> pesquisar(T obj) throws BusinessException {
		throw new BusinessException(ErroNegocioServidadeEnum.FATAL, null, MensagemEnum.ERRO_FUNCAO_NAO_IMPLEMENTADA);
	}

}
