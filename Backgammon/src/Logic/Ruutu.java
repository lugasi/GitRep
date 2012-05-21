
package Logic;

import java.util.ArrayList;

/**
 *
 * @author lugasi
 */
public class Ruutu {
    
    private ArrayList <Nappula> nappulat;
    
    public Ruutu()  {
        nappulat = new ArrayList <Nappula>();
        
    }
    
    public void asetaNappula(Nappula nappula)   {
        nappulat.add(nappula);
    }

    public ArrayList<Nappula> getNappulat() {
        return nappulat;
    }
    
    
    
}
