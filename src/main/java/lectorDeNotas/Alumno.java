package lectorDeNotas;

import java.util.ArrayList;
import java.util.List;


public class Alumno {
	private int code;
	private String first_name;
	private String last_name;
	private String github_user;
	private List<assigment> assigments= new ArrayList<>();
	
	
	
	
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
	public List<assigment> getAssigments() {
		return assigments;
	}
	public void setAssigments(List<assigment> assigments) {
		this.assigments = assigments;
	}
	
	
	
	
	
	
	


}

