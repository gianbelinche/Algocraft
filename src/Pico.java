public class Pico extends Herramienta {

    public Pico(int nuevaDurabilidad, Desgaste nuevoDesgaste, Material nuevoMaterial, int nuevaFuerza){
        durabilidad = nuevaDurabilidad;
        desgaste = nuevoDesgaste;
        miMaterial  = nuevoMaterial;
        fuerza      = nuevaFuerza;
    }


    public Material recoger(Madera material){

        durabilidad -= desgaste.desgastar(fuerza);
        return null;
    }

    public Material recoger(Material material){

        durabilidad -= desgaste.desgastar(fuerza);
        return miMaterial.recoger(material,fuerza);
    }
}
