package lectorDeNotas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Assignment {
	private String id;
	private String title;
	private String description;
	private List<Grade> grades = new ArrayList<>();
	private Boolean aprobada; 
	private String lastGrade;
	private final static List<String> APROBADAS = Arrays.asList("6","7","8","9","10","B","B+","MB","E");

	
	public void initLastGrade(){
		this.setLastGrade(this.getLastGrade());
		this.setAprobada(this.esAprobada(this.getLastGrade()));
	}
	
	public String getLastGrade(){
		if(grades.size() == 0)
			return "Sin notas aun";
		else
			return grades.get(grades.size()-1).getValue(); 
		 
	}

	public void setLastGrade(String lastGrade) {
		this.lastGrade = lastGrade;
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
	public List<Grade> getGrades() {
		return grades;
	}
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public Boolean getAprobada() {
		this.aprobada = this.esAprobada(this.getLastGrade()); 
		return aprobada;
	}

	public void setAprobada(Boolean aprobada) {
		this.aprobada = aprobada;
	}
	public Boolean esAprobada(String oneGrade){
		return APROBADAS.contains(oneGrade);
	}
	
}






