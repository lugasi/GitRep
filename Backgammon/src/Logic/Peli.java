
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
    private ArrayList <Nappula> valkeat;
    private ArrayList <Nappula> mustat;
    
    
    public Peli()  {
        lauta = new Pelilauta();
        noppa1 = new Noppa();
        noppa2 = new Noppa();
        valkeat = new ArrayList <Nappula>();
        mustat = new ArrayList <Nappula>();
        for (int i = 0; i < 15; i++)    {
            valkeat.add(new Nappula("valkea"));
            mustat.add(new Nappula("musta"));
        }
    }
    
    private void asetaAlkutilanne() {
        lauta.asetaNappulatRuutuihin(valkeat, mustat);
    }
    
}
