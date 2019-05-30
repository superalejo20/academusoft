package co.edu.software.pruebas;

import java.text.ParseException;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.software.entidades.*;
import co.edu.software.excepciones.*;
import co.edu.software.negocio.*;
/**
 * Clase que contiene las pruebas  de las operaciones de negocio
 * 
 * @author John Alejandro Gonzalez

 * @version 1.0 
 *
 */

@RunWith(Arquillian.class)
public class TestEjb {
	
	public TestEjb() {

	}

	@EJB
	private ProyectoEJB proyectoJEB;
	
	@EJB
	private PersonaEJB personaEJB;
	
	/**
	 * Metodo de despliegue
	 */
	@Deployment
	public static Archive<?> createDeploymentPackage() {
		return ShrinkWrap.create(JavaArchive.class).addClass(PersonaEJB.class).addPackage(Persona.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	/**
	 * Prueba que registra el usuario
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void registrarTestEmpleado() {
		try {
			Estudiante estudianteo = new Estudiante();
			estudianteo.setCedula("1096445000");
			estudianteo.setNombre("Jennifer Castro");
			estudianteo.setCorreo("jennycastro@hotmail.com");
			estudianteo.setClave("jenny");

			Assert.assertTrue(personaEJB.registrarPersona(estudianteo));
		} catch (ElementoRepetidoException erx) {
			Assert.fail("El empleado ya existe");
		} catch (EmailRepetidoException er) {
			Assert.fail("El correo ya existe");
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}

	/**
	 * Prueba que permite listar los estudiantes
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void listarTestEstudiante() {
		try {
			Assert.assertTrue(personaEJB.listarEstudiante().size() == 4);
		} catch (NoExisteException e) {
			Assert.fail("Lo siento, No hay Estudiantes");
		}
	}

	/**
	 * Prueba que elimina a una persona
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void removeTestPersona() {
		try {
			Assert.assertTrue(personaEJB.eliminarPersona("41927815"));
		} catch (NoExisteException e) {
			Assert.fail("Lo siento, la persona que trata de eliminar no se encuentra registrado");

		}
	}

	/**
	 * Prueba que busca a una persona
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void buscarTestPersona() {
		try {
			Assert.assertEquals(personaEJB.buscarPersona("1094916789").getNombre(), "Alejandro Gonzalez");
		} catch (NoExisteException e) {
			Assert.fail("Lo siento, la persona no se pudo encontrar");
		}
	}

	/**
	 * Prueba que modifica a una persona
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void modificarTestPersona() {
		try {
			Persona persona = personaEJB.buscarPersona("1094916789");
			persona.setCorreo("superalejo20@yahoo.es");
			personaEJB.modificarPersona(persona);
			Persona modificado = personaEJB.buscarPersona("1094916789");
			Assert.assertFalse(modificado.getCorreo().equals("superalejo20@gmail.com"));
		} catch (NoExisteException e) {
			Assert.fail("Lo siento, la persona no se pudo encontrar");
		}
	}

	/**
	 * Prueba que permite probar la busqueda de un genero por su Fecha
	 
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/genero.json" })
	public void listarTestPorFecha() {
		try {
			Assert.assertEquals(generoJEB.listarGeneroPorFecha("2018-09-12").get(1).getId(), 1);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (NoExisteException e) {
			Assert.fail("No existen generos con en fecha ingresada");
		}
	}
*/
}
