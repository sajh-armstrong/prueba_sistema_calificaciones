package cl.desafiolatam.Prueba_Sistema_Calificaciones.servicios;

import java.util.List;

public class PromedioServicio {
	
	public static Float calcularPromedio(List<Float> notas)
	{
		return notas.stream().reduce(0f, (a, b) -> a + b) / notas.size();
	}
	
}
