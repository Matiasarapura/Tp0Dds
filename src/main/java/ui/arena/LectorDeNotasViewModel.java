package ui.arena;


import org.uqbar.commons.utils.Observable;
import lectorDeNotas.RequestService;
import lectorDeNotas.Alumno;

@Observable
public class LectorDeNotasViewModel {
	
	private String token;
	private Alumno alumno = new Alumno();
	
	public void obtenerAlumno(){
		this.token = alumno.getFirst_name(); 
	}
	

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}