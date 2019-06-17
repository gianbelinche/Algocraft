package Modelo.Construccion;

import Modelo.Herramientas.Herramienta;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Metal;
import Modelo.Materiales.Piedra;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Recetario {
    private Map<Receta,Method> recetario;
    private Modelo.Construccion.Constructor constructor;

    public Recetario(){
        recetario = new HashMap<>();
        constructor  = new Modelo.Construccion.Constructor();
        this.crearSemillas();
    }

    public Herramienta craftear(Receta receta){
        Object herramienta = null;

        if (!recetario.containsKey(receta)) {
            return null;
        }

        try {
            herramienta = (recetario.get(receta)).invoke(constructor);
        }
        catch (IllegalAccessException e) {}
        catch (InvocationTargetException e) { }

        return (Herramienta) herramienta;

    }
    private Method crearMetodo(String unMetodo){
        Method metodo = null;

        try {
            metodo = Constructor.class.getDeclaredMethod(unMetodo);
        } catch (NoSuchMethodException e) { }

        return metodo;
    }

    private void crearSemillaHachaDeMadera(){
        Method metodo = crearMetodo("crearHachaDeMadera");
        Receta recetaHachaDeMadera = new Receta();
        Madera madera = new Madera();

        recetaHachaDeMadera.posicionar(0,0,madera);
        recetaHachaDeMadera.posicionar(0,1,madera);
        recetaHachaDeMadera.posicionar(1,0,madera);
        recetaHachaDeMadera.posicionar(1,1,madera);
        recetaHachaDeMadera.posicionar(2,1,madera);

        recetario.put(recetaHachaDeMadera,metodo);
    }

    private void crearSemillaHachaDePiedra(){
        Method metodo = crearMetodo("crearHachaDePiedra");

        Receta recetaHachaDePiedra = new Receta();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        recetaHachaDePiedra.posicionar(0,0,piedra);
        recetaHachaDePiedra.posicionar(0,1,piedra);
        recetaHachaDePiedra.posicionar(1,0,piedra);
        recetaHachaDePiedra.posicionar(1,1,madera);
        recetaHachaDePiedra.posicionar(2,1,madera);

        recetario.put(recetaHachaDePiedra,metodo);
    }

    private void crearSemillaHachaDeMetal(){
        Method metodo = crearMetodo("crearHachaDeMetal");

        Receta recetaHachaDeMetal = new Receta();
        Madera madera = new Madera();
        Metal metal = new Metal();
        recetaHachaDeMetal.posicionar(0,0,metal);
        recetaHachaDeMetal.posicionar(0,1,metal);
        recetaHachaDeMetal.posicionar(1,0,metal);
        recetaHachaDeMetal.posicionar(1,1,madera);
        recetaHachaDeMetal.posicionar(2,1,madera);

        recetario.put(recetaHachaDeMetal,metodo);
    }

    private void crearSemillaPicoDeMadera(){
        Method metodo = crearMetodo("crearPicoDeMadera");
        Receta recetaPicoDeMadera = new Receta();
        Madera madera = new Madera();
        recetaPicoDeMadera.posicionar(0,0,madera);
        recetaPicoDeMadera.posicionar(0,1,madera);
        recetaPicoDeMadera.posicionar(0,2,madera);
        recetaPicoDeMadera.posicionar(1,1,madera);
        recetaPicoDeMadera.posicionar(2,1,madera);

        recetario.put(recetaPicoDeMadera,metodo);
    }

    private void crearSemillaPicoDePiedra(){
        Method metodo = crearMetodo("crearPicoDePiedra");

        Receta recetaPicoDePiedra = new Receta();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        recetaPicoDePiedra.posicionar(0,0,piedra);
        recetaPicoDePiedra.posicionar(0,1,piedra);
        recetaPicoDePiedra.posicionar(0,2,piedra);
        recetaPicoDePiedra.posicionar(1,1,madera);
        recetaPicoDePiedra.posicionar(2,1,madera);

        recetario.put(recetaPicoDePiedra,metodo);
    }

    private void crearSemillaPicoDeMetal(){
        Method metodo = crearMetodo("crearPicoDeMetal");

        Receta recetaPicoDeMetal = new Receta();
        Madera madera = new Madera();
        Metal metal = new Metal();
        recetaPicoDeMetal.posicionar(0,0,metal);
        recetaPicoDeMetal.posicionar(0,1,metal);
        recetaPicoDeMetal.posicionar(0,2,metal);
        recetaPicoDeMetal.posicionar(1,1,madera);
        recetaPicoDeMetal.posicionar(2,1,madera);

        recetario.put(recetaPicoDeMetal,metodo);
    }

    private void crearSemillaPicoDePiedraRefinada(){
        Method metodo = crearMetodo("crearPicoDePiedraRefinada");

        Receta recetaPicoDePiedraRefinada = new Receta();
        Madera madera = new Madera();
        Metal metal = new Metal();
        Piedra piedra = new Piedra();
        recetaPicoDePiedraRefinada.posicionar(0,0,metal);
        recetaPicoDePiedraRefinada.posicionar(0,1,metal);
        recetaPicoDePiedraRefinada.posicionar(0,2,metal);
        recetaPicoDePiedraRefinada.posicionar(1,0,piedra);
        recetaPicoDePiedraRefinada.posicionar(1,1,madera);
        recetaPicoDePiedraRefinada.posicionar(2,1,madera);

        recetario.put(recetaPicoDePiedraRefinada,metodo);
    }

    private void crearSemillas(){

        this.crearSemillaHachaDeMadera();

        this.crearSemillaHachaDePiedra();

        this.crearSemillaHachaDeMetal();

        this.crearSemillaPicoDeMadera();

        this.crearSemillaPicoDePiedra();

        this.crearSemillaPicoDeMetal();

        this.crearSemillaPicoDePiedraRefinada();

    }
}
