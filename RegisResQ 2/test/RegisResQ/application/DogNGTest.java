package RegisResQ.application;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import RegisResQ.application.Dog;


/**
 *
 * @author dylanforbord
 */
public class DogNGTest {
    
    public DogNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testValidate() {
        Boolean result;
        Dog d = new Dog();
        
        result = d.validate();
        assertFalse(result);
        
        d.setName("Toto");
        result = d.validate();
        assertFalse(result);
        
        d.setBreed("Cairn Terrier");
        result = d.validate();
        assertFalse(result);
        
        d.setDateArrived("2020-05-32");
        result = d.validate();
        assertFalse(result);
        
        d.setDateArrived("2020-05-31");
        result = d.validate();
        assertTrue(result);
        
    }
    
}
