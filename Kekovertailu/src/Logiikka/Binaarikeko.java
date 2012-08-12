
package Logiikka;

public class Binaarikeko implements Keko {
    private int[] A;
    private int heap_size;
    
    public Binaarikeko()    {
        A = new int[10];
        heap_size = 0;
    }
    
    private int parent(int i)    {
        return (i-1)/2;
    }
    
    private int left(int i)  {
        return 2*i+1;
    }
    
    private int right(int i) {
        return 2*i+2;
    }
    
    private void heapify(int i)  {
        int l = left(i);
        int r = right(i);
        int largest;
        if (r <= heap_size-1)  {
            if (A[l] > A[r])  {
                largest = l;
            }
            else    {
                largest = r;
            }
            if (A[i] < A[largest])    {
                swap(i, largest);
                heapify(largest);
            }
        }
        else if (l == heap_size-1 && A[i] < A[l])    {
            swap(i, l);
        }
    }
    
    @Override
    public int heap_max()   {
        return A[0];
    }
    
    @Override
    public int heap_del_max()   {
        int max = A[0];
        A[0] = A[heap_size-1];
        heap_size--;
        heapify(0);
        return max;
    }
    
    @Override
    public void heap_insert(int k)  {
        heap_size++;
        int i = heap_size-1;
        while (i > 0 && A[parent(i)] < k)   {
            A[i] = A[parent(i)];
            i = parent(i);
        }
        A[i] = k;
    }
    
    @Override
    public void heap_inc_key(int i, int newk)   {
        if (newk > A[i])    {
            A[i] = newk;
            while (i>0 && A[parent(i)] < A[i])  {
                swap(i, parent(i));
                i = parent(i);
            }
        }
    }
    
    @Override
    public void heap_dec_key(int i, int newk)   {
        if (newk < A[i])    {
            A[i] = newk;
            heapify(i);
        }
    }
    
    private void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
