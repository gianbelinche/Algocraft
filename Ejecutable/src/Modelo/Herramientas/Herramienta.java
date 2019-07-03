package Modelo.Herramientas;

import Modelo.Inventario.Almacenable;
import Modelo.Desgastes.Desgaste;
import Modelo.Excepciones.HerramientaRotaException;
import Modelo.Materiales.Material;

public class Herramienta implements Almacenable {

    Material miMaterial;
    int durabilidad;
    int fuerza;
    Desgaste desgaste;

    public int durabilidad() {
        return durabilidad;
    }

    public int fuerza() {
        return fuerza;
    }

    public Material recoger(Material material) {

        durabilidad = (int) desgaste.desgastar(durabilidad, fuerza, material);
        if (durabilidad < 0) {
            throw new HerramientaRotaException();
        }
        return null;
    }

    protected Material recogerPrincipal(Material material) {

        durabilidad = (int) desgaste.desgastar(durabilidad, fuerza, material);
        if (durabilidad < 0) throw new HerramientaRotaException();
        return miMaterial.recoger(material, fuerza);
    }

    public boolean almacenar(Almacenable objeto) {
        return false;
    }

    public boolean mismoMaterial(Material material) {
        return material.esIgual(this.miMaterial);
    }

    public boolean equals(Object otroObjeto){
        Herramienta otraHerramienta;
        if (!(otroObjeto instanceof Herramienta)) return false;
        otraHerramienta = (Herramienta) otroObjeto;

        if(otraHerramienta.mismoMaterial(miMaterial)) return true;

        return false;
    }
    @Override
    public int hashCode(){
        return 0;
    }
}