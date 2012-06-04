package Logic;

import java.util.ArrayList;

/**
 * Sisältää kaikki pelin ruudut ja hallinnoi nappuloiden asettelemista ja
 * siirtämistä ruudusta toiseen.
 *
 */
public class Pelilauta {

    private ArrayList<Ruutu> ruudut;
    private Ruutu valkeaKoti;
    private Ruutu mustaKoti;
    private Ruutu valkeaVankila;
    private Ruutu mustaVankila;

    public Pelilauta() {
        ruudut = new ArrayList<Ruutu>();
        for (int i = 1; i <= 24; i++) {
            Ruutu r = new Kiila(i);
            ruudut.add(r);
        }
        valkeaKoti = new Koti(25);
        mustaKoti = new Koti(0);
        valkeaVankila = new Vankila(0);
        mustaVankila = new Vankila(25);
    }
    
    /**
     * Asettaa kaikki nappulat alkuasemiin.
     * 
     * @param valkeat
     * @param mustat 
     */
    public void asetaNappulatRuutuihin(ArrayList<Nappula> valkeat, ArrayList<Nappula> mustat) {
        asetaNappulatRuutuun(0, 2, ruudut.get(0), valkeat);
        asetaNappulatRuutuun(2, 5, ruudut.get(11), valkeat);
        asetaNappulatRuutuun(7, 3, ruudut.get(16), valkeat);
        asetaNappulatRuutuun(10, 5, ruudut.get(18), valkeat);

        asetaNappulatRuutuun(0, 2, ruudut.get(23), mustat);
        asetaNappulatRuutuun(2, 5, ruudut.get(12), mustat);
        asetaNappulatRuutuun(7, 3, ruudut.get(7), mustat);
        asetaNappulatRuutuun(10, 5, ruudut.get(5), mustat);
    }
    
    /**
     * Asettaa tarvittavan määrän tietyn värisiä nappuloita yhteen ruutuun.
     * 
     * @param alkuindeksi
     * @param maara
     * @param ruutu
     * @param nappulat 
     */
    public void asetaNappulatRuutuun(int alkuindeksi, int maara, Ruutu ruutu, ArrayList<Nappula> nappulat) {
        for (int i = alkuindeksi; i < alkuindeksi + maara; i++) {
            Nappula n = nappulat.get(i);
            ruutu.asetaNappula(n);
            n.asetaRuutuun(ruutu);
        }
    }

    public ArrayList<Ruutu> getRuudut() {
        return ruudut;
    }

    public Ruutu getMustaVankila() {
        return mustaVankila;
    }

    public Ruutu getValkeaVankila() {
        return valkeaVankila;
    }

    public Ruutu getMustaKoti() {
        return mustaKoti;
    }

    public Ruutu getValkeaKoti() {
        return valkeaKoti;
    }

