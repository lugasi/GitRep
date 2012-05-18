
package Logic;

import java.util.ArrayList;

/**
 *
 * @author lugasi
 */
class Ruutu {
    
    private ArrayList <Nappula> nappulat;
    
    public Ruutu()  {
        nappulat = new ArrayList <Nappula>();
        
    }
    
    public void asetaNappula(Nappula nappula)   {
        nappulat.add(nappula);
    }
    
    public void poistaNappula(Nappula nappula)  {
        nappulat.remove(nappula);
    }
    
    public void siirraNappula(Nappula nappula, Ruutu lahto)    {
        nappulat.add(nappula);
        lahto.poistaNappula(nappula);
    }
}
