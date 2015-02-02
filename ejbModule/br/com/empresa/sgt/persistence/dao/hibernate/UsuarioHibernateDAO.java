package br.com.empresa.sgt.persistence.dao.hibernate;
 
import javax.ejb.Stateless;

import br.com.empresa.sgt.model.acesso.Usuario;
import br.com.empresa.sgt.persistence.arq.GenericHibernateDAO;
import br.com.empresa.sgt.persistence.dao.UsuarioDAO;

@Stateless
public class UsuarioHibernateDAO extends GenericHibernateDAO <Usuario, Integer> implements UsuarioDAO {
 
	public UsuarioHibernateDAO() {}
	
}