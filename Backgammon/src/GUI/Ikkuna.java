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
        testi = new JTextField("Testi");
        
        setLayout(new FlowLayout());
        
        add(testi);
    }

    public static void main(String[] args) {
        Ikkuna ikkuna = new Ikkuna();
        ikkuna.setTitle("Backgammon");
        ikkuna.pack();
        ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ikkuna.setVisible(true);
    }
}
