
package Logic;

/**
 * Tavallinen ruutu, joita on laudalla 24.
 * 
 */
public class Kiila extends Ruutu {
    private String vari;
    
    public Kiila(int luku)  {
        ruutuNro = luku;
        
        if(luku % 2 == 1)   {
            vari = "valkea";
        }
        else    {
            vari = "musta";
        }
    }
}
