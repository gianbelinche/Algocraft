package Modelo.Inventario;


import Modelo.Construccion.Constructor;
import Modelo.Excepciones.AlmacenableNoDisponibleException;
import Modelo.Herramientas.Hacha;
import Modelo.Herramientas.Mano;
import Modelo.Herramientas.Pico;
import Modelo.Materiales.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Inventario {
    private Map<Almacenable, LinkedList> inventario = new HashMap<>();


    public Inventario(){
        Constructor constructor = new Constructor();
        //Mano
        inventario.put(new Mano(),new LinkedList());
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

        if (this.obtenerCantidad(objeto) == 0) throw new AlmacenableNoDisponibleException();

        return (Almacenable) inventario.get(objeto).remove(0);

    }
    public int obtenerCantidad(Almacenable almacenable){
        return inventario.get(almacenable).size();
    }
    @Override
    public int hashCode(){
        return 0;
    }
}

