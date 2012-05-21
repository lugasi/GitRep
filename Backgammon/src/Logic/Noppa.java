
package Logic;

/**
 *
 * @author lugasi
 */
public class Noppa {
    private int silmaluku;
    private boolean kaytetty;

    public Noppa() {
        silmaluku = 1;
    }
    
    public int heita() {
        silmaluku = (int) Math.random() * 6 + 1;
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
}
