package Vista.VentanaJuego.VentanaInventario;

import Modelo.Materiales.Material;

public class MaterialSeleccionado {
    Material material;
    public void seleccionarMaterial(Material material){
        this.material = material;
    }
    public Material obtenerSeleccionado(){
        return this.material;
    }
}
