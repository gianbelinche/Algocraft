import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PicoTest {

    @Test
    public void construirPicoLoCreaConLaDurabilidadCorrecta(){

        for(int i = -1000;i <= 1000;i++) {
            Pico pico = new Pico(i,null,0);
            assertEquals(i,pico.durabilidad());
        }
    }

}