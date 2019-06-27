package Vista;

import Modelo.Escenario.*;
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
        materialTope = 8;
        Class[] materialesGrupo = new Class[materialTope];

        materialesGrupo[0] = Tierra.class;
        materialesGrupo[1] = Madera.class;
        materialesGrupo[2] = Piedra.class;
        materialesGrupo[3] = Metal.class;
        materialesGrupo[4] = Diamante.class;
        materialesGrupo[5] = PosicionOcupada.class;
        materialesGrupo[6] = Bote.class;
        materialesGrupo[7] = Jugador.class;

        escenario = nuevoEscenario;
        Group root = new Group();
        Scene escena = new Scene(root,800,600);

        Canvas canvas = new Canvas(800,600);
        gc = canvas.getGraphicsContext2D();

        tablero = Tablero.obtenerTablero(tableroAncho,tableroLargo,tableroAlto);
        inicializarTablero();
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
                        } catch (Exception e) {}

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

    public void inicializarTablero(){
        tablero.colocarEnPosicion(0,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,0,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,0,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(1,0,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(2,0,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(4,0,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,0,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,0,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,0,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,0,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,0,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,0,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,0,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,0,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,0,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,0,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,0,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,0,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,0,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,0,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,0,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,0,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,0,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,0,2, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(11,0,2, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(12,0,2, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(13,0,2, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(14,0,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,0,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,0,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,0,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,0,1, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,0,1, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,0,1, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,0,1, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(11,0,1, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(15,0,1, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,0,1, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,0,0, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,1,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,1,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(1,1,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(4,1,3, new Modelo.Materiales.Piedra());
        tablero.colocarEnPosicion(5,1,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,1,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,1,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,1,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,1,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,1,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,1,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,1,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,1,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(14,1,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,1,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,1,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,1,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,1,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,1,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,1,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,1,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,2,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,2,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(4,2,3, new Modelo.Materiales.Piedra());
        tablero.colocarEnPosicion(5,2,3, new Modelo.Materiales.Metal());
        tablero.colocarEnPosicion(6,2,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,2,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,2,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,2,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(10,2,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(11,2,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(12,2,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(14,2,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(16,2,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,2,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,2,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,3,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,3,3, new Modelo.Materiales.Piedra());
        tablero.colocarEnPosicion(11,3,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(12,3,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(13,3,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(16,3,3, new Modelo.Materiales.Metal());
        tablero.colocarEnPosicion(17,3,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,4,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,4,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(11,4,3, new Modelo.Materiales.Metal());
        tablero.colocarEnPosicion(16,4,3, new Modelo.Materiales.Metal());
        tablero.colocarEnPosicion(0,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,5,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,5,3, new Modelo.Materiales.Metal());
        tablero.colocarEnPosicion(0,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,6,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,6,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,7,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,7,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,7,3, new Modelo.Materiales.Piedra());
        tablero.colocarEnPosicion(0,7,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,8,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,8,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,8,3, new Modelo.Materiales.Piedra());
        tablero.colocarEnPosicion(8,8,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,8,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(11,8,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,8,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,8,1, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,8,0, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,9,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,9,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,9,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,9,3, new Modelo.Materiales.Piedra());
        tablero.colocarEnPosicion(8,9,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,9,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,9,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,9,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,9,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,9,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,9,2, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(0,9,1, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,9,0, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,10,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,10,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,10,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,10,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,10,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,10,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,10,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,10,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,10,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,10,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(0,10,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,10,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,10,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,10,2, new Modelo.Materiales.Piedra());
        tablero.colocarEnPosicion(0,10,1, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,10,0, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(0,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,11,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,11,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,11,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,11,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,11,3, new Modelo.Materiales.Piedra());
        tablero.colocarEnPosicion(9,11,3, new Modelo.Materiales.Piedra());
        tablero.colocarEnPosicion(16,11,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(0,11,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,11,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,11,1, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,12,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,12,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,12,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,12,3, new Modelo.Materiales.Piedra());
        tablero.colocarEnPosicion(17,12,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(0,12,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,12,1, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,12,0, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(0,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,13,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,13,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,13,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,13,3, new Jugador());
        tablero.colocarEnPosicion(17,13,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,13,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,13,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,13,1, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,14,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,14,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,14,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,14,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,14,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,14,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,14,1, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,15,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,15,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,15,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,15,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(3,15,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(14,15,3, new Modelo.Materiales.Diamante());
        tablero.colocarEnPosicion(15,15,3, new Modelo.Materiales.Diamante());
        tablero.colocarEnPosicion(0,15,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,15,1, new Modelo.Materiales.Piedra());
        tablero.colocarEnPosicion(0,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,16,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(17,16,4, new Modelo.Escenario.Agua());
        tablero.colocarEnPosicion(0,16,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,16,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,16,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(13,16,3, new Modelo.Materiales.Diamante());
        tablero.colocarEnPosicion(14,16,3, new Modelo.Materiales.Diamante());
        tablero.colocarEnPosicion(17,16,3, new Modelo.Escenario.PosicionOcupada());
        tablero.colocarEnPosicion(0,16,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,17,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,17,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,17,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,17,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,17,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,17,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,17,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,17,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,17,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,17,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,17,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,17,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,17,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,17,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,17,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(15,17,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(16,17,4, new Modelo.Escenario.Agua());
        tablero.colocarEnPosicion(17,17,4, new Modelo.Escenario.Agua());
        tablero.colocarEnPosicion(0,17,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,17,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,17,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(4,17,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(10,17,3, new Modelo.Materiales.Metal());
        tablero.colocarEnPosicion(11,17,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,17,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,17,3, new Modelo.Materiales.Diamante());
        tablero.colocarEnPosicion(16,17,3, new Modelo.Escenario.PosicionOcupada());
        tablero.colocarEnPosicion(0,17,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(0,18,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,18,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,18,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,18,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,18,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,18,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,18,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,18,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,18,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,18,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,18,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,18,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,18,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,18,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(14,18,4, new Modelo.Escenario.Agua());
        tablero.colocarEnPosicion(15,18,4, new Modelo.Escenario.Agua());
        tablero.colocarEnPosicion(16,18,4, new Modelo.Escenario.Agua());
        tablero.colocarEnPosicion(17,18,4, new Modelo.Escenario.Agua());
        tablero.colocarEnPosicion(0,18,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,18,3, new Modelo.Materiales.Madera());
        tablero.colocarEnPosicion(9,18,3, new Modelo.Materiales.Metal());
        tablero.colocarEnPosicion(10,18,3, new Modelo.Materiales.Metal());
        tablero.colocarEnPosicion(11,18,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,18,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,18,3, new Modelo.Escenario.PosicionOcupada());
        tablero.colocarEnPosicion(14,18,3, new Modelo.Escenario.PosicionOcupada());
        tablero.colocarEnPosicion(15,18,3, new Bote());
        tablero.colocarEnPosicion(0,19,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(1,19,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(2,19,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(3,19,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(4,19,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(5,19,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(6,19,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(7,19,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(8,19,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(9,19,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(10,19,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,19,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,19,4, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(13,19,4, new Modelo.Escenario.Agua());
        tablero.colocarEnPosicion(14,19,4, new Modelo.Escenario.Agua());
        tablero.colocarEnPosicion(15,19,4, new Modelo.Escenario.Agua());
        tablero.colocarEnPosicion(16,19,4, new Modelo.Escenario.Agua());
        tablero.colocarEnPosicion(17,19,4, new Modelo.Escenario.Agua());
        tablero.colocarEnPosicion(3,19,3, new Modelo.Materiales.Piedra());
        tablero.colocarEnPosicion(9,19,3, new Modelo.Materiales.Metal());
        tablero.colocarEnPosicion(10,19,3, new Modelo.Materiales.Metal());
        tablero.colocarEnPosicion(11,19,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,19,3, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(11,19,2, new Modelo.Escenario.Tierra());
        tablero.colocarEnPosicion(12,19,2, new Modelo.Escenario.Tierra());
    }
}