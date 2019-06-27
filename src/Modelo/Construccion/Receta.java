package Modelo.Construccion;

import Modelo.Inventario.Inventario;
import Modelo.Materiales.Material;

public class Receta {

    private Material[][]  semilla = new Material[3][3];

    private Inventario inventario;

    public Receta(Inventario inventario){
        this.inventario = inventario;
    }


    public Material [][] obtenerSemilla(){
        return semilla;
    }

    public void posicionar(int indice1, int indice2, Material material){
        Material materialPrevio = semilla[indice1][indice2];
        if(materialPrevio != null){
            inventario.almacenar(materialPrevio);
        }

        semilla[indice1][indice2] = (Material)inventario.obtener(material);
    }

    public Material enPosicion(int index1, int index2){
        return semilla[index1][index2];
    }

    @Override
    public boolean equals(Object otroObjeto){
        Receta otraMesa;
        if (otroObjeto instanceof Receta) otraMesa = (Receta) otroObjeto;
        else{return false;};

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if (otraMesa.enPosicion(i, j) == null){
                    if (this.enPosicion(i, j) == null) continue;
                    else{return false;}
                }

                if (!(otraMesa.enPosicion(i, j).esIgual(this.enPosicion(i, j)))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode(){
        return 0;
    }

    public void devolverAlInventario(){
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                Material materialPrevio = semilla[i][j];
                if(materialPrevio != null){
                    inventario.almacenar(materialPrevio);
                }
                semilla[i][j] = null;
            }
        }
    }

    public void vaciar() {
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                semilla[i][j] = null;
            }
        }
    }
}
