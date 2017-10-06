package com.jcn.weatherapp.dao;

import java.util.List;
import java.util.Optional;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jcn.weatherapp.contracts.BaseDAO;
import com.jcn.weatherapp.model.User;

@Stateless
@LocalBean
public class UserDAO implements BaseDAO<User, Long> {

	@PersistenceContext(unitName = "moewe")
	private EntityManager em;
	
	@Override
	public void create(User entity) {
		em.persist(entity);
		
	}

	@Override
	public Optional<User> read(User entity, Long id) {
		User readUser = em.find(entity.getClass(), id);
		return Optional.ofNullable(readUser);
	}

	@Override
	public void update(User entity) {
		
		em.merge(entity);
		
		
	}

	@Override
	public void delete(User entity) {
		
		em.remove(em);
		
	}
	
	public Optional<List<User>> findAllUsers(){
		
		TypedQuery<User> findAllUsersQuery = em.createNamedQuery(User.USER_FINDALL, User.class);
		return Optional.ofNullable(findAllUsersQuery.getResultList());
	}
	
		
	public Optional<String> findUsersDefaultCity(User user){
		TypedQuery<String> findDefaultCity = em.createNamedQuery(User.USER_FINDDEFAULTCITY, String.class).setParameter("id", user.getId());			
		return Optional.ofNullable(findDefaultCity.getSingleResult());
	}

}
