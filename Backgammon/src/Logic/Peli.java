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
        if (noppa1.getSilmaluku() > noppa2.getSilmaluku()) {
            vuoro = "valkea";
        } else {
            vuoro = "musta";
        }
    }

    public void pelaa() {
        asetaAlkutilanne();

        while (voittaja.isEmpty()) {
            if (!ekaKierros) {
                heitaNopat();
                if (noppa1.getSilmaluku() == noppa2.getSilmaluku()) {
                    tuplat = true;
                }
            }
            siirraNappuloita();
            vuoroVaihtuu();
        }

        lopetus();

    }

    public void siirraNappuloita() {
        while (noppa1.getKaytetty() == false || noppa2.getKaytetty() == false) {
        }
    }

    public void heitaNopat() {
        noppa1.heita();
        noppa2.heita();
    }

    private void vuoroVaihtuu() {
        if (vuoro.equals("valkea")) {
            vuoro = "musta";
        } else if (vuoro.equals("musta")) {
            vuoro = "valkea";
        }
    }
    
    private void lopetus()  {
        
    }
}
