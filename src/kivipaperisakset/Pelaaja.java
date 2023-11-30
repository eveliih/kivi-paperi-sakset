
package kivipaperisakset;

/**
 *
 * @author Ira Dook
 */
public class Pelaaja {

   private int voitot = 0;      // Voittojen lukumäärä



    private String valinta = "";

    /**
     * Valitse randomilla kivi, paperi tai sakset
     */
    public void valitseVaihtoehto() {
        int arvottuValintaNumero = (int) (Math.random() * 3);
        switch (arvottuValintaNumero) {
            case 0:
                valinta = "kivi";
                break;
            case 1:
                valinta = "paperi";
                break;
            case 2:
                valinta = "sakset";
                break;
        }
    }

    public void lisaaPelaajalleVoitto() {
        voitot += 1;
    }

    public int getVoitot() {
        return (voitot);
    }

    public String getValinta() {
        return valinta;
    }
}
