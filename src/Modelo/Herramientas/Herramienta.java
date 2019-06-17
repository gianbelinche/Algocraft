package Modelo.Herramientas;

import Modelo.Almacenable;
import Modelo.Desgastes.Desgaste;
import Modelo.Materiales.Material;

public class Herramienta implements Almacenable {

    Material miMaterial;
    int durabilidad;
    int fuerza;
    Desgaste desgaste;

    public int durabilidad(){
        return durabilidad;
    }

    public int fuerza() {return fuerza;}

    public Material recoger(Material material){

        durabilidad = (int) desgaste.desgastar(durabilidad, fuerza, material);
        return null;
    }

    protected Material recogerPrincipal(Material material){

        durabilidad = (int) desgaste.desgastar(durabilidad, fuerza, material);
        return miMaterial.recoger(material,fuerza);
    }

    public boolean almacenar(Almacenable objeto){ return false;}

    public Almacenable obtener(){return this;}
}