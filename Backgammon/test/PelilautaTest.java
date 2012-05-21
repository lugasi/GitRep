/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Logic.Nappula;
import Logic.Pelilauta;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 *
 * @author lugasi
 */
public class PelilautaTest {
    
    Pelilauta lauta;
    ArrayList <Nappula> valkeat;
    ArrayList <Nappula> mustat;
    
    public PelilautaTest() {
        lauta = new Pelilauta();
        valkeat = new ArrayList <Nappula>();
        mustat = new ArrayList <Nappula>();
        for (int i = 0; i < 15; i++)    {
            valkeat.add(new Nappula("valkea"));
            mustat.add(new Nappula("musta"));
        }
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
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
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
}
