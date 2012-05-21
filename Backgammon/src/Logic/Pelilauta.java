
package Logic;

import java.util.ArrayList;

/**
 *
 * @author lugasi
 */
public class Pelilauta {
    private ArrayList <Ruutu> ruudut;
    private Ruutu valkeaKoti;
    private Ruutu mustaKoti;
    private Ruutu valkeaVankila;
    private Ruutu mustaVankila;
    
    public Pelilauta()  {
        ruudut = new ArrayList <Ruutu>();
        for (int i = 1; i <= 24; i++)   {
            Ruutu r = new Kiila(i);
            ruudut.add(r);
        }
        valkeaKoti = new Koti();
        mustaKoti = new Koti();
        valkeaVankila = new Vankila();
        mustaVankila = new Vankila();
    }

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
    
    public void asetaNappulatRuutuun(int alkuindeksi, int maara, Ruutu ruutu, ArrayList <Nappula> nappulat)  {
        for (int i = alkuindeksi; i < alkuindeksi + maara; i++) {
            Nappula n = nappulat.get(i);
            ruutu.asetaNappula(n);
            n.asetaRuutuun(ruutu);
        }
    }

    public ArrayList<Ruutu> getRuudut() {
        return ruudut;
    }
    
    
    
}
