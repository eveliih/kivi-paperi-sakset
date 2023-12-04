package kivipaperisakset;

/**
 * Luokka sisältää pelissä tarvittavat metodit yhden erän voittajan ratkaisemiseen, tasapelilin ja pelin loppumisen tarkastamiseen.
 *
 * @author Eveliina Heino
 */
public class PeliApuri {
    /**
     * Ratkaisee kumpi pelaajista voittaa erän. Ratkaisu perustuu pelaajan valinta-muuttujan arvoon.
     *
     * @param p1 Ensimmäinen pelaaja.
     * @param p2 Toinen pelaaja.
     *
     */
    public Pelaaja ratkaiseEranVoittaja(Pelaaja p1, Pelaaja p2) {

        final boolean P1VOITTAAPAPERILLA = (p1.getValinta().equals("paperi")) && (p2.getValinta().equals("kivi"));
        final boolean P1VOITTAAKIVELLA = (p1.getValinta().equals("kivi")) && (p2.getValinta().equals("sakset"));
        final boolean P1VOITTAASAKSILLA = (p1.getValinta().equals("sakset")) && (p2.getValinta().equals("paperi"));

        if (P1VOITTAAPAPERILLA || P1VOITTAAKIVELLA || P1VOITTAASAKSILLA) {
            p1.lisaaPelaajalleVoitto();

            return p1;

        }

        p2.lisaaPelaajalleVoitto();
        return p2;

    }


    /**
     * Tarkastaa ovatko pelaajien valinnat samat, joka johtaa tasapeliin.
     * @param pelaaja1Valinta ensimmäisen pelaajan valinta
     * @param pelaaja2Valinta toisen pelaajan valinta
     * @return palauttaa true, jos valinnat samat. False, jos valinnat eri.
     */
    public boolean tasapeli(String pelaaja1Valinta, String pelaaja2Valinta) {
        return pelaaja1Valinta.equals(pelaaja2Valinta);
    }


    /**
     * Testataan, onko voittojen raja tullut täyteen toisella pelaajista ja palautetaan onko peli loppu.
     * @param pelaaja1Voitot ensimmäisen pelaajan voittojen lkm
     * @param pelaaja2Voitot toisen pelaajan voittojen lkm
     * @param voittojenRaja monestako voitosta peli loppuu
     * @return true, jos peli loppu, false, jos peli jatkuu
     */
    public boolean peliLoppu(int pelaaja1Voitot, int pelaaja2Voitot, int voittojenRaja) {
        return (pelaaja1Voitot >= voittojenRaja) || (pelaaja2Voitot >= voittojenRaja);
    }


}
