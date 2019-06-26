package Controlador.BotonesHandlers;

import Modelo.Construccion.Receta;
import Modelo.Jugador;
import Modelo.Materiales.Material;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonMesaCrafteo;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import Vista.VentanaJuego.VentanaInventario.MaterialSeleccionado;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;

public class BotonMesaCrafteoHandler implements EventHandler<ActionEvent> {
    Receta receta;
    MaterialSeleccionado materialSeleccionado;
    Jugador jugador;
    InventarioLayout inventarioLayout;
    int x;
    int y;
    BotonMesaCrafteo botonMesa;
    public BotonMesaCrafteoHandler(Jugador jugador, Receta receta, MaterialSeleccionado material, InventarioLayout inventarioLayout, int x_pasado, int y_pasado, BotonMesaCrafteo botonMesa){
        this.receta = receta;
        this.materialSeleccionado = material;
        x = x_pasado;
        y = y_pasado;
        this.jugador = jugador;
        this.inventarioLayout = inventarioLayout;
        this.botonMesa = botonMesa;

    }
    @Override
    public void handle(ActionEvent event){
        //Ojo, hay que pedirle al inventario el material, no usar directamente el materialSeleccionado
        Material material = materialSeleccionado.obtenerSeleccionado();
        if (material != null) {
            this.receta.posicionar(x,y, material);
            this.botonMesa.setBackground(new Background(materialSeleccionado.obtenerFondo()));
        }
        inventarioLayout.actualizarMateriales();
        
        //Probar cambiar el tercer parametro de receta de "Material" a "Almacenable" o simplemente cambiar de Almacenable a Material en estos botones.
        //receta.posicionar(x,y, materialSeleccionado);
    }
}