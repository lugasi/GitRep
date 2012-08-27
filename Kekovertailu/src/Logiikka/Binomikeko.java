
package Logiikka;

/**
 * Toteutettu listana binomipuita.
 */

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
    
    public Binomikeko heap_union(Binomikeko h1, Binomikeko h2) {
        Binomikeko h = new Binomikeko();
        h.head = heap_merge(h1, h2);
        if (h.head == null)  {
            return h;
        }
        Solmu prev_x = null;
        Solmu x = h.head;
        Solmu next_x = x.sibling;
        
        while (next_x != null)  {
            if ((x.degree != next_x.degree) || (next_x.sibling != null && next_x.sibling.degree == x.degree))   {
                prev_x = x;
                x = next_x;
            }
            else if (x.key >= next_x.key)   {
                x.sibling = next_x.sibling;
                binomial_link(next_x, x);
            }
            else {
                if (prev_x == null) {
                    h.head = next_x;
                }
                else {
                    prev_x.sibling = next_x;
                }
                binomial_link(x, next_x);
                x = next_x;
            }
            next_x = x.sibling;
        }
        return h;
    }
    
    private Solmu heap_merge(Binomikeko h1, Binomikeko h2)  {
        Solmu x = h1.head;
        Solmu y = h2.head;
        if (x == null)  {
            return y;
        }
        else if (y == null) {
            return x;
        }
        
        Solmu new_head;
        if (x.degree <= y.degree)   {
            new_head = x;
            x = x.sibling;
        }
        else    {
            new_head = y;
            y = y.sibling;
        }
        
        Solmu z = new_head;
        while (x != null && y != null)  {
            if ( x.degree <= y.degree ) {
                z.sibling = x;
                x = x.sibling;
            }
            else    {
                z.sibling = y;
                y = y.sibling;
            }
            z = z.sibling;
        }
        
        if (x == null)  {
            z.sibling = y;
        }
        else    {
            z.sibling = x;
        }
        
        return new_head;
    }

    /**
     * Palauttaa keon maksimiarvon tai -2^31 jos keko on tyhjä. 
     */
    @Override
    public int heap_max() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }
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
    
    /**
     * Palauttaa ja poistaa keon maksimiarvon tai palauttaa -2^31 jos keko on tyhjä.
     */
    @Override
    public int heap_del_max() {
        Solmu max = max();
        if (head == null)    {
            return Integer.MIN_VALUE;
        }
        if (head == max)    {
            head = head.sibling;
        }
        else    {
            Solmu prev = head;
            while (true)    {
                if (prev.sibling == max)    {
                    prev.sibling = max.sibling;
                    break;
                }
                prev = prev.sibling;
            }
        }
        
        Binomikeko h = new Binomikeko();
        if (max.child != null)  {
            Solmu prev = null;
            Solmu curr = max.child;
            Solmu next = curr.sibling;
            while (next != null)    {
                curr.sibling = prev;
                prev = curr;
                curr = next;
                next = next.sibling;
            }
            curr.sibling = prev;
            h.head = curr;
        }
        
        this.head = heap_union(this, h).head;
        
        return max.key;
    }

    /**
     * Lisää uuden alkion kekoon. 
     */
    @Override
    public void heap_insert(int k) {
        Solmu s = new Solmu(k);
        Binomikeko h = new Binomikeko();
        h.head = s;
        this.head = heap_union(this, h).head;
    }

    @Override
    public void heap_inc_key(int i, int newk) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void heap_dec_key(int i, int newk) {
        throw new UnsupportedOperationException("Not supported.");
    }
    
}
