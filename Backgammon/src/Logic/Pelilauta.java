
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
        valkeaKoti = new Koti(25);
        mustaKoti = new Koti(0);
        valkeaVankila = new Vankila(0);
        mustaVankila = new Vankila(25);
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

    public Ruutu getMustaVankila() {
        return mustaVankila;
    }

    public Ruutu getValkeaVankila() {
        return valkeaVankila;
    }
    
    

    public boolean yritaSiirtaaNappulaa(Ruutu lahto, Ruutu maali, String vuoro, Noppa noppa) {
        if (lahto.getNappulat().isEmpty())  {
            return false;
        }
        if (!lahto.getNappulat().get(0).getVari().equals(vuoro)) {
            return false;
        }
        if (Math.abs(maali.getRuutuNro() - lahto.getRuutuNro()) != noppa.getSilmaluku())    {
            return false;
        }
        if (noppa.getKaytetty() == true)    {
            return false;
        }
        if (!maali.getNappulat().isEmpty() && !maali.getNappulat().get(0).getVari().equals(lahto.getNappulat().get(0).getVari()) && maali.getNappulat().size() > 1)    {
            return false;
        }
        
        if (vuoro.equals("valkea") && maali.getRuutuNro() > lahto.getRuutuNro())    {
            if (maali.getNappulat().size() == 1 && maali.getNappulat().get(0).getVari().equals("musta")) {
                siirraNappula(maali.getNappulat().get(0), maali, mustaVankila);
            }
            siirraNappula(lahto.getNappulat().get(0), lahto, maali);
        }
        if (vuoro.equals("musta") && maali.getRuutuNro() < lahto.getRuutuNro())    {
            if (maali.getNappulat().size() == 1 && maali.getNappulat().get(0).getVari().equals("valkea")) {
                siirraNappula(maali.getNappulat().get(0), maali, valkeaVankila);
            }
            siirraNappula(lahto.getNappulat().get(0), lahto, maali);
        }
        noppa.setKaytetty(true);
        return true;
    }
    
    public void siirraNappula(Nappula nappula, Ruutu lahto, Ruutu maali)    {
        nappula.asetaRuutuun(maali);
        
        maali.asetaNappula(nappula);
        lahto.poistaNappula(nappula);
    }
    
}
