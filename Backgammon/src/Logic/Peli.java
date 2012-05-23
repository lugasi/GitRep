package Logic;

import java.util.ArrayList;

/**
 *
 * @author lugasi
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

    public void asetaAlkutilanne() {
        lauta.asetaNappulatRuutuihin(valkeat, mustat);
        ekaKierros = true;
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
        if (onnistui && tuplat == true && noppa1.getKaytetty() == true && noppa2.getKaytetty() == true)   {
            tuplat = false;
            noppa1.setKaytetty(false);
            noppa2.setKaytetty(false);
        }
        return onnistui;
    }

    public void heitaNopat() {
        noppa1.heita();
        noppa2.heita();
        if (noppa1.getSilmaluku() == noppa2.getSilmaluku()) {
            tuplat = true;
        }
    }

    private void vuoroVaihtuu() {
        ekaKierros = false;
        if (vuoro.equals("valkea")) {
            vuoro = "musta";
        } else if (vuoro.equals("musta")) {
            vuoro = "valkea";
        }
    }

    private void lopetus() {
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
    
    
}
