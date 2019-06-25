package Vista;

import Modelo.Escenario.*;
import Modelo.Escenario.Tierra;
import Modelo.Jugador;
import Modelo.Materiales.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static java.lang.Math.sqrt;

public class Main extends Application {

    private Stage escenario;
    private Tablero tablero;
    private GraphicsContext gc;
    private Posicionable posicionable;
    private int z;
    private int materiali;
    private int materialTope;
    int tableroAncho = 18;
    int tableroLargo = 20;
    int tableroAlto = 5;

    @Override
    public void start(Stage nuevoEscenario) throws Exception{
        z = 0;
        materiali = 0;
        materialTope = 9;
        Class[] materialesGrupo = new Class[materialTope];

        materialesGrupo[0] = Tierra.class;
        materialesGrupo[1] = Madera.class;
        materialesGrupo[2] = Piedra.class;
        materialesGrupo[3] = Metal.class;
        materialesGrupo[4] = Diamante.class;
        materialesGrupo[5] = PosicionOcupada.class;
        materialesGrupo[6] = Agua.class;
        materialesGrupo[7] = Bote.class;
        materialesGrupo[8] = Jugador.class;

        escenario = nuevoEscenario;
        Group root = new Group();
        Scene escena = new Scene(root,800,600);

        Canvas canvas = new Canvas(800,600);
        gc = canvas.getGraphicsContext2D();

        tablero = Tablero.obtenerTablero(tableroAncho,tableroLargo,tableroAlto);
        TableroIterador iterador = tablero.obtenerIterador();
        while(!iterador.haFinalizado()){
            if(iterador.getZ() == 4) iterador.colocarEnActual(new Tierra());
            iterador.avanzar();
        }

        root.getChildren().add(canvas);
        escenario.setScene(escena);
        escenario.show();
        actualizarImagen();


        escena.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                try {
                    posicionable = (Posicionable) materialesGrupo[materiali].newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                double mouseXIso = mouseEvent.getSceneX() - 400;
                double mouseYIso = mouseEvent.getSceneY();

                double l = 64;
                double mouseX = (mouseXIso*sqrt(2) + mouseYIso*sqrt(6) - 2*z)/(2);
                double mouseY = (mouseXIso*sqrt(2) - mouseYIso*sqrt(6) + 2*z)/(-2);
                mouseX *= (double)2/l;
                mouseY *= (double)2/l;

                if (mouseEvent.getButton() == MouseButton.SECONDARY)
                    tablero.borrarEnPosicion((int)mouseX,(int)mouseY,z);
                else
                    tablero.colocarEnPosicion((int)mouseX,(int)mouseY,z,posicionable);

                actualizarImagen();
            }
        });

        escena.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        z++;
                        if(z == tableroAlto) z = 0;
                        System.out.println("Z:" + z);
                        break;

                    case DOWN:
                        z--;
                        if(z < 0) z = tableroAlto - 1;
                        System.out.println("Z:" + z);
                        break;

                    case LEFT:
                        materiali--;
                        if (materiali < 0)
                            materiali = materialTope - 1;
                        try {
                            posicionable = (Posicionable) materialesGrupo[materiali].newInstance();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Material:" + materialesGrupo[materiali].getName());
                        break;

                    case RIGHT:
                        materiali++;
                        if (materiali == materialTope)
                            materiali = 0;
                        try {
                            posicionable = (Posicionable) materialesGrupo[materiali].newInstance();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Material:" + materialesGrupo[materiali].getName());
                        break;

                    case SPACE:
                        TableroIterador iterador = tablero.obtenerIterador();
                        System.out.println("-------------------------------------");
                        while(!iterador.haFinalizado()){

                            if(iterador.verActual().getClass() !=PosicionVacia.class)
                            System.out.println("tablero.colocarEnPosicion("+iterador.getX()+","+iterador.getY()+","+
                                    iterador.getZ()+", new "+iterador.verActual().getClass().getCanonicalName()+"());");
                            iterador.avanzar();
                        }
                        break;
                }
            }
        });
    }


    public void actualizarImagen(){
        gc.setFill(Color.LIGHTCYAN);
        gc.fillRect(0,0,3000,3000);
        (new Dibujante()).dibujar(gc);
    }

    public static void main(String[] args) {
        launch(args);
    }


}