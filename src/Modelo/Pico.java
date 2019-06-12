package Modelo;

public class Pico extends Herramienta {

    public Pico(int nuevaDurabilidad, Desgaste nuevoDesgaste, Material nuevoMaterial, int nuevaFuerza){
        durabilidad = nuevaDurabilidad;
        desgaste = nuevoDesgaste;
        miMaterial  = nuevoMaterial;
        fuerza      = nuevaFuerza;
    }

    public Material recoger(Piedra material){ return recogerPredeterminado(material); }

    public Material recoger(Metal material)  { return recogerPredeterminado(material); }

    public Material recoger(PiedraRefinada material)  { return recogerPredeterminado(material); }

    public Material recoger(Diamante material)  {
        durabilidad = (int) desgaste.desgastar(durabilidad, fuerza, material);
        return miMaterial.recoger((Material) material,fuerza);
    }

}
