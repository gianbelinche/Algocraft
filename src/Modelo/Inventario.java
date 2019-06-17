package Modelo;

import Modelo.Escenario.PosicionVacia;

public class Inventario {
    private Almacenable[][] inventario;
    private int ancho = 9;
    private int alto = 3;
    public Inventario(){
        inventario = new Almacenable[alto][ancho];
        for(int i=0; i<alto; i++){
            for(int j=0; j<ancho; j++){
                inventario[i][j] = new PosicionVacia();
            }
        }
    }

    public void almacenar(Almacenable objeto){
        for(int i=0; i<alto; i++){
            for(int j=0; j<ancho; j++){
                if(inventario[i][j].almacenar(objeto)){
                    inventario[i][j] = objeto;
                    break;
                }
            }
        }
    }

    public Almacenable obtenerDePosicion(int x, int y){
        return inventario[y][x].obtener();
    }
}
