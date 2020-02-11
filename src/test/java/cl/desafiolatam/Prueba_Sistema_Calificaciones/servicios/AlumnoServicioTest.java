package cl.desafiolatam.Prueba_Sistema_Calificaciones.servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.desafiolatam.Prueba_Sistema_Calificaciones.modelos.Alumno;
import cl.desafiolatam.Prueba_Sistema_Calificaciones.modelos.Materia;
import cl.desafiolatam.Prueba_Sistema_Calificaciones.modelos.MateriaEnum;

public class AlumnoServicioTest {
	
	private static AlumnoServicio 	alumnoServicio,
									alumnoServicioMock;
	private static MateriaEnum matematicas,
						lenguaje;
	private static List<Materia> listaMaterias;
	private static Alumno alumno;
	private static Map<String, Alumno> listaAlumnos;
	
	@BeforeAll
	private static void setup()
	{
		alumnoServicioMock = mock(AlumnoServicio.class);
		
		matematicas = MateriaEnum.MATEMATICAS;
		lenguaje = MateriaEnum.LENGUAJE;
		
		listaMaterias = new ArrayList<Materia>(Arrays.asList(new Materia(matematicas, new ArrayList<Float>()),
															new Materia(lenguaje, new ArrayList<Float>())));
		
		alumno = new Alumno("1", "Aquiles", "Baeza", "Av. Parada 42", new ArrayList<Materia>(Arrays.asList(new Materia())));
		
		listaAlumnos = new TreeMap<String, Alumno>();
		listaAlumnos.put("1", new Alumno("1", "Aquiles", "Baeza", "Av. Parada 42", listaMaterias));
		listaAlumnos.put("2", new Alumno("2", "Stefan", "Pino", "Av. La Torre 9", new ArrayList<Materia>()));
	}
	
	@BeforeEach
	private void setupAlumnoServicio()
	{
		alumnoServicio = new AlumnoServicio();
		alumnoServicio.crearAlumno(listaAlumnos.get("1"));
		alumnoServicio.crearAlumno(listaAlumnos.get("2"));
	}
	
	@Test
	@DisplayName("test para crearAlumno(Alumno alumno)")
	public void crearAlumnoTest()
	{
		assertEquals("Alumno Creado", alumnoServicio.crearAlumno(alumno));
	}
	
	@Test
	@DisplayName("test para agregarMateria(String rutAlumno, Materia materiaActual)")
	public void agregarMateriaTest()
	{
		assertEquals("Materia Agregada", alumnoServicio.agregarMateria("1", new Materia()));
		assertEquals("Usuario no Existe", alumnoServicio.agregarMateria("89", new Materia()));
	}
	
	@Test
	@DisplayName("mock test para materiasPorAlumnos(String rutAlumno)")
	public void materiasPorAlumnosMockTest()
	{
		when(alumnoServicioMock.materiasPorAlumnos("8")).thenReturn(listaMaterias);
		assertEquals(listaMaterias, alumnoServicioMock.materiasPorAlumnos("8"));
		verify(alumnoServicioMock).materiasPorAlumnos("8");
	}
	
	@Test
	@DisplayName("test para materiasPorAlumnos(String rutAlumno)")
	public void materiasPorAlumnosTest()
	{
		assertEquals(listaMaterias, alumnoServicio.materiasPorAlumnos("1"));
		assertEquals(new ArrayList<Materia>(), alumnoServicio.materiasPorAlumnos("2"));
	}
	
	@Test
	@DisplayName("test para listarAlumnos()")
	public void listarAlumnosTest()
	{	
		assertEquals(listaAlumnos, alumnoServicio.listarAlumnos());
	}
	
	
}
