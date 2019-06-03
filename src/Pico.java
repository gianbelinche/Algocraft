public class Pico extends Herramienta {

    public Pico(int nuevaDurabilidad, Material nuevoMaterial, int nuevaFuerza){
        durabilidad = nuevaDurabilidad;
        miMaterial  = nuevoMaterial;
        fuerza      = nuevaFuerza;
    }

    public void setearDesgaste(Madera madera){
        desgaste = new Lineal();
    }

    public void setearDesgaste(Piedra piedra){
        desgaste =  new SemiLineal();
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
