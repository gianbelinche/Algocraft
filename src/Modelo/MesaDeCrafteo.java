package Modelo;

public class MesaDeCrafteo {
    private Material [][]  semilla = new Material[3][3];

    public Material [][] obtenerSemilla(){
        return semilla;
    }

    public void posicionar(int indice1, int indice2, Material material){
        semilla[indice1][indice2] = material;
    }

    public Material enPosicion(int index1, int index2){
        return semilla[index1][index2];
    }


}
