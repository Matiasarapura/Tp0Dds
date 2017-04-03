package lectorDeNotas;

public class Main {
	public static void main(String [] args)
	{
		RequestService nuevo = new RequestService();
		
		System.out.println(nuevo.getStudent().getEntity(String.class));
		System.out.println(nuevo.getAssigments().getEntity(String.class));
	}
}
