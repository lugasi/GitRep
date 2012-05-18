
package Logic;

import java.util.ArrayList;

/**
 *
 * @author lugasi
 */
class Pelaaja {
    private ArrayList <Nappula> nappulat;
    private String vari;
    
    public Pelaaja(String vari) {
        this.vari = vari;
        for (int i = 0; i < 15; i++)    {
            nappulat.add(new Nappula(vari));
        }
    }
    
}
