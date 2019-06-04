package Modelo;

public class Pico extends Herramienta {

    public Pico(int nuevaDurabilidad, Desgaste nuevoDesgaste, Material nuevoMaterial, int nuevaFuerza){
        durabilidad = nuevaDurabilidad;
        desgaste = nuevoDesgaste;
        miMaterial  = nuevoMaterial;
        fuerza      = nuevaFuerza;
    }


    public Material recoger(Piedra material){ return _recoger(material); }

    public Material recoger(Metal material)  { return _recoger(material); }

    public Material recoger(Diamante material)  { return _recoger(material); }


}
