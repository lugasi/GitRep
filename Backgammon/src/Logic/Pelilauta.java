
package Logic;

import java.util.ArrayList;

/**
 *
 * @author lugasi
 */
public class Pelilauta {
    private ArrayList <Ruutu> kiilat;
    private Koti valkeaKoti;
    private Koti mustaKoti;
    private Vankila valkeaVankila;
    private Vankila mustaVankila;
    
    public Pelilauta()  {
        for (int i = 1; i <= 24; i++)   {
            kiilat.add(new Kiila(i));
        }
        valkeaKoti = new Koti();
        mustaKoti = new Koti();
        valkeaVankila = new Vankila();
        mustaVankila = new Vankila();
    }
    
}
