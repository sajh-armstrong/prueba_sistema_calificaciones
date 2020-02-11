package cl.desafiolatam.Prueba_Sistema_Calificaciones.servicios;

import static cl.desafiolatam.Prueba_Sistema_Calificaciones.servicios.PromedioServicio.calcularPromedio;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PromedioServicioTest {
	
	@Test
	@DisplayName("Test calcularPromedio(List<Float> valores)")
	public void testcalcularPromedio()
	{
		assertEquals(5.2f, calcularPromedio(new ArrayList<Float>(Arrays.asList(3f, 5f, 7f, 6f, 5f))));
	}
	
}
