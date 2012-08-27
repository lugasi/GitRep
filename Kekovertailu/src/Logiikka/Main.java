
package Logiikka;

import java.util.Scanner;

/**
 * Pääohjelma testaa kekojen insert-, max- ja del_max- operaatioihin kuluvaa aikaa.
 * Käyttäjä valitsee testattavan keon ja testin koon.
 * 
 */

public class Main {
    
    public static Scanner lukija = new Scanner(System.in);
    
    public static void main(String[] args) {
        int keko;
        int n = 0;
        Keko k = null;
        
        while (true)  {
            try {
                System.out.println("Valitse testattava keko: (1) binäärikeko (2) binomikeko (3) Fibonacci-keko (4+) lopeta");
                keko = lukija.nextInt();
            }
            catch (Exception e) {
                break;
            }
            if (keko > 3 || keko < 1)   {
                break;
            }
            
            if (keko == 1)  {
                k = new Binaarikeko();
            }
            else if (keko == 2) {
                k = new Binomikeko();
            }
            else if (keko == 3) {
                k = new Fibonaccikeko();
            }
            
            while(true) {
                try {
                    System.out.println("Testin koko (n > 0):");
                    n = lukija.nextInt();
                    if (n <= 0) {
                        continue;
                    }
                    break;
                }
                catch (Exception e) {
                    lukija.nextLine();
                }
            }
            long alkuaika;
            long loppuaika;
            alkuaika = System.currentTimeMillis();
            for (int i = 0; i < n; i++)    {
                k.heap_insert((int)(100 * Math.random() + 1));
            }
            loppuaika = System.currentTimeMillis();
            System.out.println(n + " insert-operaatiota: " + (loppuaika-alkuaika) + " ms.");
            
            alkuaika = System.currentTimeMillis();
            for (int i = 0; i < n; i++)    {
                k.heap_max();
            }
            loppuaika = System.currentTimeMillis();
            System.out.println(n + " max-operaatiota: " + (loppuaika-alkuaika) + " ms.");
            
            alkuaika = System.currentTimeMillis();
            for (int i = 0; i < n; i++)    {
                int key = k.heap_del_max();
            }
            loppuaika = System.currentTimeMillis();
            System.out.println(n + " del_max-operaatiota: " + (loppuaika-alkuaika) + " ms.");
        }
    }
}
