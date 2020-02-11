package cl.desafiolatam.Prueba_Sistema_Calificaciones.vistas;


import cl.desafiolatam.Prueba_Sistema_Calificaciones.servicios.AlumnoServicio;
import static cl.desafiolatam.Prueba_Sistema_Calificaciones.utilidades.Mensaje.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

import cl.desafiolatam.Prueba_Sistema_Calificaciones.modelos.Alumno;
import cl.desafiolatam.Prueba_Sistema_Calificaciones.modelos.Materia;
import cl.desafiolatam.Prueba_Sistema_Calificaciones.modelos.MateriaEnum;

public class Menu extends MenuTemplate{
	
	private AlumnoServicio alumnoServicio = new AlumnoServicio();
	
	public AlumnoServicio getAlumnoServicio() {
		return alumnoServicio;
	}

	@Override
	public void cargarDatos() {
//		TODO ARREGLAR ESTA WEAAAAA
		lineasMsg();
		System.out.println(	"Cargar Datos\n\n"+
							"Ingrese nombre del archivo a cargar: ");
		try {
			FileReader fr = new FileReader(scanner.nextLine());
			BufferedReader br = new BufferedReader(fr);
			
			String lineaArchivo = br.readLine();
			
			while(lineaArchivo != null)
			{
				List<String> lista = new ArrayList<String>(Arrays.asList(lineaArchivo.split(",")));
				Alumno nuevoAlumno = new Alumno();
				
				for(int i = 0; i < lista.size(); i++)
				{
					if(i == 0) nuevoAlumno.setRut(lista.get(i));
					else if(i == 1) nuevoAlumno.setNombre(lista.get(i));
					else if(i == 2)
					{
						MateriaEnum nuevaMateria = null;
						for(MateriaEnum temp : MateriaEnum.values())
							if(temp.toString().equalsIgnoreCase(lista.get(i)))
								nuevaMateria = temp;
						
						int contador = 0;
						for(Materia temp : nuevoAlumno.getMaterias())
							if(temp.getNombre().toString().equalsIgnoreCase(lista.get(i)))
								contador++;
						
						if(contador == 0)
						{
							nuevoAlumno.getMaterias().add(new Materia(nuevaMateria));
						}
					}
					else if(i == 3) nuevoAlumno.setDireccion(lista.get(i));
						
				}
			}
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void exportarDatos() {
		// TODO Auto-generated method stub
		super.exportarDatos();
	}
	@Override
	public void crearAlumno() {
		
		Alumno nuevoAlumno = new Alumno();
		
		lineasMsg();
		
		System.out.println("Crear Alumno\n");
		
		nuevoAlumno.setRut(scanRutAlumno());
		
		System.out.print("Ingrese Nombre: ");
		nuevoAlumno.setNombre(scanner.nextLine());
		
		System.out.print("Ingrese Apellido: ");
		nuevoAlumno.setApellido(scanner.nextLine());
		
		System.out.print("Ingrese Dirección: ");
		nuevoAlumno.setDireccion(scanner.nextLine());
		
		System.out.println(alumnoServicio.crearAlumno(nuevoAlumno));
	}
	@Override
	public void agregarMateria() {
		
		String rutAlumno = "";
		
		lineasMsg();
		
		System.out.println("Agregar Materia\n");
		rutAlumno = scanRutAlumno();
		
		if(alumnoServicio.existeAlumno(rutAlumno))
		{
			System.out.print(	"\n1. MATEMATICA\n" +
								"2. LENGUAJE\n" +
								"3. CIENCIA\n" +
								"4. HISTORIA\n\n" +
								"Seleccione una Materia: ");
			switch(scanner.nextLine())
			{
				
				case "1":
					System.out.println(alumnoServicio.agregarMateria(rutAlumno, new Materia(MateriaEnum.values()[0])));			
					break;
					
				case "2":
					System.out.println(alumnoServicio.agregarMateria(rutAlumno, new Materia(MateriaEnum.values()[1])));			
					break;
					
				case "3":
					System.out.println(alumnoServicio.agregarMateria(rutAlumno, new Materia(MateriaEnum.values()[2])));			
					break;
					
				case "4":
					System.out.println(alumnoServicio.agregarMateria(rutAlumno, new Materia(MateriaEnum.values()[3])));			
					break;
					
				default:
					System.out.println("Materia No Existe :C");
			}
		}
	}
	
	@Override
	public void agregarNotaPasoUno()
	{
		String rutAlumno = "";
		
		lineasMsg();
		
		System.out.println("Agregar Nota\n");
		
		rutAlumno = scanRutAlumno();
		
		if(alumnoServicio.existeAlumno(rutAlumno))
		{
			Alumno alumno = alumnoServicio.listarAlumnos().get(rutAlumno);
			List<Materia> materias = new ArrayList<Materia>();
			
			System.out.printf("%s %s tiene las siguientes materias agregadas:\n", alumno.getNombre(), alumno.getApellido());
			for(int i = 0; i < materias.size(); i++)
			{
				System.out.printf("%d - %s\n", i + 1, alumno.getMaterias().get(i).getNombre().toString());
			}
			System.out.print("Seleccione Materia: ");
			
			try
			{
				int materiaOpcion = Integer.parseInt(scanner.nextLine());
				
				if(materiaOpcion > materias.size())
				{
					opcionNoValidaMsg();
				}
				else
				{
					System.out.println("Ingrese Nota: ");
					
					try
					{
						float nota = scanner.nextFloat();
						
						if(nota < 1f || nota > 7f)
							opcionNoValidaMsg();
						else
							alumnoServicio.agregarNota(alumno.getRut(), materias.get(materiaOpcion).getNombre(), nota);
					}
					catch(InputMismatchException e)
					{
						opcionNoValidaMsg();
					}
				}
			}
			catch(NumberFormatException e)
			{
				opcionNoValidaMsg();
			}
		}
		
	}
	@Override
	public void listarAlumnos() {
//		TODO implementar
	}
	@Override
	public void terminarPrograma() {
		System.exit(0);
	}
	
	public String scanRutAlumno()
	{
		System.out.print("Ingrese RUT Alumno: ");
		return scanner.nextLine();
	}
}
