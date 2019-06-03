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
}
