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

    private void crearSemillas(){
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        MesaDeCrafteo mesaHachaDeMadera = new MesaDeCrafteo();
        Madera madera1 = new Madera();
        mesaHachaDeMadera.posicionar(0,0,madera1);
        Madera madera2 = new Madera();
        mesaHachaDeMadera.posicionar(0,1,madera2);
        Madera madera3 = new Madera();
        mesaHachaDeMadera.posicionar(1,0,madera3);
        Madera madera4 = new Madera();
        mesaHachaDeMadera.posicionar(1,1,madera4);
        Madera madera5 = new Madera();
        mesaHachaDeMadera.posicionar(2,1,madera5);

        semillas.put(mesaHachaDeMadera,hachaDeMadera);
    }
}
