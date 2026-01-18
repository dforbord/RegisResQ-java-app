/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package RegisResQ.application;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import RegisResQ.application.Cat;



/**
 *
 * @author dylanforbord
 */

public class CatNGTest {
    
    public CatNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testValidate() {
        Cat c = new Cat();

        // Initially invalid - nothing set
        assertFalse(c.validate());

        // Only breed set
        c.setBreed("Persian");
        assertFalse(c.validate());

        // Add name
        c.setName("Whiskers");
        assertFalse(c.validate());

        // Add sterilized
        c.setSterilized(true);
        assertFalse(c.validate());

        // Set bad date (wrong format)
        c.setDateArrived("17-05-2022");
        assertFalse(c.validate());

        // Set bad date (invalid day)
        c.setDateArrived("2022-02-30");
        assertFalse(c.validate());

        // Set good date
        c.setDateArrived("2022-05-17");
        assertTrue(c.validate());
    }
    }
    

