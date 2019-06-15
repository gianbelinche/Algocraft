
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage escenario;
    private Tablero tablero;
    private GraphicsContext terreno;

    @Override
    public void start(Stage nuevoEscenario) throws Exception{

        escenario = nuevoEscenario;
        Group root = new Group();
        Scene escena = new Scene(root,800,600);

        Canvas canvas = new Canvas(800,600);
        terreno = canvas.getGraphicsContext2D();

        Posicionable posicionable = new Posicionable();
        tablero = new Tablero(100,100);

        root.getChildren().add(canvas);
        escenario.setScene(escena);
        actualizar();



        escena.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Proyector proyector = new Proyector();

                double mouseXIso = mouseEvent.getSceneX();
                double mouseYIso = mouseEvent.getSceneY();

                int mouseX = proyector.obtenerXCart(mouseXIso,mouseYIso);
                int mouseY = proyector.obtenerYCart(mouseXIso,mouseYIso);

                if (mouseEvent.getButton() == MouseButton.SECONDARY)
                    tablero.borrarEnPosicion(mouseX,mouseY);
                else
                    tablero.colocarEnPosicion(mouseX,mouseY,posicionable);

                actualizar();
            }

        });
    }

    public void limpiarImagen(){
        terreno.setFill(Color.LIGHTCYAN);
        terreno.fillRect(0,0,4000,4000);
    }

    public void actualizar(){
        limpiarImagen();
        tablero.dibujar(terreno);
        escenario.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}