package lectorDeNotas;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	private String code;
	private String first_name;
	private String last_name;
	private String github_user;
	private List<Assignment> assigments = new ArrayList<>();

	public Alumno(){
	}

	public Alumno(String code, String first_name, String last_name, String github_user){
		this.code = code;
		this.first_name = first_name;
		this.last_name = last_name;
		this.github_user = github_user;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
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

	public List<Assignment> getAssigments() {
		return assigments;
	}

	public void setAssigments(List<Assignment> assigments) {
		this.assigments = assigments;
	}

}
