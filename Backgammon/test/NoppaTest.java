/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Logic.Noppa;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author lugasi
 */
public class NoppaTest {
    
    Noppa n;
    
    public NoppaTest() {
        n = new Noppa();
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
    public void nopanSilmalukuOikeallaValilla() {
        for (int i = 0; i < 500; i++)   {
            n.heita();
            assertTrue(n.getSilmaluku() >= 1 && n.getSilmaluku() <= 6);
        }
    }
    
    @Test
    public void kaikkiaSilmalukujaAinakinYksi() {
        boolean[] silmaluvut = new boolean[6]; 
        
        for (int i = 0; i < 500; i++)   {
            silmaluvut[n.heita() - 1] = true;            
        }
        
        for (int i = 0; i < 6; i++) {
            assertTrue(silmaluvut[i]);
        }
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
