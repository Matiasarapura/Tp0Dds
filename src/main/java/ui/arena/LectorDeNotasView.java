package ui.arena;

import java.awt.Color;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;

import javafx.scene.control.PasswordField;


public class LectorDeNotasView extends MainWindow<LectorDeNotasViewModel> {

		  public LectorDeNotasView() {
		    super(new LectorDeNotasViewModel());
		  }

		  @Override
		  public void createContents(Panel mainPanel) {
		    setTitle("Lector de notas");
		  
		    mainPanel.setLayout(new HorizontalLayout());
		    
		    //Izquierda
		    Panel columnaIzquierda = new Panel(mainPanel);
		    columnaIzquierda.setLayout(new VerticalLayout());
		    new Label(columnaIzquierda).setText("Ingrese el token");
		    new TextBox(columnaIzquierda).bindValueToProperty("token");
		    new Button(columnaIzquierda) //
		    .setCaption("Obtener perfil") //
		    .onClick(() -> getModelObject().obtenerAlumno());
		    
		    //Derecha
		    Panel columnaDerecha = new Panel(mainPanel);
		    columnaDerecha.setLayout(new VerticalLayout());
		    new Label(columnaDerecha).setText("Legajo");
		    new TextBox(columnaIzquierda).bindValueToProperty("code");
		    new Label(columnaDerecha).setText("Nombre");
		    new TextBox(columnaIzquierda).bindValueToProperty("first_name");
		    new Label(columnaDerecha).setText("Apellido");
		    new TextBox(columnaIzquierda).bindValueToProperty("last_name");
		    new Label(columnaDerecha).setText("Usuario GitHub");
		    new TextBox(columnaIzquierda).bindValueToProperty("github_user");
			    
		  }

		  public static void main(String[] args) {
		    new LectorDeNotasView().startApplication();
		  }

}


