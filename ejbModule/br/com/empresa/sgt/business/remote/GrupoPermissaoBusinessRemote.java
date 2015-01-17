package br.com.empresa.sgt.business.remote;

import java.util.List;

import javax.ejb.Remote;

import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.model.acesso.GrupoPermissao;
import br.com.empresa.sgt.model.acesso.Usuario;

@Remote
public interface GrupoPermissaoBusinessRemote extends CrudBusiness{

	public List<GrupoPermissao> pesquisar(GrupoPermissao grupo, Usuario usuario) throws BusinessException;
	
}