    /**
     * Tarkistaa siirron laillisuuden ja toteuttaa sen, jos se on laillinen.
     *
     * @param lahto
     * @param maali
     * @param vuoro
     * @param noppa
     * @return
     */
    public boolean yritaSiirtaaNappulaa(Ruutu lahto, Ruutu maali, String vuoro, Noppa noppa) {
        //tyhjästä ruudusta ei voi siirtää
        if (lahto.getNappulat().isEmpty()) {
            return false;
        }
        //vastustajan nappulaa ei voi siirtää
        if (!lahto.getNappulat().get(0).getVari().equals(vuoro)) {
            return false;
        }
        //vain käyttämättömällä nopalla saa siirtää
        if (noppa.getKaytetty() == true) {
            return false;
        }
        //nappuloiden kotiutussäännöt erilaisia
        if (maali.equals(valkeaKoti) || maali.equals(mustaKoti)) {
            return yritaKotiuttaa(lahto, maali, vuoro, noppa);
        }
        //vastustajan kontrolloimaan (ainakin 2 nappulaa) ruutuun ei saa siirtyä
        if (!maali.getNappulat().isEmpty() && !maali.getNappulat().get(0).getVari().equals(lahto.getNappulat().get(0).getVari()) && maali.getNappulat().size() > 1) {
            return false;
        }
        //vain nopan silmäluvun verran saa siirtyä
        if (Math.abs(maali.getRuutuNro() - lahto.getRuutuNro()) != noppa.getSilmaluku()) {
            return false;
        }

        if (vuoro.equals("valkea") && maali.getRuutuNro() > lahto.getRuutuNro()) {

            //vankilassa olevat nappulat täytyy siirtää ensin pois vankilasta
            if (!valkeaVankila.getNappulat().isEmpty() && !lahto.equals(valkeaVankila)) {
                return false;
            }

            //siirto laillinen, siirretään mahdollinen vastustajan nappula vankilaan
            if (maali.getNappulat().size() == 1 && maali.getNappulat().get(0).getVari().equals("musta")) {
                siirraNappula(maali.getNappulat().get(0), maali, mustaVankila);
            }
        }

        if (vuoro.equals("musta") && maali.getRuutuNro() < lahto.getRuutuNro()) {

            if (!mustaVankila.getNappulat().isEmpty() && !lahto.equals(mustaVankila)) {
                return false;
            }

            if (maali.getNappulat().size() == 1 && maali.getNappulat().get(0).getVari().equals("valkea")) {
                siirraNappula(maali.getNappulat().get(0), maali, valkeaVankila);
            }
        }

        //nappula siirretään ja noppa merkitään käytetyksi
        siirraNappula(lahto.getNappulat().get(0), lahto, maali);
        noppa.setKaytetty(true);
        return true;
    }
    
    /**
     * Päivittää nappulan sijainnin.
     * 
     * @param nappula
     * @param lahto
     * @param maali 
     */
    public void siirraNappula(Nappula nappula, Ruutu lahto, Ruutu maali) {
        nappula.asetaRuutuun(maali);

        maali.asetaNappula(nappula);
        lahto.poistaNappula(nappula);
    }
    
    /**
     * Tarkistaa kotiutussiirron laillisuuden ja toteuttaa sen, jos se on laillinen.
     * 
     * @param lahto
     * @param maali
     * @param vuoro
     * @param noppa
     * @return 
     */
    private boolean yritaKotiuttaa(Ruutu lahto, Ruutu maali, String vuoro, Noppa noppa) {
        //korkeintaan nopan silmäluvun verran saa siirtyä
        if (Math.abs(maali.getRuutuNro() - lahto.getRuutuNro()) > noppa.getSilmaluku()) {
            return false;
        }
        if (vuoro.equals("valkea") && maali.equals(valkeaKoti) && valkeaSaaKotiuttaa()) {
            siirraNappula(lahto.getNappulat().get(0), lahto, maali);
            noppa.setKaytetty(true);
            return true;
        }
        if (vuoro.equals("musta") && maali.equals(mustaKoti) && mustaSaaKotiuttaa()) {
            siirraNappula(lahto.getNappulat().get(0), lahto, maali);
            noppa.setKaytetty(true);
            return true;
        }
        
        return false;
    }

    /**
     * Tarkistaa, ovatko valkean nappulat oikeissa asemissa kotiutusta varten.
     * 
     * @return 
     */
    private boolean valkeaSaaKotiuttaa() {
        if (!valkeaVankila.getNappulat().isEmpty()) {
            return false;
        }
        for (int i = 0; i < 18; i++) {
            if (!ruudut.get(i).getNappulat().isEmpty() && ruudut.get(i).getNappulat().get(0).getVari().equals("valkea")) {
                return false;
            }
        }
        return true;
    }

    /**
     * Tarkistaa, ovatko mustan nappulat oikeissa asemissa kotiutusta varten.
     * 
     * @return 
     */
    private boolean mustaSaaKotiuttaa() {
        if (!mustaVankila.getNappulat().isEmpty()) {
            return false;
        }
        for (int i = 6; i < 24; i++) {
            if (!ruudut.get(i).getNappulat().isEmpty() && ruudut.get(i).getNappulat().get(0).getVari().equals("musta")) {
                return false;
            }
        }
        return true;
    }
}
