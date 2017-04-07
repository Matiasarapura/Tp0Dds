package lectorDeNotas;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.*;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class RequestService {
	 private Client client;
	 
	private static final String API_NOTITAS = "http://notitas.herokuapp.com";
	 private static final String RESOURCESTUDENT = "student";
	 private static final String RESOURSEASSIGMENTS = "student/assignments";
	 private static final String PRETOKEN = "Bearer ";
	 private static final String UNOCUALQUIERA = "{\"assignments\":[{\"id\":1,\"title\":\"TPA1\",\"description\":\"Entrega 1 del TP Anual\",\"grades\":[{\"id\": 1,\"value\": 2,\"created_at\": \"2017-03-25T13:56:07.526Z\",\"updated_at\": \"2017-03-25T13:56:07.526Z\"},{\"id\": 2,\"value\": 7,\"created_at\": \"2017-03-25T13:56:07.595Z\",\"updated_at\": \"2017-03-25T13:56:07.595Z\"}]},{\"id\":2,\"title\":\"TPA2\",\"description\":\"Entrega 2 del TP Anual\",\"grades\":[{\"id\": 1,\"value\": 2,\"created_at\": \"2017-03-25T13:56:07.526Z\",\"updated_at\": \"2017-03-25T13:56:07.526Z\"},{\"id\": 2,\"value\": 7,\"created_at\": \"2017-03-25T13:56:07.595Z\",\"updated_at\": \"2017-03-25T13:56:07.595Z\"}]}]}";
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
	public Data getAssignments(String token){
        WebResource recurso = this.client.resource(API_NOTITAS).path(RESOURSEASSIGMENTS);
        Builder autorization = recurso.header("Authorization", PRETOKEN + token);
        WebResource.Builder builder = autorization.accept(MediaType.APPLICATION_JSON);
        ClientResponse response = builder.get(ClientResponse.class);
        //System.out.println(response);
        Data oneData = this.getAssignmentsFromJson(response); 
        return oneData;
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
	public Data getAssignmentsFromJson(ClientResponse oneJson){
		String strJson = oneJson.getEntity(String.class);
	 	Gson gson = new Gson();
	 	Data unaData = gson.fromJson(strJson, Data.class);
	 	System.out.println(strJson);
	 	System.out.println(unaData.toString());
	 	System.out.println(unaData.getAssignments().stream().map(Object::toString).collect(Collectors.joining(", ")));
	 	return unaData;
	} 
	public void setClient(Client client) {
		this.client = client;
	}
   
}
