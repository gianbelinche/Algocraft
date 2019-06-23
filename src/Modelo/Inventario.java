package Modelo;


import Modelo.Construccion.Constructor;
import Modelo.Herramientas.Hacha;
import Modelo.Herramientas.Pico;
import Modelo.Materiales.*;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;

public class Inventario {
    private Map<Almacenable, LinkedList> inventario = new HashMap<>();


    public Inventario(){
        Constructor constructor = new Constructor();
        //Materiales
        inventario.put(new Madera(), new LinkedList<Madera>());
        inventario.put(new Piedra(), new LinkedList<Piedra>());
        inventario.put(new Diamante(), new LinkedList<Diamante>());
        inventario.put(new Metal(), new LinkedList<Metal>());
        inventario.put(new PiedraRefinada(), new LinkedList<PiedraRefinada>());
        //Hachas
        inventario.put(constructor.crearHachaDeMadera(), new LinkedList<Hacha>());
        inventario.put(constructor.crearHachaDeMetal(), new LinkedList<Hacha>());
        inventario.put(constructor.crearHachaDePiedra(), new LinkedList<Hacha>());
        //Picos
        inventario.put(constructor.crearPicoDeMadera(), new LinkedList<Pico>());
        inventario.put(constructor.crearPicoDePiedra(), new LinkedList<Pico>());
        inventario.put(constructor.crearPicoDeMetal(), new LinkedList<Pico>());
        inventario.put(constructor.crearPicoDePiedraRefinada(), new LinkedList<Pico>());
    }

    public void almacenar(Almacenable objeto) {

        LinkedList list = inventario.get(objeto);
        list.add(objeto);
    }

    public Almacenable obtener(Almacenable objeto){

        return (Almacenable) inventario.get(objeto).remove(0);

    }

    @Override
    public int hashCode(){
        return 0;
    }
}

