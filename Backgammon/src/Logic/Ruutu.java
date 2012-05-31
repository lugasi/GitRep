
package Logic;

import java.util.ArrayList;

/**
 * Jokaisella ruudulla on ruutunumero ja lista kaikista nappuloista, jotka
 * ruudussa ovat.
 * 
 */
public class Ruutu {
    protected int ruutuNro;
    private ArrayList <Nappula> nappulat;
    
    public Ruutu()  {
        ruutuNro = -1;
        nappulat = new ArrayList <Nappula>();
        
    }
    
    public void asetaNappula(Nappula nappula)   {
        nappulat.add(nappula);
    }
    
    public void poistaNappula(Nappula nappula)  {
        nappulat.remove(nappula);
    }

    public ArrayList<Nappula> getNappulat() {
        return nappulat;
    }

    public int getRuutuNro() {
        return ruutuNro;
    }
    
    @Override
    public String toString()    {
        if (nappulat.isEmpty()) {
            return "0";
        }
        else    {
            return nappulat.get(0).getVari() + " " + nappulat.size();
        }
    }
    
    
}
