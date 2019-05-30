package co.edu.software.pruebas;

import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.software.entidades.*;

/**
 * clase que permite hacer test de pruebas en la bd
 * 
 * @author John Alejandro Gonzalez
 * @version 1.0
 */
@RunWith(Arquillian.class)
public class TestEntidades {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Crea las tablas en la bd
	 */
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(Persona.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	/**
	 * Prueba que crea un coordinador
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void persistTestCoordinador() {
		Coordinador coordinador = new Coordinador();
		coordinador.setCedula("555432");
		coordinador.setFecha(new Date());

		Proyecto proyecto = entityManager.find(Proyecto.class, 1);
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		proyectos.add(proyecto);
		coordinador.setMisProyectos(proyectos);

		entityManager.persist(coordinador);

		Coordinador registrado = entityManager.find(Coordinador.class, "555432");
		Assert.assertEquals(registrado.getFecha(), coordinador.getFecha());

	}

	/**
	 * Prueba que actualiza un coordinador de la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void modifyTestCoordinador() {

		Coordinador coordinador = entityManager.find(Coordinador.class, "1094916788");
		coordinador.setFecha(new Date());

		entityManager.merge(coordinador);

		Coordinador actualizado = entityManager.find(Coordinador.class, "1094916788");
		Assert.assertEquals(actualizado.getFecha(), coordinador.getFecha());
	}

	/**
	 * Prueba que Busca un coordinador de la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void searchTestCoordinador() {

		Coordinador c = entityManager.find(Coordinador.class, "1094916888");
		Assert.assertEquals("juang@gmail.com", c.getCorreo());
	}

	/**
	 * Prueba que elimina un coordinador de la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void removeTestCoodinador() {

		Coordinador g = entityManager.find(Coordinador.class, "1094916788");
		entityManager.remove(g);

		Coordinador eliminado = entityManager.find(Coordinador.class, "1094916788");
		Assert.assertNull(eliminado);
	}
	
	//
	/**
	 * Prueba que crea un tutor
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void persistTestTutor() {
		Tutor tutor = new Tutor();
		tutor.setCedula("444432");
		tutor.setFecha(new Date());

		Proyecto proyecto = entityManager.find(Proyecto.class, 1);
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		proyectos.add(proyecto);
		tutor.setMisProyectos(proyectos);

		entityManager.persist(tutor);

		Tutor registrado = entityManager.find(Tutor.class, "444432");
		Assert.assertEquals(registrado.getFecha(), tutor.getFecha());

	}

	/**
	 * Prueba que actualiza un tutor de la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void modifyTestTutor() {

		Tutor tutor = entityManager.find(Tutor.class, "1094666666");
		tutor.setFecha(new Date());

		entityManager.merge(tutor);

		Tutor actualizado = entityManager.find(Tutor.class, "1094666666");
		Assert.assertEquals(actualizado.getFecha(), tutor.getFecha());
	}

	/**
	 * Prueba que Busca un tutor de la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void searchTestTutor() {

		Tutor c = entityManager.find(Tutor.class, "24888888");
		Assert.assertEquals("sarasofiameza@gmail.com", c.getCorreo());
	}

	/**
	 * Prueba que elimina un tutor de la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void removeTestTutor() {

		Tutor g = entityManager.find(Tutor.class, "1094666677");
		entityManager.remove(g);

		Tutor eliminado = entityManager.find(Tutor.class, "1094666677");
		Assert.assertNull(eliminado);
	}
	
	//
	
//
	
	/**
	 * Prueba que crea a un administrador en la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void persistTestAdministrador() {
		Administrador administrador = new Administrador();
		administrador.setCedula("1234560000");
		administrador.setCorreo("admin@gmail.com");
		administrador.setClave("admin1");
		administrador.setNombre("Matias Almeida");

		entityManager.persist(administrador);

		administrador = entityManager.find(Administrador.class, "1234560000");
		Assert.assertEquals("admin@gmail.com", administrador.getCorreo());

	}

	/**
	 * Prueba que actualiza un administrador de la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void modifyTestAdministrador() {

		Administrador a = entityManager.find(Administrador.class, "1094916789");
		a.setNombre("Alejandro Cardenas");
		entityManager.merge(a);

		Administrador actualizado = entityManager.find(Administrador.class, "1094916789");
		Assert.assertEquals(actualizado.getNombre(), a.getNombre());
	}

	/**
	 * prueba que busca un administrador en la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void searchTestAdministrador() {

		Administrador e = entityManager.find(Administrador.class, "1094916789");
		Assert.assertEquals("superalejo20@gmail.com", e.getCorreo());

	}

	/**
	 * Prueba que elimina un administrador de la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void removeTestAdministrador() {

		Administrador adm = entityManager.find(Administrador.class, "1094916789");

		entityManager.remove(adm);

		Administrador eliminado = entityManager.find(Administrador.class, adm.getCedula());
		assertNull(eliminado);
	}
//
	/**
	 * Prueba que crea a un estudiante en la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void persistTestEstudiante() {
		Estudiante estudiante = new Estudiante();
		estudiante.setCedula("12345");
		estudiante.setCorreo("alfonso@gmail.com");
		estudiante.setClave("alfon40");
		estudiante.setNombre("alfonso cano");

		entityManager.persist(estudiante);

		estudiante = entityManager.find(Estudiante.class, "12345");
		Assert.assertEquals("alfonso@gmail.com", estudiante.getCorreo());

	}

	/**
	 * Prueba que actualiza un estudiante de la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void modifyTestEstudiante() {

		Estudiante estudiante = entityManager.find(Estudiante.class, "1094333333");
		estudiante.setNombre("isabel");
		entityManager.merge(estudiante);

		Estudiante actualizado = entityManager.find(Estudiante.class, "1094333333");
		Assert.assertEquals(actualizado.getNombre(), estudiante.getNombre());
	}

	/**
	 * prueba que busca un estudiante en la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void searchTestEstudiante() {

		Estudiante e = entityManager.find(Estudiante.class, "100000000");
		Assert.assertEquals("ccastano@gmail.com", e.getCorreo());

	}

	/**
	 * Prueba que elimina un estudiante de la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json" })
	public void removeTestEstudiante() {

		Estudiante em = entityManager.find(Estudiante.class, "1094333333");

		entityManager.remove(em);

		Estudiante eliminado = entityManager.find(Estudiante.class, em.getCedula());
		assertNull(eliminado);
	}

	

	/**
	 * Prueba que crea un proyecto
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/proyecto.json" })
	public void persistTestProyecto() {
		Proyecto proyecto = new Proyecto();
		proyecto.setId(17);
		proyecto.setFecha(new Date());	
		Estudiante encontrado = entityManager.find(Estudiante.class, "41927815");
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		estudiantes.add(encontrado);
		proyecto.setMisEstudiantes(estudiantes);
		
		entityManager.persist(proyecto);

		Proyecto registrado = entityManager.find(Proyecto.class, 17);
		Assert.assertEquals(registrado.getId(), proyecto.getId());

	}

	/**
	 * Prueba que actualiza un proyecto de la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/proyecto.json" })
	public void modifyTestProyecto() {

		Proyecto bl = entityManager.find(Proyecto.class, 1);
		bl.setDescripcion("solanaceas");

		entityManager.merge(bl);

		Proyecto actualizado = entityManager.find(Proyecto.class, 1);
		assert (bl.getDescripcion() == actualizado.getDescripcion());
	}

	/**
	 * Prueba que Busca un proyecto de la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/proyecto.json" })
	public void searchTestProyecto() {

		Proyecto bl = entityManager.find(Proyecto.class, 2);

		Assert.assertEquals(bl.getId(), 2);
	}

	/**
	 * Prueba que elimina un proyecto de la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/proyecto.json" })
	public void removeTestProyecto() {

		Proyecto bl = entityManager.find(Proyecto.class, 4);

		entityManager.remove(bl);

		Proyecto eliminado = entityManager.find(Proyecto.class, 4);
		assertNull(eliminado);
	}

	/**
	 * Prueba que crea una consulta
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/persona.json", "json/consulta.json" })
	public void persistTestConsulta() {

		Consulta consulta = new Consulta();
		consulta.setId(3);
		consulta.setPregunta("Cual es la fecha de sustentacion final?");
		consulta.setRespuesta("Señor estudiante buena pregunta...");

		Tutor tutor = entityManager.find(Tutor.class, "1094555555");
		consulta.setMiTutor(tutor);

		entityManager.persist(consulta);

		Consulta encontrado = entityManager.find(Consulta.class, consulta.getId());
		Assert.assertEquals(encontrado.getRespuesta(), consulta.getRespuesta());
	}

	/**
	 * Prueba que actualiza una Consulta de la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/consulta.json" })
	public void modifyTestConsulta() {

		Consulta consulta = entityManager.find(Consulta.class, 1);
		consulta.setPregunta("hay reunion hanitual tambien los dias festivos?");
		consulta.setRespuesta("Señor estudiante los dias festivos no hay atencion");

		entityManager.merge(consulta);

		Consulta actualizado = entityManager.find(Consulta.class, 1);
		Assert.assertEquals(actualizado.getRespuesta(), "Señor estudiante los dias festivos no hay atencion");

	}

	/**
	 * Prueba la busqueda de una consulta en la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/consulta.json" })
	public void searchTestConsulta() {
		Consulta consulta = entityManager.find(Consulta.class, 3);
		Assert.assertEquals(consulta.getId(), 3);
	}

	/**
	 * Prueba que elimina una consulta de la bd
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "json/consulta.json" })
	public void removeTestConsulta() {
		Consulta consulta = entityManager.find(Consulta.class, 2);
		entityManager.remove(consulta);

		Consulta eliminado = entityManager.find(Consulta.class, 2);
		Assert.assertNull(eliminado);
	}

		
}
