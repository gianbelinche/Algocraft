public class Pico extends Herramienta {

    public Pico(int nuevaDurabilidad, Material nuevoMaterial, int nuevaFuerza){
        durabilidad = nuevaDurabilidad;
        miMaterial  = nuevoMaterial;
        fuerza      = nuevaFuerza;
    }

    public Material recoger(Madera material){

        durabilidad -= fuerza;
        return null;
    }

    public Material recoger(Material material){

        durabilidad -= fuerza;
        return miMaterial.recoger(material,fuerza);
    }
}
