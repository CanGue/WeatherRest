package com.jcn.weatherapp.configuration;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcn.weatherapp.dao.UserDAO;
import com.jcn.weatherapp.model.City;
import com.jcn.weatherapp.model.User;

// Erzeugt Testdaten und ist nur für Demozwecke notwendig
@Singleton
@Startup
public class Bootstrapper {
    
   @PersistenceContext(unitName ="moewe")
   private EntityManager em;
    
    @PostConstruct
    public void init(){      

   
    	User persistUser = new User();
    	persistUser.setAge(12);
    	String password = "MeinPasswort";
        persistUser.setPassword(password);   	
    	persistUser.setFirstName("Can");
    	persistUser.setLastName("Güler");
    	City city = new City("Ansbach");
    	persistUser.setPlaceHolderCityName("Ansbach");
    
    	
        em.persist(persistUser);
        em.persist(persistUser);

    	
    
    }
}
