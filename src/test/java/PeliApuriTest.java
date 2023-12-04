/**
 * JUnit-testit PeliApuri-luokalle.
 *
 * @author Eveliina
 */
import kivipaperisakset.Pelaaja;
import kivipaperisakset.PeliApuri;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Testiluokka PeliApurille.
 */
class PeliApuriTest {
    private final PeliApuri peliApuri = new PeliApuri();

    @Mock
    Pelaaja pelaaja1Mock;
    @Mock
    Pelaaja pelaaja2Mock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        when(pelaaja1Mock.getNimi()).thenReturn("1");
        when(pelaaja2Mock.getNimi()).thenReturn("2");
    }

    /**
     * Testataan että tulee tasapeli samoilla valinnoilla.
     */
    @Test
    void tasapeli() {
        String pelaajan1Valinta = "kivi";
        String pelaajan2Valinta = "kivi";

        assertTrue(peliApuri.tasapeli(pelaajan1Valinta, pelaajan2Valinta), "Samoilla valinnoilla pitää tulla tasapeli.");
    }

    /**
     * Testataan, että eri valinnat eivät aiheuta tasapeliä.
     */
    @Test
    void eiTasapeli() {
        String pelaajan1Valinta = "kivi";
        String pelaajan2Valinta = "sakset";

        assertFalse(peliApuri.tasapeli(pelaajan1Valinta, pelaajan2Valinta), "Eroavilla merkkijonoilla ei tasapeliä.");
    }

    /**
     * Testaa voittaako kivi sakset.
     */
    @Test
    void kiviVoittaaSakset() {
        when(pelaaja1Mock.getValinta())
                .thenReturn("kivi");
        when(pelaaja2Mock.getValinta())
                .thenReturn("sakset");

        assertEquals("1", peliApuri.ratkaiseEranVoittaja(pelaaja1Mock, pelaaja2Mock).getNimi(), "Kiven pitää voittaa sakset.");
    }

    /**
     * Testaa häviääkö kivi paperille
     */
    @Test
    void kiviHaviaaPaperille() {
        when(pelaaja1Mock.getValinta())
                .thenReturn("kivi");
        when(pelaaja2Mock.getValinta())
                .thenReturn("paperi");

        assertEquals("2", peliApuri.ratkaiseEranVoittaja(pelaaja1Mock, pelaaja2Mock).getNimi(), "Kiven pitää hävitä paperille.");
    }

    /**
     * Testaa että peli loppuu kun asetettu voittojen raja täyttyy
     */
    @Test
    void peliLoppu() {
        int p1Voitot = 1;
        int p2Voitot = 3;
        int voittojenRaja = 3;

        assertTrue(peliApuri.peliLoppu(p1Voitot, p2Voitot, voittojenRaja));
    }

    /**
     * Testaa että peli ei lopu, jos rajaa ei ole ylitetty.
     */
    @Test
    void peliEiLoppu() {
        int p1Voitot = 1;
        int p2Voitot = 2;
        int voittojenRaja = 3;

        assertFalse(peliApuri.peliLoppu(p1Voitot, p2Voitot, voittojenRaja));
    }
}
