package codeMain;

/*
 * @ author - Arsheemahedi Shethwala
 *This is the main class with the main method which has the methods to run the javaFx application 
 */
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunApp extends Application implements config {
	public static void main(String[] args) {
		launch(args);
	} // end of the main method

	@Override
	public void start(Stage ps) throws Exception {
		URL url = this.getClass().getResource("interface.fxml");
		Parent scene = FXMLLoader.load(url);
		Scene ourscene = new Scene(scene);
		ps.setScene(ourscene);
		ps.setTitle("Items Database");
		ps.show();

	}// end of the javaFx method
}// end of the class
