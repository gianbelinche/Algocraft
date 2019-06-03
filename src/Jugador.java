public class Jugador {
    public Hacha crearHachaDeMadera(){
        Madera madera = new Madera();
        Hacha hacha = new Hacha(100,madera,2);
        return hacha;
    }

    public Hacha crearHachaDePiedra(){
        Piedra piedra = new Piedra();
        Hacha hacha = new Hacha(200,piedra,5);
        return hacha;
    }

    public Pico crearPicoDeMadera(){
        Madera madera = new Madera();
        Pico pico = new Pico(100,madera,2);
        pico.setearDesgaste(madera);
        return pico;
    }

    public Pico crearPicoDePiedra(){
        Piedra piedra = new Piedra();
        Pico pico = new Pico(200,piedra,4);
        pico.setearDesgaste(piedra);
        return pico;
    }
}
