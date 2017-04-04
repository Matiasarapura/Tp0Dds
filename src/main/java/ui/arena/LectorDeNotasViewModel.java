package ui.arena;


import org.uqbar.commons.utils.Observable;
import lectorDeNotas.RequestService;
import lectorDeNotas.Alumno;

@Observable
public class LectorDeNotasViewModel {
	
	private String token;
	
	private int code;
	private String first_name;
	
	private String last_name;
	private String github_user;
	
	private Alumno unAlumno = new Alumno();
	private RequestService oneService = new RequestService();
	
	public void obtenerAlumno(){
		unAlumno = oneService.getStudent(token);
		this.code = unAlumno.getCode();
		this.first_name = unAlumno.getFirst_name();
		this.last_name = unAlumno.getLast_name();
		this.github_user= unAlumno.getGithub_user();
	}
	

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getGithub_user() {
		return github_user;
	}


	public void setGithub_user(String github_user) {
		this.github_user = github_user;
	}
	
}