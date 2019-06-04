public class DesgasteLineal extends Desgaste {
    double factorDeReduccion;

    public DesgasteLineal(double nuevoFactorDeReduccion){
        factorDeReduccion = nuevoFactorDeReduccion;
    }
            
    public double desgastar(int fuerza){
        return fuerza/factorDeReduccion;
    }
}
