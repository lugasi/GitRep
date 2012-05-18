
package Logic;

/**
 *
 * @author lugasi
 */
public class Kiila extends Ruutu {
    private int valkeaLuku;
    private int mustaLuku;
    private String vari;
    
    public Kiila(int luku)  {
        
        valkeaLuku = luku;
        mustaLuku = 25 - luku;
        
        if(luku % 2 == 1)   {
            vari = "valkea";
        }
        else    {
            vari = "musta";
        }
    }
}
