package cl.desafiolatam.Prueba_Sistema_Calificaciones.vistas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.desafiolatam.Prueba_Sistema_Calificaciones.modelos.Alumno;
import cl.desafiolatam.Prueba_Sistema_Calificaciones.modelos.Materia;
import cl.desafiolatam.Prueba_Sistema_Calificaciones.modelos.MateriaEnum;


public class MenuTest {
	
	private static Menu menuTest;
	private static StringReader datosAlumno,
								archivoCargar,
								datosMateria02,
								datosMateria01Mates,
								datosMateria01Leng,
								datosMateria01Ciencia,
								datosMateria01Hist,
								datosNotas01;
	private static Alumno alumnoTest;
	private static List<Materia> materiasTest;
	
	@BeforeAll
	private static void setup()
	{
		datosAlumno = new StringReader("1\nAquiles\nBaeza\nAv. Parada 42\n");
		archivoCargar = new StringReader("notas.csv\n");
		datosMateria02 = new StringReader("2\n1\n");
		datosMateria01Mates = new StringReader("1\n1\n");
		datosMateria01Leng = new StringReader("1\n2\n");
		datosMateria01Ciencia = new StringReader("1\n3\n");
		datosMateria01Hist = new StringReader("1\n4\n");
		datosNotas01 = new StringReader("1\n1\n5\n");
	}
	
	@BeforeEach
	private void setupMenuData()
	{
		menuTest = new Menu();
		
		materiasTest = new ArrayList<Materia>();
		alumnoTest = new Alumno("1", "Aquiles", "Baeza", "Av. Parada 42", materiasTest);
	}
	
	@Test
	@DisplayName("test para crearAlumno()")
	public void crearAlumnoTest()
	{
		menuTest.abrirScanner(datosAlumno);
		menuTest.crearAlumno();
		menuTest.cerrarScanner();
		assertEquals(1, menuTest.getAlumnoServicio().listarAlumnos().size());
	}
	
	@Test
	@DisplayName("Test - void agregarMateria()")
	public void agregarMateriaTest()
	{
		menuTest.abrirScanner(datosMateria02);
		menuTest.agregarMateria();
		menuTest.cerrarScanner();
		assertEquals(0, menuTest.getAlumnoServicio().listarAlumnos().get("1").getMaterias().size());
		
		menuTest.abrirScanner(datosMateria01Mates);
		menuTest.agregarMateria();
		menuTest.cerrarScanner();
		assertEquals(MateriaEnum.MATEMATICAS, menuTest.getAlumnoServicio().listarAlumnos().get("1").getMaterias().get(0).getNombre());
		
		menuTest.abrirScanner(datosMateria01Leng);
		menuTest.agregarMateria();
		menuTest.cerrarScanner();
		assertEquals(MateriaEnum.LENGUAJE, menuTest.getAlumnoServicio().listarAlumnos().get("1").getMaterias().get(1).getNombre());
		
		menuTest.abrirScanner(datosMateria01Ciencia);
		menuTest.agregarMateria();
		menuTest.cerrarScanner();
		assertEquals(MateriaEnum.CIENCIA, menuTest.getAlumnoServicio().listarAlumnos().get("1").getMaterias().get(2).getNombre());
		
		menuTest.abrirScanner(datosMateria01Hist);
		menuTest.agregarMateria();
		menuTest.cerrarScanner();
		assertEquals(MateriaEnum.HISTORIA, menuTest.getAlumnoServicio().listarAlumnos().get("1").getMaterias().get(3).getNombre());
		
		datosMateria01Mates = new StringReader("1\n1\n");
		menuTest.abrirScanner(datosMateria01Mates);
		menuTest.agregarMateria();
		menuTest.cerrarScanner();
		assertEquals(4, menuTest.getAlumnoServicio().listarAlumnos().get("1").getMaterias().size());
	}
	
	@Test
	@DisplayName("Test - void agregarNotaPasoUno()")
	public void agregarNotaPasoUnoTest()
	{
		menuTest.abrirScanner(datosNotas01);
		menuTest.agregarNotaPasoUno();
		menuTest.cerrarScanner();
		assertEquals(5f, menuTest.getAlumnoServicio().listarAlumnos().get("1").getMaterias().get(0).getNotas().get(0));
	}
	
//	@Test
//	@DisplayName("test para cargarDatos()")
//	public void cargarDatosTest()
//	{
//		menuTest.abrirScanner(archivoCargar);
//		menuTest.cargarDatos();
//		menuTest.cerrarScanner();
//		assertEquals(2, menuTest.getAlumnoServicio().listarAlumnos().size());
//	}
}
