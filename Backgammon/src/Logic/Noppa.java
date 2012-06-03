
package Logic;

/**
 * Noppa arpoo luvun väliltä 1-6 ja säilyttää sen kunnes noppaa heitetään
 * uudelleen.
 * 
 */
public class Noppa {
    private int silmaluku;
    private boolean kaytetty;

    public Noppa() {
        silmaluku = 1;
    }
    
    public int heita() {
        silmaluku = (int) (Math.random() * 6) + 1;
        setKaytetty(false);
        return silmaluku;
    }

    public int getSilmaluku() {
        return silmaluku;
    }
    
    public boolean getKaytetty()   {
        return kaytetty;
    }
    
    public void setKaytetty(boolean k) {
        kaytetty = k;
    }

    @Override
    public String toString() {
        return "" + silmaluku + (kaytetty ? " (käytetty)" : "");
    }
    
    
}
