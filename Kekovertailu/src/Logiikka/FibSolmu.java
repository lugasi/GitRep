
package Logiikka;

public class FibSolmu {
    public FibSolmu parent;
    public int key;
    public int degree;
    public FibSolmu child;
    public FibSolmu left;
    public FibSolmu right;
    public boolean mark;

    public FibSolmu() {
        parent = null;
        key = 0;
        degree = 0;
        child = null;
        left = null;
        right = null;
        mark = false;
    }
    
    public FibSolmu(int key)    {
        this();
        this.key = key;
    }
    
}
