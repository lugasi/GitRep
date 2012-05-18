
package Logic;

/**
 *
 * @author lugasi
 */
public class Peli {
    Pelilauta lauta;
    Noppa noppa1;
    Noppa noppa2;
    Pelaaja valkea;
    Pelaaja musta;
    
    
    public Peli()  {
        lauta = new Pelilauta();
        noppa1 = new Noppa();
        noppa2 = new Noppa();
        valkea = new Pelaaja("valkea");
        musta = new Pelaaja("musta");
    }
    
}
