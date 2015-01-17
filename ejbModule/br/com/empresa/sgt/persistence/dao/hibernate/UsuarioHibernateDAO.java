package br.com.empresa.sgt.persistence.dao.hibernate;
 
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.empresa.sgt.model.acesso.Usuario;
import br.com.empresa.sgt.persistence.arq.GenericHibernateDAO;
import br.com.empresa.sgt.persistence.dao.UsuarioDAO;

@Stateless
public class UsuarioHibernateDAO extends GenericHibernateDAO <Usuario, Integer> implements UsuarioDAO {
 
	public UsuarioHibernateDAO() {}
	
	public Usuario authenticate(String login, String senha){
       Map<String, Object> parameters = new HashMap<String, Object>();
       parameters.put("login", login);     
       parameters.put("senha", senha);     
 
       return super.findOneResult(Usuario.QUERY_AUTENTICACAO, parameters);
    }
}