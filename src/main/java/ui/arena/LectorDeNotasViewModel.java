package ui.arena;


import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;
import lectorDeNotas.RequestService;
import lectorDeNotas.Alumno;
import lectorDeNotas.Assignment;
import lectorDeNotas.Data;
import lectorDeNotas.Grade;

@Observable
public class LectorDeNotasViewModel {
	
	private String token;
	
	//Alumno
	private int code;
	private String first_name;
	private String last_name;
	private String github_user;
	
	//Asignaciones
	private Data assignmentsData;
	private List<Assignment> assignments = new ArrayList<>();
	private String id;
	private String title;
	private String description;
	private String lastGrade;
	private Boolean aprobada;

	
	
	//Otros
	private Alumno unAlumno = new Alumno();
	private RequestService oneService = new RequestService();
	
	public void obtenerAlumno(){
		this.unAlumno = this.oneService.getStudent(token);
		this.code = unAlumno.getCode();
		this.first_name = unAlumno.getFirst_name();
		this.last_name = unAlumno.getLast_name();
		this.github_user= unAlumno.getGithub_user();
	}
	public void obtenerNotas(){
		this.assignmentsData = this.oneService.getAssignments(token);
		this.assignments = this.assignmentsData.getAssignments();
		this.assignments.forEach(one -> one.initLastGrade());
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
	
	public RequestService getOneService() {
		return oneService;
	}
	public void setOneService(RequestService oneService) {
		this.oneService = oneService;
	}
	
	public Data getAssignmentsData() {
		return assignmentsData;
	}
	public void setAssignmentsData(Data assignmentsData) {
		this.assignmentsData = assignmentsData;
	}
	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}
	public List<Assignment> getAssignments() {
		return assignments;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}