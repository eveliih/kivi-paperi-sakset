package kivipaperisakset;

/**
 *
 * @author Ira Dook
 */
public class Peli {
    private static final int VOITTOJENRAJA = 3;

    public static void main(String args[]) {
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        boolean peliLoppui = false;
        int pelatutPelit = 0;
        int tasapelit = 0;

        do {

            p1.valitseVaihtoehto();
            p2.valitseVaihtoehto();

            tulostaEranAlkutiedot(p1.getValinta(), p2.getValinta(), pelatutPelit);

            if (tasapeli(p1.getValinta(), p2.getValinta())){
                tasapelit++;
            }else{
                ratkaiseEranVoittaja(p1, p2);
            }

            pelatutPelit++;

            tulostaTilanne(p1.getVoitot(), p2.getVoitot(), tasapelit);

            if (peliLoppu(p1.getVoitot(), p2.getVoitot())) {
                peliLoppui = true;
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            }

            System.out.println();

        } while (!peliLoppui);


    }

    private static  void ratkaiseEranVoittaja(Pelaaja p1, Pelaaja p2){

        final boolean P1VOITTAAPAPERILLA = (p1.getValinta().equals("paperi")) && (p2.getValinta().equals("kivi"));
        final boolean P1VOITTAAKIVELLA = (p1.getValinta().equals("kivi")) && (p2.getValinta().equals("sakset"));
        final boolean P1VOITTAASAKSILLA = (p1.getValinta().equals("sakset")) && (p2.getValinta().equals("paperi"));

        if(P1VOITTAAPAPERILLA || P1VOITTAAKIVELLA || P1VOITTAASAKSILLA){
            p1.lisaaPelaajalleVoitto();
            System.out.println("Pelaaja 1 voittaa\n");
        }

        p2.lisaaPelaajalleVoitto();
        System.out.println("Pelaaja 2 voittaa\n");
    }

    private static boolean tasapeli(String pelaaja1Valinta, String pelaaja2Valinta){
        System.out.println("\n\t\t\t Tasapeli \n");
        return pelaaja1Valinta.equals(pelaaja2Valinta);
    }

    private static boolean peliLoppu(int pelaaja1Voitot, int pelaaja2Voitot){
        return (pelaaja1Voitot >= VOITTOJENRAJA) || (pelaaja2Voitot >= VOITTOJENRAJA);
    }

    private static void tulostaEranAlkutiedot(String p1Valinta, String p2Valinta, int pelatutPelit){
        System.out.println("Erä: "
                + pelatutPelit + " =====================\n");
        System.out.println("Pelaaja 1: " + p1Valinta);
        System.out.println("Pelaaja 2: " + p2Valinta + "\n");
    }

    private static void tulostaTilanne(int p1Voitot, int p2Voitot, int tasapelit){
        System.out.println("Pelaaja 1:llä koossa " + p1Voitot + " voittoa.");
        System.out.println("Pelaaja 2:llä koossa " + p2Voitot + " voittoa.\n");
        System.out.println("Tasapelien lukumäärä: "
                + tasapelit + "\n");
    }
}


