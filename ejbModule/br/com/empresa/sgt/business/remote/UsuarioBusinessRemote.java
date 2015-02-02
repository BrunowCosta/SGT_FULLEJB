package br.com.empresa.sgt.business.remote;

import javax.ejb.Remote;

import br.com.empresa.sgt.model.acesso.Usuario;

@Remote
public interface UsuarioBusinessRemote extends CrudBusiness<Usuario> {

}
