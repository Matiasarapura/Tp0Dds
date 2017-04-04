package lectorDeNotas;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.*;
import java.lang.reflect.Modifier;
import com.google.gson.*;

public class RequestService {
	 private Client client;
	 
	private static final String API_NOTITAS = "http://notitas.herokuapp.com";
	 private static final String RESOURCESTUDENT = "student";
	 private static final String RESOURSEASSIGMENTS = "student/assignments";
	 private static final String PRETOKEN = "Bearer ";
	//Inicializacion del cliente
	public RequestService() {
	        this.client = Client.create();
	}

	public Alumno getStudent(String token){
	        WebResource recurso = this.client.resource(API_NOTITAS).path(RESOURCESTUDENT);
	        Builder autorization = recurso.header("Authorization", PRETOKEN + token );
	        WebResource.Builder builder = autorization.accept(MediaType.APPLICATION_JSON);
	        ClientResponse response = builder.get(ClientResponse.class);
	        Alumno unAlumno = this.getStudentFromJson(response);
	        return unAlumno;
	}
	public ClientResponse getAssigments(String token){
        WebResource recurso = this.client.resource(API_NOTITAS).path(RESOURSEASSIGMENTS);
        Builder autorization = recurso.header("Authorization", PRETOKEN + token);
        WebResource.Builder builder = autorization.accept(MediaType.APPLICATION_JSON);
        ClientResponse response = builder.get(ClientResponse.class);
        return response;
    }
	
	public Client getClient() {
		return client;
	}
	
	public Alumno getStudentFromJson(ClientResponse oneJson){
		String strJson = oneJson.getEntity(String.class);
	 	Gson gson = new Gson();
    	Alumno unAlumno = gson.fromJson(strJson, Alumno.class);
	    return unAlumno;
	} 
   
	public void setClient(Client client) {
		this.client = client;
	}
   
}
