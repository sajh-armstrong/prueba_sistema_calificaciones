package cl.desafiolatam.Prueba_Sistema_Calificaciones.modelos;

import java.util.ArrayList;
import java.util.List;

public class Materia {

	private MateriaEnum nombre;
	private List<Float> notas = new ArrayList<Float>();
	
	public Materia() {
		super();
	}

	public Materia(MateriaEnum nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Materia(MateriaEnum nombre, List<Float> notas) {
		super();
		this.nombre = nombre;
		this.notas = notas;
	}

	public MateriaEnum getNombre() {
		return nombre;
	}
	
	public void setNombre(MateriaEnum nombre) {
		this.nombre = nombre;
	}
	
	public List<Float> getNotas() {
		return notas;
	}
	
	public void setNotas(List<Float> notas) {
		this.notas = notas;
	}
	
}
