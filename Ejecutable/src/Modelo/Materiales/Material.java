package Modelo.Materiales;

import Modelo.Inventario.Almacenable;
import Modelo.Escenario.Posicion;
import Modelo.Escenario.PosicionOcupada;

public abstract class Material extends PosicionOcupada{

    Posicion posicion;
    int durabilidad;

    public int durabilidad() {
        return durabilidad;
    }

    protected Material desgastar(int desgaste) {
        durabilidad -= desgaste;
        if (durabilidad > 0) return null;
        if (posicion != null) {
            posicion.borrar(this);
        }
        return this;
    }

    public abstract Material recoger(Material material, int desgaste);

    abstract Material serRecogido(Madera material, int desgaste);

    abstract Material serRecogido(Piedra material, int desgaste);

    abstract Material serRecogido(Metal material, int desgaste);

    abstract Material serRecogido(PiedraRefinada material, int desgaste);

    abstract Material serRecogido(Diamante material, int desgaste);

    abstract boolean esIgual(Material material);

    @Override
    public void establecerPosicion(Posicion nuevaPosicion) {
        posicion = nuevaPosicion;
    }

    @Override
    public boolean almacenar(Almacenable objeto) {
        return false;
    }

    @Override
    public int hashCode(){
        return 0;
    }

    @Override
    public boolean equals(Object objeto){
        if (!(objeto instanceof Material)) return false;
        return esIgual((Material)objeto);
    }
}