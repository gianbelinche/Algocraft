public class Constructor {
    public Hacha crearHachaDeMadera(){
        return new Hacha(100,new DesgasteLineal(1),new Madera(),2);
    }

    public Hacha crearHachaDePiedra(){
        return new Hacha(200,new DesgasteLineal(1),new Piedra(),5);
    }

    public Pico crearPicoDeMadera(){
        return new Pico(100,new DesgasteLineal(1),new Madera(),2);
    }

    public Pico crearPicoDePiedra(){
        return new Pico(200,new DesgasteLineal(1.5),new Piedra(),4);
    }
}
