package ui.arena;

import java.awt.Color;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;

import lectorDeNotas.Assignment;
import lectorDeNotas.Data;

import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;

public class LectorDeNotasView extends MainWindow<LectorDeNotasViewModel> {

		  public LectorDeNotasView() {
		    super(new LectorDeNotasViewModel());
		  }

		  @Override
		  public void createContents(Panel mainPanel) {
		    setTitle("Lector de notas");
		    mainPanel.setLayout(new HorizontalLayout());
		    mainPanel.setWidth(1048);
		    
		    //Izquierda
		    Panel columnaIzquierda = new Panel(mainPanel);
		    columnaIzquierda.setLayout(new VerticalLayout());
		    columnaIzquierda.setWidth(150);
		    new Label(columnaIzquierda).setText("Ingrese el token");
		    new TextBox(columnaIzquierda).bindValueToProperty("token");
		    new Button(columnaIzquierda)
		    .setCaption("Obtener perfil")
		    .onClick(() -> getModelObject().obtenerAlumno())
		    .setWidth(50);
		    new Button(columnaIzquierda) 
		    .setCaption("Obtener notas") 
		    .onClick(() -> getModelObject().obtenerNotas())
		    .setWidth(50);
		    
		    //Centro
		    Panel columnaCentro = new Panel(mainPanel);
		    columnaCentro.setLayout(new VerticalLayout());
		    columnaCentro.setWidth(150);
		    new Label(columnaCentro).setText("Legajo");
		    new TextBox(columnaCentro).bindValueToProperty("code");
		    new Label(columnaCentro).setText("Nombre");
		    new TextBox(columnaCentro).bindValueToProperty("first_name");
		    new Label(columnaCentro).setText("Apellido");
		    new TextBox(columnaCentro).bindValueToProperty("last_name");
		    new Label(columnaCentro).setText("Usuario GitHub");
		    new TextBox(columnaCentro).bindValueToProperty("github_user");
			    
		    //Derecha
		    Panel columnaDerecha = new Panel(mainPanel);
		    columnaDerecha.setLayout(new VerticalLayout());
		    new Label(columnaDerecha).setText("Notas");
		    
		    Table<Assignment> table = new Table<Assignment>(columnaDerecha, Assignment.class);
			table.bindItemsToProperty("assignments");

			new Column<Assignment>(table) 
			.setTitle("Id")
			.setFixedSize(150)
			.bindContentsToProperty("id");

			new Column<Assignment>(table) 
			.setTitle("Titulo")
			.setFixedSize(100)
			.bindContentsToProperty("title");
			
			new Column<Assignment>(table) 
			.setTitle("Descripcion")
			.setFixedSize(200)
			.bindContentsToProperty("description");
			
			
			
		    
		  
		  }
		  
		  
		
		
		  
		  public static void main(String[] args) {
		    new LectorDeNotasView().startApplication();
		  }

}


