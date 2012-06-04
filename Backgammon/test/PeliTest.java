/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Logic.Peli;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author lugasi
 */
public class PeliTest {
    
    Peli p;
    
    public PeliTest() {
        p = new Peli();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        p.asetaAlkutilanne();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void pelinAlkuArvotOikein()  {
        assertTrue(p.isEkaKierros());
        assertFalse(p.isTuplat());
        if (p.getNoppa1().getSilmaluku() > p.getNoppa2().getSilmaluku())    {
            assertEquals("valkea", p.getVuoro());
        }
        else    {
            assertEquals("musta", p.getVuoro());
        }
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
