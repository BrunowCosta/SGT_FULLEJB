package br.com.empresa.sgt.persistence.dao.hibernate;
 
import javax.ejb.Stateless;

import br.com.empresa.sgt.model.acesso.GrupoPermissao;
import br.com.empresa.sgt.persistence.arq.GenericHibernateDAO;
import br.com.empresa.sgt.persistence.dao.GrupoPermissaoDAO;

@Stateless
public class GrupoPermissaoHibernateDAO extends GenericHibernateDAO<GrupoPermissao, Integer> implements GrupoPermissaoDAO {
 
	public GrupoPermissaoHibernateDAO() {}
	
}