public class Herramienta {

    Material miMaterial;
    int durabilidad;
    int fuerza;
    Desgaste desgaste;

    public int durabilidad(){
        return durabilidad;
    }

    public int fuerza() {return fuerza;}

    public Material recoger(Material material){

        durabilidad -= desgaste.desgastar(fuerza);
        return null;
    }

    public Material _recoger(Material material){

        durabilidad -= desgaste.desgastar(fuerza);
        return miMaterial.recoger(material,fuerza);
    }
}
