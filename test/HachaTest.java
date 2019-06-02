import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HachaTest {
    @Test
    public void construirPicoLoCreaConLaDurabilidadCorrecta(){

        for(int i = -1000;i <= 1000;i++) {
            Hacha hacha = new Hacha(i,null,0);
            assertEquals(i,hacha.durabilidad());
        }
    }
}