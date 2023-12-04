import static org.junit.jupiter.api.Assertions.*;

import kivipaperisakset.Pelaaja;
import org.junit.jupiter.api.Test;

/**
 * Testiluokka Pelaaja-luokalle.
 * Tämä luokka sisältää yksikkötestit Pelaaja-luokan metodeille.
 *
 * @author Eveliina
 */
class PelaajaTest {

    private Pelaaja pelaaja = new Pelaaja("1");

    /**
     * Testaa Pelaaja-luokan valitseVaihtoehto-metodia.
     * Tarkistaa, että valinta ei ole tyhjä ja että se on joko "kivi", "paperi" tai "sakset".
     */
    @Test
    void valitseVaihtoehto() {
        String valinta = pelaaja.valitseVaihtoehto();
        assertFalse(valinta.isEmpty(), "Valinta palautti tyhjän");
        assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"),
                "Valinta palautti muuta kuin merkkijonon kivi, paperi tai sakset");
    }

    /**
     * Testaa Pelaaja-luokan lisaaPelaajalleVoitto-metodia.
     * Tarkistaa, että voittojen lisääminen toimii oikein.
     */
    @Test
    void lisaaPelaajalleVoitto() {
        assertEquals(1, pelaaja.lisaaPelaajalleVoitto(), "Virhe voittojen lisäämisessä.");
    }
}