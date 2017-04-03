package lectorDeNotas;

import java.util.ArrayList;
import java.util.List;


public class Alumno {
	private int legajo = 0;
	private String firstName;
	private String lastName;
	private List<Tarea> tareas= new ArrayList<>();
	
	
	
	
	
	
	
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Tarea> getTareas() {
		return tareas;
	}
	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

}

