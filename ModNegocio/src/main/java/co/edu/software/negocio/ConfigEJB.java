package co.edu.software.negocio;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.software.entidades.Administrador;



/**
 * Permite cargar la configuracion por defecto
 * @author John Alejandro Gonzalez

 * @version 1.0
 */
@Singleton
@LocalBean
@Startup
public class ConfigEJB {

	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ConfigEJB() {
    	
    }
    /**
     * Permite la creacion de un administrador por defecto si no hay registrados 
     */
    @PostConstruct
    public void iniConfig() {
    
//    	TypedQuery<Administrador> query = entityManager.createNamedQuery(Administrador.LISTAR_ADMINISTRADOR,Administrador.class);
//    	
//    	
//    	if(query.getResultList().size() == 0) {
//    		
    		Administrador administrador = new Administrador();
    		administrador.setCedula("1234567890");
    		administrador.setNombre("francisney");
    		administrador.setCorreo("francisney@hotmail.com");
    		administrador.setClave("12345");
    		entityManager.persist(administrador);
//    		    		
//    	}
    	
    }

}
