package cl.desafiolatam.Prueba_Sistema_Calificaciones;

import cl.desafiolatam.Prueba_Sistema_Calificaciones.vistas.Menu;

public class App 
{
    public static void main( String[] args )
    {
        try
        {
	    	Menu menu = new Menu();
	        
	    	menu.abrirScanner();
	        
	    	menu.iniciarMenu();
	        
	    	menu.cerrarScanner();
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
    }
}
