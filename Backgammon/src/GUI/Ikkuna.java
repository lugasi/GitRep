package GUI;

import Logic.Peli;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author lugasi
 */
public class Ikkuna extends JFrame {

    private Peli peli;
    
    private JButton r1 = new JButton("1");
    private JButton r2 = new JButton("2");
    private JButton r3 = new JButton("3");
    private JButton r4 = new JButton("4");
    private JButton r5 = new JButton("5");
    private JButton r6 = new JButton("6");
    
    private JButton r7 = new JButton("7");
    private JButton r8 = new JButton("8");
    private JButton r9 = new JButton("9");
    private JButton r10 = new JButton("10");
    private JButton r11 = new JButton("11");
    private JButton r12 = new JButton("12");
    
    private JButton r13 = new JButton("13");
    private JButton r14 = new JButton("14");
    private JButton r15 = new JButton("15");
    private JButton r16 = new JButton("16");
    private JButton r17 = new JButton("17");
    private JButton r18 = new JButton("18");
    
    private JButton r19 = new JButton("19");
    private JButton r20 = new JButton("20");
    private JButton r21 = new JButton("21");
    private JButton r22 = new JButton("22");
    private JButton r23 = new JButton("23");
    private JButton r24 = new JButton("24");
    
    private JButton v1 = new JButton("");
    private JButton v2 = new JButton("");
    
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    

    public Ikkuna() {
        peli = new Peli();
        
        p1 = new JPanel(new GridLayout(1,6));
        p1.add(r6);
        p1.add(r5);
        p1.add(r4);
        p1.add(r3);
        p1.add(r2);
        p1.add(r1);
        
        p2 = new JPanel(new GridLayout(1,6));
        p2.add(r12);
        p2.add(r11);
        p2.add(r10);
        p2.add(r9);
        p2.add(r8);
        p2.add(r7);
        
        p3 = new JPanel(new GridLayout(1,6));
        p3.add(r13);
        p3.add(r14);
        p3.add(r15);
        p3.add(r16);
        p3.add(r17);
        p3.add(r18);
        
        p4 = new JPanel(new GridLayout(1,6));
        p4.add(r19);
        p4.add(r20);
        p4.add(r21);
        p4.add(r22);
        p4.add(r23);
        p4.add(r24);
        
        
        
        setLayout(new GridLayout(2, 3));
        add(p3);
        add(v1);
        add(p4);
        add(p2);
        add(v2);
        add(p1);
    }
    
    public void pelaa() {
        peli.asetaAlkutilanne();
        
        
        
    }

    public static void main(String[] args) {
        Ikkuna i = new Ikkuna();
        i.setTitle("Backgammon");
        i.pack();
        i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        i.setVisible(true);
        i.pelaa();
    }
}
