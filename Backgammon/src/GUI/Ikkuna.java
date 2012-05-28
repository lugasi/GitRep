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
    
    private JButton[] r = new JButton[24];
    
    private JButton n1 = new JButton("");
    private JButton n2 = new JButton("");
    
    private JButton v1 = new JButton("");
    private JButton v2 = new JButton("");
    
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    
    private JPanel p5;
    private JPanel p6;
    
    private JPanel p7;

    public Ikkuna() {
        peli = new Peli();
        
        for (int i = 0; i < 24; i++)    {
            r[i] = new JButton("" + (i+1));
        }
        
        p1 = new JPanel(new GridLayout(1,6));
        p1.add(r[5]);
        p1.add(r[4]);
        p1.add(r[3]);
        p1.add(r[2]);
        p1.add(r[1]);
        p1.add(r[0]);
        
        p2 = new JPanel(new GridLayout(1,6));
        p2.add(r[11]);
        p2.add(r[10]);
        p2.add(r[9]);
        p2.add(r[8]);
        p2.add(r[7]);
        p2.add(r[6]);
        
        p3 = new JPanel(new GridLayout(1,6));
        p3.add(r[12]);
        p3.add(r[13]);
        p3.add(r[14]);
        p3.add(r[15]);
        p3.add(r[16]);
        p3.add(r[17]);
        
        p4 = new JPanel(new GridLayout(1,6));
        p4.add(r[18]);
        p4.add(r[19]);
        p4.add(r[20]);
        p4.add(r[21]);
        p4.add(r[22]);
        p4.add(r[23]);
        
        p5 = new JPanel(new BorderLayout());
        p5.add("North", p3);
        p5.add("Center", n1);
        p5.add("South", p2);
        
        p6 = new JPanel(new BorderLayout());
        p6.add("North", p4);
        p6.add("Center", n2);
        p6.add("South", p1);
        
        p7 = new JPanel(new GridLayout(2,1));
        p7.add(v1);
        p7.add(v2);
        
        setLayout(new BorderLayout());
        add("West", p5);
        add("Center", p7);
        add("East", p6);
        
    }
    
    public void pelaa() {
        peli.asetaAlkutilanne();
        paivita();
        
        
    }
    
    public void paivita()   {
        for (int i = 0; i < 24; i++)    {
            r[i].setText(peli.getLauta().getRuudut().get(i).toString());
        }
        v1.setText(peli.getLauta().getMustaVankila().toString());
        v2.setText(peli.getLauta().getValkeaVankila().toString());
        n1.setText("Noppa 1: " + peli.getNoppa1().toString());
        n2.setText("Noppa 2: " + peli.getNoppa2().toString());
        
    }

    public static void main(String[] args) {
        Ikkuna i = new Ikkuna();
        i.setTitle("Backgammon");
        i.pack();
        i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        i.setVisible(true);
        i.setSize(1200, 400);
        i.pelaa();
    }
}
