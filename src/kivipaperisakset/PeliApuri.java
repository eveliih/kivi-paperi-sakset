package kivipaperisakset;


public class PeliApuri {
    public void ratkaiseEranVoittaja(Pelaaja p1, Pelaaja p2){

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

    public boolean tasapeli(String pelaaja1Valinta, String pelaaja2Valinta){
        System.out.println("\n\t\t\t Tasapeli \n");
        return pelaaja1Valinta.equals(pelaaja2Valinta);
    }

    public boolean peliLoppu(int pelaaja1Voitot, int pelaaja2Voitot, int voittojenRaja){
        return (pelaaja1Voitot >= voittojenRaja) || (pelaaja2Voitot >= voittojenRaja);
    }

    public void tulostaEranAlkutiedot(String p1Valinta, String p2Valinta, int pelatutPelit){
        System.out.println("Erä: "
                + pelatutPelit + " =====================\n");
        System.out.println("Pelaaja 1: " + p1Valinta);
        System.out.println("Pelaaja 2: " + p2Valinta + "\n");
    }

    public void tulostaTilanne(int p1Voitot, int p2Voitot, int tasapelit){
        System.out.println("Pelaaja 1:llä koossa " + p1Voitot + " voittoa.");
        System.out.println("Pelaaja 2:llä koossa " + p2Voitot + " voittoa.\n");
        System.out.println("Tasapelien lukumäärä: "
                + tasapelit + "\n");
    }
}
