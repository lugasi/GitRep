
package Logiikka;

interface Keko {
    public int heap_max();
    public int heap_del_max();
    public void heap_insert(int k);
    public void heap_inc_key(int i, int newk);
    public void heap_dec_key(int i, int newk);
}
