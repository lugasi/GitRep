
package Logiikka;

public class Binaarikeko {
    private int[] A;
    private int koko;
    
    public Binaarikeko()    {
        A = new int[10];
        koko = 0;
    }
    
    public int parent(int i)    {
        return i/2;
    }
    
    public int left(int i)  {
        return 2*i;
    }
    
    public int right(int i) {
        return 2*i+1;
    }
    
    public void heapify(int i)  {
        int l = left(i);
        int r = right(i);
        int largest;
        if (r <= koko)  {
            if (A[l] > A[r])  {
                largest = l;
            }
            else    {
                largest = r;
            }
            if (A[i] < A[largest])    {
                //swap
                heapify(largest);
            }
        }
        else if (l == koko && A[i] < A[l])    {
            //swap
        }
    }
    
    public int heap_max()   {
        return A[1];
    }
    
    public int heap_del_max()   {
        int max = A[1];
        A[1] = A[koko + 1];
        koko--;
        heapify(1);
        return max;
    }
    
    public void heap_insert(int k)  {
        koko++;
        int i = koko;
        while (i > 1 && A[parent(i)] < k)   {
            A[i] = A[parent(i)];
            i = parent(i);
        }
        A[i] = k;
    }
    
    public void heap_inc_key(int i, int newk)   {
        if (newk > A[i])    {
            A[i] = newk;
            while (i>1 && A[parent(i)] < A[i])  {
                //swap
                i = parent(i);
            }
        }
    }
    
    public void heap_dec_key(int i, int newk)   {
        if (newk < A[i])    {
            A[i] = newk;
            heapify(i);
        }
    }
}
