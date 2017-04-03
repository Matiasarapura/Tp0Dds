package lectorDeNotas;
import com.google.gson.*;

public class Main {
	public static void main(String [] args)
	{
		RequestService nuevo = new RequestService();
		
		System.out.println(nuevo.getStudent().getEntity(String.class));
		System.out.println(nuevo.getAssigments().getEntity(String.class));
		
		String unAlumnoJson = nuevo.getAssigments().getEntity(String.class);
	
		
	    Gson gson = new Gson();

	    Alumno persona = gson.fromJson(unAlumnoJson, Alumno.class);    
	
	    System.out.println(persona.getAssigments());
	}

}