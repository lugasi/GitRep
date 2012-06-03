package GUI;

import Logic.Noppa;
import Logic.Peli;
import Logic.Ruutu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Piirtää pelin graafisen näkymän ja kontrolloi pelin kulkua.
 *
 */
public class Ikkuna extends JFrame {

    private Peli peli;
    private boolean nopanHeitto = false;
    private boolean lahtoRuudunValinta = false;
    private boolean maaliRuudunValinta = false;
    private boolean nopanValinta = false;
    private Ruutu lahtoRuutu;
    private Ruutu maaliRuutu;
    private Noppa noppa;
    private JButton[] r = new JButton[24];
    private JButton n1 = new JButton("");
    private JButton n2 = new JButton("");
    private JButton v1 = new JButton("");
    private JButton v2 = new JButton("");
    private JButton info = new JButton("");
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JPanel p5;
    private JPanel p6;
    private JPanel p7;

    public Ikkuna() {
        peli = new Peli();

        for (int i = 0; i < 24; i++) {
            r[i] = new JButton("" + (i + 1));
            r[i].setActionCommand("" + i);
        }

        p1 = new JPanel(new GridLayout(1, 6));
        p1.add(r[5]);
        p1.add(r[4]);
        p1.add(r[3]);
        p1.add(r[2]);
        p1.add(r[1]);
        p1.add(r[0]);

        p2 = new JPanel(new GridLayout(1, 6));
        p2.add(r[11]);
        p2.add(r[10]);
        p2.add(r[9]);
        p2.add(r[8]);
        p2.add(r[7]);
        p2.add(r[6]);

        p3 = new JPanel(new GridLayout(1, 6));
        p3.add(r[12]);
        p3.add(r[13]);
        p3.add(r[14]);
        p3.add(r[15]);
        p3.add(r[16]);
        p3.add(r[17]);

        p4 = new JPanel(new GridLayout(1, 6));
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

        p7 = new JPanel(new GridLayout(3, 1));
        p7.add(v1);
        p7.add(info);
        p7.add(v2);
        
        setLayout(new BorderLayout());
        
        add("West", p5);
        add("Center", p7);
        add("East", p6);
        
        
        n1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (nopanHeitto) {
                    peli.heitaNopat();
                    nopanHeitto = false;
                } else if (nopanValinta) {
                    noppa = peli.getNoppa1();
                    nopanValinta = false;
                }
                paivita();
            }
        });

        n2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (nopanHeitto) {
                    peli.heitaNopat();
                    nopanHeitto = false;
                } else if (nopanValinta) {
                    noppa = peli.getNoppa2();
                    nopanValinta = false;
                }
                paivita();
            }
        });

        for (int i = 0; i < 24; i++) {

            r[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    int valittuRuutu = Integer.parseInt(e.getActionCommand());

                    if (lahtoRuudunValinta) {

                        lahtoRuutu = peli.getLauta().getRuudut().get(valittuRuutu);
                        lahtoRuudunValinta = false;
                    } else if (maaliRuudunValinta) {
                        maaliRuutu = peli.getLauta().getRuudut().get(valittuRuutu);
                        maaliRuudunValinta = false;
                    }
                    paivita();
                }
            });
        }

        v1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (lahtoRuudunValinta) {

                    lahtoRuutu = peli.getLauta().getMustaVankila();
                    lahtoRuudunValinta = false;
                }
                if (maaliRuudunValinta) {

                    maaliRuutu = peli.getLauta().getValkeaKoti();
                    maaliRuudunValinta = false;
                }
                paivita();
            }
        });
        
        v2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (lahtoRuudunValinta) {

                    lahtoRuutu = peli.getLauta().getValkeaVankila();
                    lahtoRuudunValinta = false;
                }
                if (maaliRuudunValinta) {
                    maaliRuutu = peli.getLauta().getMustaKoti();
                    maaliRuudunValinta = false;
                }
                paivita();
            }
        });

    }

    public void pelaa() {
        peli.asetaAlkutilanne();
        paivita();

        while (peli.getVoittaja().isEmpty()) {
            if (!peli.isEkaKierros()) {
                peli.heitaNopat();
                //heitaNopat();
                paivita();
            }
            siirraNappuloita();
            peli.vuoroVaihtuu();
            peli.tarkistaVoittaja();
        }
        lopetus();
    }

    public void paivita() {
        for (int i = 0; i < 24; i++) {
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
    
    public void lopetus()   {
        if (peli.getVoittaja().equals("valkea"))    {
            n1.setText("Valkea voitti!");
            n2.setText("Valkea voitti!");
            info.setText("Valkea voitti!");
        }
        if (peli.getVoittaja().equals("musta"))    {
            n1.setText("Musta voitti!");
            n2.setText("Musta voitti!");
            info.setText("Musta voitti!");
        }
    }

    private void heitaNopat() {
        info.setText("Heitä nopat.");
        nopanHeitto = true;
        while (nopanHeitto) {
        }

    }

    private void siirraNappuloita() {
        while (peli.noppiaKayttamatta() && peli.siirtojaJaljella() && peli.getVoittaja().isEmpty()) {
            
            info.setText("Valitse lähtöruutu.");
            lahtoRuudunValinta = true;
            while (lahtoRuudunValinta) {
            }

            info.setText("Valitse maaliruutu.");
            maaliRuudunValinta = true;
            while (maaliRuudunValinta) {
            }

            info.setText("Valitse noppa.");
            nopanValinta = true;
            while (nopanValinta) {
            }


            peli.yritaSiirtaaNappulaa(lahtoRuutu, maaliRuutu, noppa);
            peli.tarkistaVoittaja();
            paivita();
        }
    }
}
