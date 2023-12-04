package kivipaperisakset;

/**
 *
 * @author Ira Dook
 */
public class Peli {


    public static void main(String args[]) {

        final int VOITTOJENRAJA = 3;
        PeliApuri peliApuri = new PeliApuri();

        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        boolean peliLoppui = false;
        int pelatutPelit = 0;
        int tasapelit = 0;

        do {

            p1.valitseVaihtoehto();
            p2.valitseVaihtoehto();

            peliApuri.tulostaEranAlkutiedot(p1.getValinta(), p2.getValinta(), pelatutPelit);

            if (peliApuri.tasapeli(p1.getValinta(), p2.getValinta())){
                tasapelit++;
            }else{
                peliApuri.ratkaiseEranVoittaja(p1, p2);
            }

            pelatutPelit++;

            peliApuri.tulostaTilanne(p1.getVoitot(), p2.getVoitot(), tasapelit);

            if (peliApuri.peliLoppu(p1.getVoitot(), p2.getVoitot(), VOITTOJENRAJA)) {
                peliLoppui = true;
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            }

            System.out.println();

        } while (!peliLoppui);


    }


}


