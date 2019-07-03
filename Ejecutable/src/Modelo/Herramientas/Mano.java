package Modelo.Herramientas;

public class Mano extends Herramienta{
    @Override
    public boolean equals(Object otroObjeto){
        return otroObjeto instanceof Mano;
    }
}
