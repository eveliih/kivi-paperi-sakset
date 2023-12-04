package kivipaperisakset;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PelaajaTest  {
    private Pelaaja pelaaja= new Pelaaja();

    @Test
    void valitseVaihtoehto() {
        String valinta = pelaaja.valitseVaihtoehto();
        assertFalse(valinta.isEmpty(), "Valinta palautti tyhjän");
        assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"), "Valinta palautti muuta kuin merkkijonon kivi, paperi tai sakset");
    }

    @Test
    void lisaaPelaajalleVoitto() {
        assertEquals(1, pelaaja.lisaaPelaajalleVoitto(), "Virhe voittojen lisäämisessä.");
    }

}