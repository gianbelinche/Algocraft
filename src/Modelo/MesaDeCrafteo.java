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

    @Override
    public boolean equals(Object otroObjeto){
        MesaDeCrafteo otraMesa;
        if (otroObjeto instanceof MesaDeCrafteo) otraMesa = (MesaDeCrafteo) otroObjeto;
        else{return false;};

        for(int i=0;i<3;i++){
            if (otraMesa.enPosicion(i,i) == null && this.enPosicion(i,i) == null){
                continue;
            }
            if (!(otraMesa.enPosicion(i,i).esIgual(this.enPosicion(i,i)))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode(){
        return 0;
    }


}
