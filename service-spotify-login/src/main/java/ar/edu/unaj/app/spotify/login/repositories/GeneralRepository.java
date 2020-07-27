package ar.edu.unaj.app.spotify.login.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class GeneralRepository  {

	@PersistenceContext
	private EntityManager manager;

	public Object SetEntity(Object parametro) {
		return manager.merge(parametro);
	}

	public <T> void DelEntity(Class<T> Entity,Object id) {
		T entityvuelta = manager.find(Entity, id);
		manager.remove(entityvuelta);
	}
	
	public <T> void UpdateEntity(String NamedQuery,Object...parametros) {
		Query query = manager.createNamedQuery(NamedQuery);
		for (int i = 0; i < parametros.length; i++) {
			query.setParameter("param"+(i+1), parametros[i]);
		}
		query.executeUpdate();
	}
	
	public <T> List<T> GetEntity(String NamedQuery,Class<T> entityretorno,Object...parametros){
		TypedQuery<T> query = manager.createNamedQuery(NamedQuery, entityretorno);
		for (int i = 0; i < parametros.length; i++) {
			query.setParameter("param"+(i+1), parametros[i]);
		}
		return query.getResultList();
	}
}

