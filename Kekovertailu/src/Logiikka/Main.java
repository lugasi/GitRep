
package Logiikka;

import java.util.Scanner;

public class Main {
    
    public static Scanner lukija = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean jatkuu = true;
        int keko = 0;
        Keko k;
        
        while (jatkuu)  {
            try {
                System.out.println("Valitse testattava keko: (1) binäärikeko (2) binomikeko (3) Fibonacci-keko (muu) lopeta");
                keko = lukija.nextInt();
            }
            catch (Exception e) {
                jatkuu = false;
            }
            if (keko > 3 || keko < 0)   {
                jatkuu = false;
            }
            
            if (keko == 1)  {
                k = new Binaarikeko();
            }
            else if (keko == 2) {
                k = new Binomikeko();
            }
            
        }
    }
}
