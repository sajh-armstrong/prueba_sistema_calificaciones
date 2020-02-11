package cl.desafiolatam.Prueba_Sistema_Calificaciones.servicios;

import java.util.Map;
import java.util.TreeMap;

import static cl.desafiolatam.Prueba_Sistema_Calificaciones.utilidades.Mensaje.*;

import java.util.List;

import cl.desafiolatam.Prueba_Sistema_Calificaciones.modelos.Alumno;
import cl.desafiolatam.Prueba_Sistema_Calificaciones.modelos.Materia;
import cl.desafiolatam.Prueba_Sistema_Calificaciones.modelos.MateriaEnum;

public class AlumnoServicio {
	
	private Map<String, Alumno> listaAlumnos = new TreeMap<String, Alumno>();
	
	public String crearAlumno(Alumno alumno) {
		listaAlumnos.put(alumno.getRut(), alumno);
		return "Alumno Creado";
	}
	
	public String agregarMateria(String rutAlumno, Materia materiaActual)
	{
		if(listaAlumnos.containsKey(rutAlumno))
		{	
			List<Materia> materias = listaAlumnos.get(rutAlumno).getMaterias();
			boolean checkMateriaExiste = false;
			
			if(materias.size() != 0)
				for(Materia temp : materias)
					if(temp.getNombre() == materiaActual.getNombre())
						checkMateriaExiste = true;
			
			if(checkMateriaExiste)
			{
				return materiaExisteMsg();
			}
			else
				listaAlumnos.get(rutAlumno).getMaterias().add(materiaActual);
				return materiaCreadaMsg();
		}
		else
			return "Usuario no Existe";
	}
	public List<Materia> materiasPorAlumnos(String rutAlumno)
	{
		return listaAlumnos.get(rutAlumno).getMaterias();
	}
	
	public Map<String, Alumno> listarAlumnos()
	{
		return listaAlumnos;
	}
	
	public boolean existeAlumno(String rutAlumno)
	{
		if(listaAlumnos.get(rutAlumno) == null)
		{
			System.out.println("Alumno No Existe :C");
			return false;
		}
		else
			return true;
	}
	
	public boolean agregarNota(String rutAlumno, MateriaEnum nombreMateria, float nota)
	{
		boolean resultado = false;
		List<Materia> materias = listaAlumnos.get(rutAlumno).getMaterias();
		
		for(int i = 0; i < materias.size(); i++)
		{
			if(materias.get(i).getNombre() == nombreMateria)
			{
				listaAlumnos.get(rutAlumno).getMaterias().get(i).getNotas().add(nota);
				resultado = true;
			}
		}
		
		return resultado;
	}
}
