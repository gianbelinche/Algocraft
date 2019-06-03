import org.junit.Test;

import static org.junit.Assert.*;

public class PicoTest {

    @Test
    public void construirPicoLoCreaConLaDurabilidadCorrecta(){

        for(int i = -1000;i <= 1000;i++) {
            Pico pico = new Pico(i,null,0);
            assertEquals(i,pico.durabilidad());
        }
    }

}