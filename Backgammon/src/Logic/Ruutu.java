
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
    
    void asetaNappula(Nappula nappula)   {
        nappulat.add(nappula);
    }
    
}
