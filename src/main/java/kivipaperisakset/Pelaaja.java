
package kivipaperisakset;

/**
 * Luokka kuvaa yhtä pelin pelaajaa. Pelaajalla on nimi, voittojen laskuri ja valinta (kivi, paperi tai sakset)
 *
 * @author Eveliina Heino
 */
public class Pelaaja {

    private int voitot = 0;
    private final String nimi;
    private String valinta = "";

    /**
     * Luo uuden pelaajan annetulla nimellä.
     *
     * @param nimi Pelaajan nimi.
     */
    public Pelaaja(String nimi) {
        this.nimi = nimi;
    }


    /**
     * Valitse randomilla kivi, paperi tai sakset
     *
     * @return palauttaa pelaajan valinnan
     */
    public String valitseVaihtoehto() {
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
        return valinta;
    }

    /**
     * Kasvattaa pelaajan voittojen määrää yhdellä.
     *
     * @return palauttaa pelaajajan voittojen kokonaismäärän lisäyksen jälkeen
     */
    public int lisaaPelaajalleVoitto() {
        voitot += 1;
        return voitot;
    }

    /**
     * @return palauttaa pelaajajan voittojen kokonaismäärän
     */
    public int getVoitot() {
        return (voitot);
    }

    /**
     * @return palauttaa pelaajajan valinnan (kivi, paperi, sakset).
     */
    public String getValinta() {
        return valinta;
    }

    /**
     * @return palauttaa pelaajajan nimen
     */
    public String getNimi() {
        return nimi;
    }
}
