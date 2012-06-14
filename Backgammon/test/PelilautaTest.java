/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Logic.Nappula;
import Logic.Noppa;
import Logic.Pelilauta;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author lugasi
 */
public class PelilautaTest {
    
    Pelilauta lauta;
    ArrayList <Nappula> valkeat;
    ArrayList <Nappula> mustat;
    Noppa noppa;
    
    public PelilautaTest() {
        lauta = new Pelilauta();
        valkeat = new ArrayList <Nappula>();
        mustat = new ArrayList <Nappula>();
        for (int i = 0; i < 15; i++)    {
            valkeat.add(new Nappula("valkea"));
            mustat.add(new Nappula("musta"));
        }
        noppa = new Noppa();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        lauta.asetaNappulatRuutuihin(valkeat, mustat);
        while(noppa.heita() != 6)   {
            
        }
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void nappulatAsetettuOikein()    {
        assertEquals(2, lauta.getRuudut().get(0).getNappulat().size());
        assertEquals(5, lauta.getRuudut().get(5).getNappulat().size());
        assertEquals(3, lauta.getRuudut().get(7).getNappulat().size());
        assertEquals(5, lauta.getRuudut().get(11).getNappulat().size());
        assertEquals(5, lauta.getRuudut().get(12).getNappulat().size());
        assertEquals(3, lauta.getRuudut().get(16).getNappulat().size());
        assertEquals(5, lauta.getRuudut().get(18).getNappulat().size());
        assertEquals(2, lauta.getRuudut().get(23).getNappulat().size());
    }
    
    @Test
    public void nappulaaEiSiirretaTyhjastaRuudusta()    {
        assertFalse(lauta.yritaSiirtaaNappulaa(lauta.getRuudut().get(2), lauta.getRuudut().get(8), "valkea", noppa));
        assertEquals(0, lauta.getRuudut().get(2).getNappulat().size());
        assertEquals(0, lauta.getRuudut().get(8).getNappulat().size());
    }
    
    @Test
    public void nappulaaEiSiirretaToisenPelaajanVuorolla()  {
        assertFalse(lauta.yritaSiirtaaNappulaa(lauta.getRuudut().get(0), lauta.getRuudut().get(6), "musta", noppa));
        assertEquals(2, lauta.getRuudut().get(0).getNappulat().size());
        assertEquals(0, lauta.getRuudut().get(6).getNappulat().size());  
    }
    
    @Test
    public void nappulaaEiSiirretaJosNopanSilmalukuEiTasmaa()   {
        assertFalse(lauta.yritaSiirtaaNappulaa(lauta.getRuudut().get(0), lauta.getRuudut().get(2), "valkea", noppa));
        assertEquals(2, lauta.getRuudut().get(0).getNappulat().size());
        assertEquals(0, lauta.getRuudut().get(2).getNappulat().size());
        assertEquals(0, lauta.getRuudut().get(6).getNappulat().size());
    }
    
    @Test
    public void nappulaaEiSiirretaVastustajanRuutuun() {
        while(noppa.heita() != 5)   {
            
        }
        assertFalse(lauta.yritaSiirtaaNappulaa(lauta.getRuudut().get(0), lauta.getRuudut().get(5), "valkea", noppa));
    }
    
    @Test
    public void nappulaaEiSiirretaJosToinenNappulaVankilassa()  {
        lauta.siirraNappula(lauta.getRuudut().get(0).getNappulat().get(0), lauta.getRuudut().get(0), lauta.getValkeaVankila());
        assertFalse(lauta.yritaSiirtaaNappulaa(lauta.getRuudut().get(0), lauta.getRuudut().get(5), "valkea", noppa));
    }
    
    @Test
    public void nappulaSiirretaanJosSiirtoLaillinen()   {
        assertTrue(lauta.yritaSiirtaaNappulaa(lauta.getRuudut().get(0), lauta.getRuudut().get(6), "valkea", noppa));
        assertEquals(1, lauta.getRuudut().get(0).getNappulat().size());
        assertEquals(1, lauta.getRuudut().get(6).getNappulat().size());
    }
}
