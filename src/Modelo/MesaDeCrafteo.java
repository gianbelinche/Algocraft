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


}
