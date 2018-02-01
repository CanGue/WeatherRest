package com.jcn.weatherapp.webservice;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jcn.weatherapp.Interceptor.ExceptionLogger;
import com.jcn.weatherapp.model.User;

@Stateless
@Path("/user")
@Interceptors(ExceptionLogger.class)
public class UserService {



	@EJB
	private CurrentWeatherService currentWeatherService;

	@PersistenceContext(unitName = "weather")
	private EntityManager em;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() {

		TypedQuery<User> findAllUsersQuery = em.createNamedQuery(User.USER_FINDALL, User.class);
		List<User> allUsers = findAllUsersQuery.getResultList();
		
		return Response.ok().entity(allUsers).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{userid}")
	public Response getUser(@PathParam("userid") Long userid) {
		Optional<User> user = Optional.ofNullable(em.find(User.class, userid));

		return user.map(v -> Response.ok().entity(v).build()).orElse(Response.noContent().build());
	}


}
