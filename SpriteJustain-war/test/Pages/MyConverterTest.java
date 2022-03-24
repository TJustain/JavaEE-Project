/*
 *  Justain Tremblay | Martin Weaver
 *  MyconverterTest.java
 *  Purose: The goal of this class is to unit test using JUnit. This automatically runs test isolationg parts of our application in this case we are isolating the converter methods.
 */

package Pages;
import java.awt.Color;
import javax.faces.component.UIColumn;
import javax.faces.context.FacesContextWrapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author tjust
 */

public class MyConverterTest {
    
    public MyConverterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of getAsString method, of class MyConverter.
     */
    @Test
    public void testGetAsString() {
        System.out.println("getAsString");
        Color color = new Color(170, 187, 204);
        MyConverter instance = new MyConverter();
        String expResult = "#aabbcc";
        String result = instance.getAsString(new FacesContextWrapper() {}, new UIColumn(), color);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAsObject method, of class MyConverter.
     */
    @Test
    public void testGetAsObject() {     
        System.out.println("getAsObject");
        String value = "#aabbcc";
        MyConverter instance = new MyConverter();
        Color expResult = new Color(170, 187, 204);
        Color result = (Color) instance.getAsObject(new FacesContextWrapper() {}, new UIColumn(), value);
        assertEquals(expResult, result);
    }
}