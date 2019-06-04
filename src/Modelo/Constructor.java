package Modelo;

public class Constructor {
    public Hacha crearHachaDeMadera(){
        return new Hacha(100,new DesgasteLineal(1),new Madera(),2);
    }

    public Hacha crearHachaDePiedra(){
        return new Hacha(200,new DesgasteLineal(1),new Piedra(),5);
    }

    public Hacha crearHachaDeMetal(){
        return new Hacha(200,new DesgasteLineal(1),new Metal(),5);
    }

    public Hacha crearHachaDePiedraRefinada(){
        return new Hacha(200,new DesgasteLineal(1),new PiedraRefinada(),5);
    }

    public Hacha crearHachaDeDiamante(){
        return new Hacha(200,new DesgasteLineal(1),new Diamante(),5);
    }

    public Pico crearPicoDeMadera(){
        return new Pico(100,new DesgasteLineal(1),new Madera(),2);
    }

    public Pico crearPicoDePiedra(){
        return new Pico(200,new DesgasteLineal(1.5),new Piedra(),4);
    }

    public Pico crearPicoDeMetal(){
        return new Pico(100,new DesgasteLineal(1),new Metal(),2);
    }

    public Pico crearPicoDePiedraRefinada(){
        return new Pico(100,new DesgasteLineal(1),new PiedraRefinada(),2);
    }

    public Pico crearPicoDeDiamante(){
        return new Pico(100,new DesgasteLineal(1),new Diamante(),2);
    }

}
