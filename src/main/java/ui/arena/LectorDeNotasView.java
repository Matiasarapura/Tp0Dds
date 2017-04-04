package ui.arena;

import java.awt.Color;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;


public class LectorDeNotasView extends MainWindow<LectorDeNotasViewModel> {

		  public LectorDeNotasView() {
		    super(new LectorDeNotasViewModel());
		  }

		  @Override
		  public void createContents(Panel mainPanel) {
		    setTitle("Lector de notas");
		    mainPanel.setLayout(new VerticalLayout());

		    new Label(mainPanel).setText("Ingrese el token");

		    new TextBox(mainPanel).bindValueToProperty("token");

		    new Button(mainPanel) //
		    .setCaption("Obtener perfil") //
		    .onClick(() -> getModelObject().obtenerAlumno());
		  }

		  public static void main(String[] args) {
		    new LectorDeNotasView().startApplication();
		  }

}


