
package Logiikka;

public class Fibonaccikeko implements Keko {
    
    private FibSolmu max;
    private int heap_size;

    public Fibonaccikeko() {
        max = null;
        heap_size = 0;
    }
    
    

    @Override
    public int heap_max() {
        if (max == null)    {
            return Integer.MIN_VALUE;
        }
        return max.key;
    }

    @Override
    public int heap_del_max() {
        if (max == null)    {
            return Integer.MIN_VALUE;
        }
        
        
        
        return 0;
    }

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
