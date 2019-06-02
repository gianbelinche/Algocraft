public class Hacha extends Herramienta {

    public Hacha(int nuevaDurabilidad, Material nuevoMaterial, int nuevaFuerza){
        durabilidad = nuevaDurabilidad;
        miMaterial  = nuevoMaterial;
        fuerza      = nuevaFuerza;
    }

    public Material recoger(Piedra material){
        return null;
    }

    public Material recoger(Material material){
        return miMaterial.recoger(material,fuerza);
    }
}
