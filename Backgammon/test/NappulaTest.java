/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Logic.Nappula;
import Logic.Ruutu;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author lugasi
 */
public class NappulaTest {
    
    Nappula n;
    Ruutu r1;
    Ruutu r2;
    
    public NappulaTest() {
        n = new Nappula("");
        r1 = new Ruutu();
        r2 = new Ruutu();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void nappulaAsetetaanOikeaanRuutuun()    {
        n.asetaRuutuun(r1);
        
        assertEquals(r1, n.getRuutu());
        
        n.asetaRuutuun(r2);
        
        assertEquals(r2, n.getRuutu());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
