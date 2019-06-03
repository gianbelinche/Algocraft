import org.junit.Test;

import static org.junit.Assert.*;

public class HachaTest {

    @Test
    public void construirPicoLoCreaConLaDurabilidadCorrecta(){

        for(int i = -1000;i <= 1000;i++) {
            Hacha hacha = new Hacha(i,null,0);
            assertEquals(i,hacha.durabilidad());
        }
    }
}
