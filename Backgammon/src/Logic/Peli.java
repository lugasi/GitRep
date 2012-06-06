package Logic;

import java.util.ArrayList;

/**
 * Hallinnoi pelikokonaisuutta eli pelilautaa, noppia, nappuloita,
 * siirtovuoroja, pelin alkamista ja loppumista.
 *
 *
 *
 */
public class Peli {

    private Pelilauta lauta;
    private Noppa noppa1;
    private Noppa noppa2;
    private ArrayList<Nappula> valkeat;
    private ArrayList<Nappula> mustat;
    private String vuoro;
    private String voittaja;
    private boolean ekaKierros;
    private boolean tuplat;

    public Peli() {
        vuoro = "";
        voittaja = "";
        ekaKierros = true;
        tuplat = false;
        lauta = new Pelilauta();
        noppa1 = new Noppa();
        noppa2 = new Noppa();
        valkeat = new ArrayList<Nappula>();
        mustat = new ArrayList<Nappula>();
        for (int i = 0; i < 15; i++) {
            valkeat.add(new Nappula("valkea"));
            mustat.add(new Nappula("musta"));
        }
    }
    
    /**
     * Asettaa pelin alkutilaan.
     * 
     */
    public void asetaAlkutilanne() {
        lauta.asetaNappulatRuutuihin(valkeat, mustat);
        ekaKierros = true;
        voittaja = "";
        while (noppa1.getSilmaluku() == noppa2.getSilmaluku()) {
            heitaNopat();
        }
        tuplat = false;
        if (noppa1.getSilmaluku() > noppa2.getSilmaluku()) {
            vuoro = "valkea";
        } else {
            vuoro = "musta";
        }
    }

    public boolean yritaSiirtaaNappulaa(Ruutu lahto, Ruutu maali, Noppa noppa) {
        boolean onnistui = lauta.yritaSiirtaaNappulaa(lahto, maali, vuoro, noppa);
        if (onnistui && tuplat == true && noppa1.getKaytetty() == true && noppa2.getKaytetty() == true) {
            tuplat = false;
            noppa1.setKaytetty(false);
            noppa2.setKaytetty(false);
        }
        return onnistui;
    }

    /**
     * Heittää molemmat nopat ja tarkistaa tuliko tuplat eli kaksi samaa silmälukua.
     * 
     */
    public void heitaNopat() {
        noppa1.heita();
        noppa2.heita();
        if (noppa1.getSilmaluku() == noppa2.getSilmaluku()) {
            tuplat = true;
        }
    }

    public Noppa getNoppa1() {
        return noppa1;
    }

    public Noppa getNoppa2() {
        return noppa2;
    }

    /**
     * Vaihtaa vuoron: valkea -> musta tai musta -> valkea.
     * 
     */
    public void vuoroVaihtuu() {
        ekaKierros = false;
        if (vuoro.equals("valkea")) {
            vuoro = "musta";
        } else if (vuoro.equals("musta")) {
            vuoro = "valkea";
        }
    }

    public Pelilauta getLauta() {
        return lauta;
    }
    
    /**
     * Tarkistaa, onko jompi kumpi pelaaja saanut kaikki nappulansa kotiutettua.
     * 
     */
    public void tarkistaVoittaja() {
        if (lauta.getValkeaKoti().getNappulat().size() == 15) {
            voittaja = "valkea";
        }
        if (lauta.getMustaKoti().getNappulat().size() == 15) {
            voittaja = "musta";
        }
    }

    public String getVoittaja() {
        return voittaja;
    }

    public String getVuoro() {
        return vuoro;
    }

    public boolean isEkaKierros() {
        return ekaKierros;
    }

    public boolean isTuplat() {
        return tuplat;
    }

    public boolean noppiaKayttamatta() {
        return !noppa1.getKaytetty() || !noppa2.getKaytetty();
    }
    
    /**
     * Tarkistaa, onko pelaajan nappula jäänyt jumiin vankilaan.
     * 
     * @return 
     */
    public boolean siirtojaJaljella() {
        if (vuoro.equals("valkea")) {
            if (lauta.getValkeaVankila().getNappulat().isEmpty()) {
                return true;
            }
            Ruutu r = lauta.getRuudut().get(noppa1.getSilmaluku() - 1);
            if (!noppa1.getKaytetty()) {
                if (voikoRuutuunLiikkua(r)) {
                    return true;
                }
            }
            r = lauta.getRuudut().get(noppa2.getSilmaluku() - 1);
            if (!noppa2.getKaytetty()) {
                if (voikoRuutuunLiikkua(r)) {
                    return true;
                }
            }
            return false;
        } else {
            if (lauta.getMustaVankila().getNappulat().isEmpty()) {
                return true;
            }
            Ruutu r = lauta.getRuudut().get(24 - noppa1.getSilmaluku());
            if (!noppa1.getKaytetty()) {
                if (r.getNappulat().isEmpty() || r.getNappulat().size() == 1 || r.getNappulat().get(0).getVari().equals("musta")) {
                    return true;
                }
            }
            r = lauta.getRuudut().get(24 - noppa2.getSilmaluku());
            if (!noppa2.getKaytetty()) {
                if (r.getNappulat().isEmpty() || r.getNappulat().size() == 1 || r.getNappulat().get(0).getVari().equals("musta")) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean voikoRuutuunLiikkua(Ruutu r) {
        return r.getNappulat().isEmpty() || r.getNappulat().size() == 1 || r.getNappulat().get(0).getVari().equals("valkea");
    }
}
