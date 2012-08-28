
package Logiikka;

/**
 * Toteutettu listana puita.
 */
public class Fibonaccikeko implements Keko {
    
    private FibSolmu max;
    private int heap_size;

    public Fibonaccikeko() {
        max = null;
        heap_size = 0;
    }
    
    /**
     * Palauttaa keon maksimiarvon tai -2^31 jos keko on tyhjä.
     */
    @Override
    public int heap_max() {
        if (max == null)    {
            return Integer.MIN_VALUE;
        }
        return max.key;
    }

    /**
     * Palauttaa ja poistaa keon maksimiarvon tai palauttaa -2^31 jos keko on tyhjä.
     */
    @Override
    public int heap_del_max() {
        if (max == null)    {
            return Integer.MIN_VALUE;
        }
        FibSolmu z = max;
        FibSolmu x = z.child;
        if (x != null)    {
            while (x.parent != null)    {
                x.parent = null;
                x = x.right;
            }
            concatenate(max, x);
        }
        z.left.right = z.right;
        z.right.left = z.left;
        if (z == z.right)   {
            max = null;
        } 
        else    {
            max = z.right;
            consolidate();
        }
        heap_size--;
        return z.key;
    }
    
    /**
     * Muuttaa keon muotoon, jossa jokaisella juurella on eri astearvo.
     */
    private void consolidate()  {
        FibSolmu[] A = new FibSolmu[heap_size];
        for (int i = 0; i < A.length; i++) {
            A[i] = null;
        }
        FibSolmu w = max;
        boolean first = true;
        while (w != max || first)   {
            FibSolmu x = w;
            int d = x.degree;   
            while (A[d] != null)    {
                FibSolmu y = A[d];
                if (x.key < y.key)  {
                    int temp_degree = x.degree;
                    int temp_key = x.key;
                    boolean temp_mark = x.mark;
                    x.degree = y.degree;
                    x.key = y.key;
                    x.mark = y.mark;
                    y.degree = temp_degree;
                    y.key = temp_key;
                    y.mark = temp_mark;
                }            
                y.left.right = y.right;
                y.right.left = y.left;
                
                y.left = y;
                y.right = y;
                
                
                if (x.child == null){
                    x.child = y;
                }
                else    {
                    concatenate(x.child, y);
                }
                x.degree++;
                y.mark = false;
                A[d] = null;
                d++;
            }
            w = w.right;
            first = false;
            A[d] = x; 
        }
        FibSolmu next = max.right;
        max = null;
        for (int i = 0; i < heap_size; i++) {
            if (A[i] != null)   {
                A[i].parent = null;
                A[i].left = A[i];
                A[i].right = A[i];
                concatenate(next, A[i]);
                if (max == null || A[i].key > max.key)  {
                    max = A[i];
                }
            }
        }
    }

    /**
     * Lisää uuden alkion kekoon. 
     */
    @Override
    public void heap_insert(int k) {
        FibSolmu s = new FibSolmu(k);
        s.left = s;
        s.right = s;
        if (max == null)    {
            max = s;
        }
        else    {
            concatenate(max, s);
            if (s.key > max.key)    {
                max = s;
            }
        }
        heap_size++;
    }
    
    /**
     * Yhdistää kaksi listaa, joiden solmuja a ja b ovat. 
     */
    private void concatenate(FibSolmu a, FibSolmu b)    {
        if (a == null || b == null) {
            return;
        }
        FibSolmu next = a.right;
        FibSolmu prev = b.left;
        next.left = prev;
        a.right = b;
        prev.right = next;
        b.left = a;
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
