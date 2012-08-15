
package Logiikka;

public class Solmu {
    public Solmu parent;
    public int key;
    public int degree;
    public Solmu child;
    public Solmu sibling;
    
    public Solmu()  {
        parent = null;
        key = 0;
        degree = 0;
        child = null;
        sibling = null;
    }
}
