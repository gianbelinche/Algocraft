package Modelo.Herramientas;

import Modelo.Desgastes.Desgaste;
import Modelo.Excepciones.HerramientaRotaException;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Material;
import Modelo.Materiales.Metal;
import Modelo.Materiales.Piedra;
import Modelo.Materiales.PiedraRefinada;

public class Pico extends Herramienta {

    public Pico(int nuevaDurabilidad, Desgaste nuevoDesgaste, Material nuevoMaterial, int nuevaFuerza){
        durabilidad = nuevaDurabilidad;
        desgaste = nuevoDesgaste;
        miMaterial  = nuevoMaterial;
        fuerza      = nuevaFuerza;
    }

    public Material recoger(Piedra material){ return recogerPrincipal(material); }

    public Material recoger(Metal material)  { return recogerPrincipal(material); }

    public Material recoger(PiedraRefinada material)  { return recogerPrincipal(material); }

    public Material recoger(Diamante material)  {
        durabilidad = (int) desgaste.desgastar(durabilidad, fuerza, material);
        if (durabilidad < 0){
            throw new HerramientaRotaException();
        }
        return miMaterial.recoger((Material) material,fuerza);
    }

    @Override
    public boolean equals(Object otroObjeto){
        Pico otroPico;
        if (!(otroObjeto instanceof Pico)) return false;
        otroPico = (Pico) otroObjeto;

        if(otroPico.mismoMaterial(miMaterial)) return true;

        return false;
    }

}
