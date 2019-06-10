package Modelo;

import java.util.HashMap;
import java.util.Map;

public class Crafteador {
    private Map<MesaDeCrafteo,Herramienta> semillas = new HashMap<MesaDeCrafteo,Herramienta>();
    private Constructor constructor = new Constructor();

    public Crafteador(){
        this.crearSemillas();
    }

    public Herramienta craftear(MesaDeCrafteo mesa){
        if (!semillas.containsKey(mesa)) {
            return null;
        }
        return semillas.get(mesa);

    }

    private void crearSemillaHachaDeMadera(){
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        MesaDeCrafteo mesaHachaDeMadera = new MesaDeCrafteo();
        Madera madera = new Madera();
        mesaHachaDeMadera.posicionar(0,0,madera);
        mesaHachaDeMadera.posicionar(0,1,madera);
        mesaHachaDeMadera.posicionar(1,0,madera);
        mesaHachaDeMadera.posicionar(1,1,madera);
        mesaHachaDeMadera.posicionar(2,1,madera);

        semillas.put(mesaHachaDeMadera,hachaDeMadera);
    }

    private void crearSemillaHachaDePiedra(){
        Hacha hachaDePiedra = constructor.crearHachaDePiedra();
        MesaDeCrafteo mesaHachaDePiedra = new MesaDeCrafteo();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        mesaHachaDePiedra.posicionar(0,0,piedra);
        mesaHachaDePiedra.posicionar(0,1,piedra);
        mesaHachaDePiedra.posicionar(1,0,piedra);
        mesaHachaDePiedra.posicionar(1,1,madera);
        mesaHachaDePiedra.posicionar(2,1,madera);

        semillas.put(mesaHachaDePiedra,hachaDePiedra);
    }

    private void crearSemillaHachaDeMetal(){
        Hacha hachaDeMetal = constructor.crearHachaDeMetal();
        MesaDeCrafteo mesaHachaDeMetal = new MesaDeCrafteo();
        Madera madera = new Madera();
        Metal metal = new Metal();
        mesaHachaDeMetal.posicionar(0,0,metal);
        mesaHachaDeMetal.posicionar(0,1,metal);
        mesaHachaDeMetal.posicionar(1,0,metal);
        mesaHachaDeMetal.posicionar(1,1,madera);
        mesaHachaDeMetal.posicionar(2,1,madera);

        semillas.put(mesaHachaDeMetal,hachaDeMetal);
    }

    private void crearSemillas(){

        this.crearSemillaHachaDeMadera();

        this.crearSemillaHachaDePiedra();

        this.crearSemillaHachaDeMetal();

    }
}
