public class DesgasteLineal extends Desgaste {
    int factorDeReduccion;

    public DesgasteLineal(int nuevoFactorDeReduccion){
        factorDeReduccion = nuevoFactorDeReduccion;
    }
            
    public double desgastar(int fuerza){
        return fuerza/factorDeReduccion;
    }
}
