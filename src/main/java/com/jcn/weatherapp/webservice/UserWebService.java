package com.jcn.weatherapp.webservice;

import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jcn.weatherapp.Interceptor.RestLogger;
import com.jcn.weatherapp.dao.UserDAO;
import com.jcn.weatherapp.model.User;

@Stateless
@Path("/users")
@Interceptors(RestLogger.class)
public class UserWebService {

	@EJB
	private UserDAO userDAO;
	
	@EJB
	private CurrentWeatherService currentWeatherService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() {

		return userDAO.findAllUsers().map(v -> Response.ok().entity(v).build()).orElse(Response.noContent().build());
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{userid}")
	public Response getUser(@PathParam("userid") Long userid) {
		return userDAO.read(new User(), userid).map(v -> Response.ok().entity(v).build())
				.orElse(Response.noContent().build());
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{userid}/defaultCity")
	public Response getUserDefaultCiry(@PathParam("userid") Long userid)
	{
		User user = new User();
		user.setId(userid);
		return userDAO.findUsersDefaultCity(user).map(v -> Response.ok().entity(v).build()).orElse(Response.noContent().build());
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{userid}/defaultCity/currentWeather")
	public Response getCurrentWeatherOfUsersDefaultlCity(@PathParam("userid") Long userid){
		User user = new User();
		user.setId(userid);
		Optional<String> findUsersDefaultCity = userDAO.findUsersDefaultCity(user);
		return currentWeatherService.getCurrenWeatherByCity(findUsersDefaultCity.get());
	}

}
