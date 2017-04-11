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
	private Gson gson = new Gson();
	// Inicializacion del cliente
	public RequestService() {
		this.client = Client.create();
	}

	public ClientResponse getResponse(String token, String oneResourse) {
		WebResource recurso = this.client.resource(API_NOTITAS).path(oneResourse);
		Builder autorization = recurso.header("Authorization", PRETOKEN + token);
		WebResource.Builder builder = autorization.accept(MediaType.APPLICATION_JSON);
		ClientResponse response = builder.get(ClientResponse.class);
		return response;
	}
	public void putResponse(String token, String oneResourse, String strWrite) {
		WebResource recurso = this.client.resource(API_NOTITAS).path(oneResourse);
		Builder autorization = recurso.header("Authorization", PRETOKEN + token);
		WebResource.Builder builder = autorization.accept(MediaType.APPLICATION_JSON);
		ClientResponse response = builder.put(ClientResponse.class, strWrite);
		
	}
	
	
	public Alumno getStudent(String token) {
		return this.getStudentFromJson(this.getResponse(token, RESOURCESTUDENT));
	}

	public Data getAssignments(String token) {
		return this.getAssignmentsFromJson(this.getResponse(token, RESOURSEASSIGMENTS));
	}

	public Alumno getStudentFromJson(ClientResponse oneJson) {
		String strJson = oneJson.getEntity(String.class);
		return gson.fromJson(strJson, Alumno.class);
	}

	public Data getAssignmentsFromJson(ClientResponse oneJson) {
		String strJson = oneJson.getEntity(String.class);
		return gson.fromJson(strJson, Data.class);
	}

	public String setStudentStr(String id, String firstName, String lastName, String githubUser){
	    Alumno unAlumno = new Alumno(id, firstName, lastName, githubUser);
		return gson.toJson(unAlumno);
	}
	public void setStudent(String token, String id, String firstName, String lastName, String githubUser){
		this.putResponse(token, RESOURCESTUDENT, this.setStudentStr(id, firstName, lastName, githubUser));
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
