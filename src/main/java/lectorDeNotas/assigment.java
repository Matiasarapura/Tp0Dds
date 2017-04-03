package lectorDeNotas;
import java.util.ArrayList;
import java.util.List;

public class assigment {
	private int id;
	private String title;
	private String description;
	private List<grade> grades = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public List<grade> getGrades() {
		return grades;
	}
	public void setGrades(List<grade> grades) {
		this.grades = grades;
	}
	
}






