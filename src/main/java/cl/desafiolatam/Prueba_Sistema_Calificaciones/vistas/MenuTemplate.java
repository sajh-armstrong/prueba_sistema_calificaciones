package cl.desafiolatam.Prueba_Sistema_Calificaciones.vistas;


import static cl.desafiolatam.Prueba_Sistema_Calificaciones.utilidades.Mensaje.*;

import java.util.Scanner;


public abstract class MenuTemplate {
	
	protected Scanner scanner;
	
	public void abrirScanner()
	{
		scanner = new Scanner(System.in);
	}
	
	public void abrirScanner(Readable fuente)
	{
		scanner = new Scanner(fuente);
	}
	
	public void cerrarScanner()
	{
		scanner.close();
	}
	
	public void cargarDatos()
	{
		//TODO implementar
	}
	
	public void exportarDatos()
	{
		//TODO implementar
	}
	
	public void crearAlumno()
	{
		
	}
	
	public void agregarMateria()
	{
		//TODO implementar
	}
	
	public void agregarNotaPasoUno()
	{
		//TODO implementar
	}
	
	public void listarAlumnos()
	{
		//TODO implementar
	}
	
	public void terminarPrograma()
	{
		//TODO implementar
	}
	
	public void iniciarMenu()
	{
		String opcion;
			
		System.out.print(	"\n1 - Crear Alumnos\n" +
							"2 - Listar Alumnos\n" +
							"3 - Agregar Materias\n" +
							"4 - Agregar Notas\n" +
							"5 - Cargar Datos\n" +
							"6 - Exportar Datos\n" +
							"7 - Salir\n" +
							"Selección: ");
		opcion = scanner.nextLine();
		switch(opcion)
		{
			case "1":
				crearAlumno();
				break;
			case "3":
				agregarMateria();
				break;
			case "7":
				despedidaMsg();
				terminarPrograma();
			
			default:
				opcionNoValidaMsg();
				lineasMsg();
				
		}
		iniciarMenu();
	}
	
}
