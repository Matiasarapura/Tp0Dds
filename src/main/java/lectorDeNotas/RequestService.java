package lectorDeNotas;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.*;

public class RequestService {
	 private Client client;
	 private static final String API_NOTITAS = "http://notitas.herokuapp.com";
	 private static final String RESOURCESTUDENT = "student";
	 private static final String RESOURSEASSIGMENTS = "student/assignments";
	 private static final String TOKEN = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
	//Inicializacion del cliente
	public RequestService() {
	        this.client = Client.create();
	}

	public ClientResponse getStudent(){
	        WebResource recurso = this.client.resource(API_NOTITAS).path(RESOURCESTUDENT);
	        Builder autorization = recurso.header("Authorization", TOKEN);
	        WebResource.Builder builder = autorization.accept(MediaType.APPLICATION_JSON);
	        ClientResponse response = builder.get(ClientResponse.class);
	        return response;
	}
	public ClientResponse getAssigments(){
        WebResource recurso = this.client.resource(API_NOTITAS).path(RESOURSEASSIGMENTS);
        Builder autorization = recurso.header("Authorization", TOKEN);
        WebResource.Builder builder = autorization.accept(MediaType.APPLICATION_JSON);
        ClientResponse response = builder.get(ClientResponse.class);
        return response;
}

}
