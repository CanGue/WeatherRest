package com.jcn.weatherapp.webservice;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jcn.weatherapp.Interceptor.ExceptionLogger;
import com.jcn.weatherapp.businesslogic.CurrentWeatherData;

@Interceptors(ExceptionLogger.class)
@Path("/currentweather")
@Stateless
public class CurrentWeatherService {

	@EJB
	private CurrentWeatherData currentWeatherData;
  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{city}")
    public Response getCurrenWeatherByCity(@PathParam("city") String city) {
     
        return currentWeatherData.getCurrentWeatherForCity(city).map(v -> Response.ok().entity(v).build())
                .orElse(Response.noContent().build());
    }
    
    
    
    
   

}
