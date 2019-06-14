package Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VentanaInventario extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage)  {

        stage.setTitle("AlgoCraft");
        ContenedorInventario contenedorInventario = new ContenedorInventario(stage);
        Scene escenaInventario = new Scene(contenedorInventario, 640, 480);

        // add handler to this:
        // stage.setOnCloseRequest()

        stage.setScene(escenaInventario);
        //stage.setFullScreen(true);

        stage.show();
    }
}
