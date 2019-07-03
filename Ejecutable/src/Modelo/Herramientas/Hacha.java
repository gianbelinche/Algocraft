package Modelo.Herramientas;

import Modelo.Desgastes.Desgaste;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Material;


public class Hacha extends Herramienta {

    public Hacha(int nuevaDurabilidad, Desgaste nuevoDesgaste, Material nuevoMaterial, int nuevaFuerza){
        durabilidad = nuevaDurabilidad;
        desgaste = nuevoDesgaste;
        miMaterial  = nuevoMaterial;
        fuerza      = nuevaFuerza;
    }

    public Material recoger(Madera material){
        return recogerPrincipal(material);
    }

    @Override
    public boolean equals(Object otroObjeto){
        Hacha otraHacha;
        if (!(otroObjeto instanceof Hacha)) return false;
        otraHacha = (Hacha) otroObjeto;

        if(otraHacha.mismoMaterial(miMaterial)) return true;

        return false;
    }


}