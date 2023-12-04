package kivipaperisakset;

/**
 * Peli-luokka mallintaa kivipaperisakset-peliä kahden pelaajan välillä.
 * Peli jatkuu, kunnes jompikumpi pelaajista saavuttaa voittojen rajan.
 * Peli hyödyntää PeliApuri-luokkaa päätösten tekemiseen.
 *
 * @author Eveliina
 */
public class Peli {
    /**
     * Pääohjelma käynnistää kivipaperisakset-pelin.
     *
     * @param args Ohjelman käynnistyksessä käytettävät argumentit (ei käytössä tässä sovelluksessa).
     */
    public static void main(String args[]) {

        final int VOITTOJENRAJA = 3;
        PeliApuri peliApuri = new PeliApuri();

        Pelaaja p1 = new Pelaaja("1");
        Pelaaja p2 = new Pelaaja("2");
        boolean peliLoppui = false;
        int pelatutPelit = 0;
        int tasapelit = 0;
        Pelaaja eranVoittaja;

        do {

            p1.valitseVaihtoehto();
            p2.valitseVaihtoehto();

            tulostaEranAlkutiedot(p1, p2, pelatutPelit);

            if (peliApuri.tasapeli(p1.getValinta(), p2.getValinta())) {
                System.out.println("\n\t\t\t Tasapeli \n");
                tasapelit++;
            } else {
                eranVoittaja = peliApuri.ratkaiseEranVoittaja(p1, p2);
                System.out.println("Pelaaja " + eranVoittaja.getNimi() + " voittaa\n");
            }

            pelatutPelit++;

            tulostaTilanne(p1, p2, tasapelit);

            if (peliApuri.peliLoppu(p1.getVoitot(), p2.getVoitot(), VOITTOJENRAJA)) {
                peliLoppui = true;
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            }

            System.out.println();

        } while (!peliLoppui);


    }
    /**
     * Tulostaa erän alkutiedot, kuten pelaajien valinnat ja erän numeron.
     *
     * @param p1 Pelaaja 1.
     * @param p2 Pelaaja 2.
     * @param pelatutPelit Pelattujen pelien määrä.
     */
    private static void tulostaEranAlkutiedot(Pelaaja p1, Pelaaja p2, int pelatutPelit) {
        System.out.println("Erä: "
                + pelatutPelit + " =====================\n");
        System.out.println("Pelaaja 1: " + p1.getValinta());
        System.out.println("Pelaaja 2: " + p2.getValinta() + "\n");
    }
    /**
     * Tulostaa pelitilanteen, mukaan lukien pelaajien voitot ja tasapelien määrän.
     *
     * @param p1 Pelaaja 1.
     * @param p2 Pelaaja 2.
     * @param tasapelit Tasapelien määrä.
     */
    private static void tulostaTilanne(Pelaaja p1, Pelaaja p2, int tasapelit) {
        System.out.println("Pelaaja " + p1.getNimi() + ": " + p1.getVoitot() + " voittoa.");
        System.out.println("Pelaaja " + p2.getNimi() + ": " + p2.getVoitot() + " voittoa.\n");
        System.out.println("Tasapelien lukumäärä: "
                + tasapelit + "\n");
    }

}


