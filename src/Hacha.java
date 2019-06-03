public class Hacha extends Herramienta {

    public Hacha(int nuevaDurabilidad, Desgaste nuevoDesgaste, Material nuevoMaterial, int nuevaFuerza){
        durabilidad = nuevaDurabilidad;
        desgaste = nuevoDesgaste;
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
