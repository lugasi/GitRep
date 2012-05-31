
package Logic;

/**
 * Jokaisella nappulalla on väri (valkea tai musta) ja tieto ruudusta jossa
 * nappula sijaitsee.
 * 
 */
public class Nappula {
    private String vari;
    private Ruutu ruutu;
    
    public Nappula(String vari) {
        this.vari = vari;
    }
    
    public void asetaRuutuun(Ruutu ruutu)    {
        this.ruutu = ruutu;
    }

    public String getVari() {
        return vari;
    }

    public Ruutu getRuutu() {
        return ruutu;
    }
    
    
    
    
}
