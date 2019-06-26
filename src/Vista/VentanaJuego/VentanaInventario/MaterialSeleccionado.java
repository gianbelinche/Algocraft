package Vista.VentanaJuego.VentanaInventario;

import Modelo.Materiales.Material;
import javafx.scene.layout.BackgroundImage;

public class MaterialSeleccionado {
    Material material;
    BackgroundImage background;
    public void seleccionarMaterial(Material material){
        this.material = material;
    }
    public Material obtenerSeleccionado(){
        return this.material;
    }

    public BackgroundImage obtenerFondo(){
        return background;
    }
    public void definirFondo(BackgroundImage background){
        this.background = background;
    }
}
