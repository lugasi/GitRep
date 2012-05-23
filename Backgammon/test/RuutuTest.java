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
public class RuutuTest {
    
    Ruutu r;
    
    public RuutuTest() {
        r = new Ruutu();
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
    public void nappulanLisaysToimii()  {
        r.asetaNappula(new Nappula(""));
        
        assertEquals(1, r.getNappulat().size());
        
        r.asetaNappula(new Nappula(""));
        
        assertEquals(2, r.getNappulat().size());
    }
    
    @Test
    public void nappulanPoistoToimii()  {
        r.asetaNappula(new Nappula(""));
        r.asetaNappula(new Nappula(""));
        
        r.poistaNappula(r.getNappulat().get(0));
        
        assertEquals(1, r.getNappulat().size());
        
        r.poistaNappula(r.getNappulat().get(0));
        
        assertEquals(0, r.getNappulat().size());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
