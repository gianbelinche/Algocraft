package Modelo;

public class Proyector {
    private int lado = 110;
    private double ajusteDePerspectiva = 0.58;
    int corrimientoX = 600;
    int corrimientoY = 100;

    public int obtenerXIso(double x, double y){
        double xAjustada = x*(lado - 14)*0.5;
        double yAjustada = y*(lado - 17)*0.5;
        return (int) (xAjustada - yAjustada) + corrimientoX;
    }

    public int obtenerYIso(double x, double y){
        double xAjustada = x*(lado - 14)*0.5;
        double yAjustada = y*(lado - 17)*0.5;
        return (int) ((xAjustada + yAjustada)*ajusteDePerspectiva + corrimientoY) ;
    }

    public int obtenerXCart(double xIso,double yIso){
        double xIsoAjustada = (xIso)/(lado*0.5);
        double yIsoAjustada = (yIso + lado/2)/(lado*0.5);
        return (int)((yIsoAjustada/ajusteDePerspectiva + xIsoAjustada)/2);
    }

    public int obtenerYCart(double xIso,double yIso){
        double xIsoAjustada = (xIso)/(lado*0.5);
        double yIsoAjustada = (yIso + lado/2)/(lado*0.5);
        return (int)((yIsoAjustada/ajusteDePerspectiva - xIsoAjustada)/2);
    }
}
