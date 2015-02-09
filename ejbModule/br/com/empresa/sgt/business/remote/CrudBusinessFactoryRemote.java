package br.com.empresa.sgt.business.remote;

import javax.ejb.Remote;

import br.com.empresa.sgt.model.acesso.GrupoPermissao;

@Remote
public interface CrudBusinessFactoryRemote {

	public CrudBusiness<GrupoPermissao> getBusinessClass();
}
