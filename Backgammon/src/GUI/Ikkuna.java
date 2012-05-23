package GUI;

import Logic.Peli;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author lugasi
 */
public class Ikkuna extends JFrame {

    private Peli p;
    private JTextField testi;

    public Ikkuna() {
        p = new Peli();
        testi = new JTextField(p.getVuoro() + "n vuoro");
        
        setLayout(new FlowLayout());
        
        add(testi);
    }
    
    public void pelaa() {
        p.asetaAlkutilanne();
        
        
        
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
