
package Logiikka;

public class Binomikeko implements Keko {
    
    private Solmu head;
    
    public Binomikeko() {
        head = null;
    }
    
    private void binomial_link(Solmu y, Solmu z)    {
        y.parent = z;
        y.sibling = z.child;
        z.child = y;
        z.degree++;
    }
    
    private Binomikeko heap_union(Binomikeko h1, Binomikeko h2) {
        Binomikeko h = new Binomikeko();
        h.head = heap_merge(h1, h2);
        if (h.head == null)  {
            return h;
        }
        Solmu prev_x = null;
        Solmu x = h.head;
        Solmu next_x = x.sibling;
        
        while (next_x != null)  {
            
            
            
        }
        
        return h;
    }
    
    private Solmu heap_merge(Binomikeko h1, Binomikeko h2)  {
        return null;
    }

    @Override
    public int heap_max() {
        return max().key;
    }
    
    private Solmu max() {
        Solmu y = null;
        Solmu x = head;
        int max = Integer.MIN_VALUE;
        while (x != null)   {
            if (x.key > max)    {
                max = x.key;
                y = x;
            }
            x = x.sibling;
        }
        return y;
    }

    @Override
    public int heap_del_max() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void heap_insert(int k) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void heap_inc_key(int i, int newk) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void heap_dec_key(int i, int newk) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
