package br.com.empresa.sgt.persistence.dao.hibernate;
 
import javax.ejb.Stateless;

import br.com.empresa.sgt.model.acesso.RegistroAcesso;
import br.com.empresa.sgt.persistence.arq.GenericHibernateDAO;
import br.com.empresa.sgt.persistence.dao.RegistroAcessoDAO;
 
@Stateless
public class RegistroAcessoHibernateDAO extends GenericHibernateDAO<RegistroAcesso, Integer> implements RegistroAcessoDAO{
 
	public RegistroAcessoHibernateDAO() {}
	
}