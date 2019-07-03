package Modelo.Construccion;

import Modelo.Desgastes.*;
import Modelo.Herramientas.*;
import Modelo.Materiales.*;

public class Constructor {
    public Hacha crearHachaDeMadera(){
        return new Hacha(100,new DesgasteLineal(1),new Madera(),2);
    }

    public Hacha crearHachaDePiedra(){
        return new Hacha(200,new DesgasteLineal(1),new Piedra(),5);
    }

    public Hacha crearHachaDeMetal(){
        return new Hacha(400,new DesgasteLineal(0.5),new Metal(),10);
    }

    public Pico crearPicoDeMadera(){
        return new Pico(100,new DesgasteLineal(1),new Madera(),2);
    }

    public Pico crearPicoDePiedra(){
        return new Pico(200,new DesgasteLineal((1/1.5)),new Piedra(),4);
    }

    public Pico crearPicoDeMetal(){
        return new Pico(400,new DesgastePorUsos(10),new Metal(),12);
    }

    public Pico crearPicoDePiedraRefinada(){
        return new Pico(1000,new DesgastePorMaterial(0.1),new PiedraRefinada(),20);
    }

}
