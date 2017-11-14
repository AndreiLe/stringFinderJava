
package stringFinder;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringFinderStringIT {
  
  public StringFinderStringIT() {
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
   * Test of addMainString method, of class StringFinderString.
   */
  @Test
  public void testAddMainString() {
    System.out.println("addMainString");
    CharSequence mainString = null;
    StringFinderString instance = new StringFinderString();
    ArrayList<CharSequence> expResult = null;
    ArrayList<CharSequence> result = null;
    
    mainString = "A";
    expResult = new ArrayList<CharSequence>();
    expResult.add("A");
    result = instance.addMainString(mainString).getWordList();
    assertEquals(expResult, result);
    
    mainString = "a";
    expResult = new ArrayList<CharSequence>();
    expResult.add("a");
    result = instance.addMainString(mainString).getWordList();
    assertEquals(expResult, result);
    
    mainString = "ABC";
    expResult = new ArrayList<CharSequence>();
    expResult.add("A");
    expResult.add("B");
    expResult.add("C");
    result = instance.addMainString(mainString).getWordList();
    assertEquals(expResult, result);
    
    mainString = "AaBbcC";
    expResult = new ArrayList<CharSequence>();
    expResult.add("Aa");
    expResult.add("Bbc");
    expResult.add("C");
    result = instance.addMainString(mainString).getWordList();
    assertEquals(expResult, result);

  }
  
  @Test(expected = NullPointerException.class) 
  public void testAddMainStringExseption() {
    System.out.println("testAddMainStringExseption");

    assertEquals(null, new StringFinderString().addMainString(null));
  }
  @Test
  public void testAddMainStringExseption2() {
    System.out.println("testAddMainStringExseption2");

    try {
        new StringFinderString().addMainString(null);
        fail("Expected an NullPointerException to be thrown");
    } catch (NullPointerException anNullPointerException) {
        assertEquals(anNullPointerException.getMessage(), null);
    }
  }
  

  /**
   * Test of compareLastWords method, of class StringFinderString.
   */
  @Test
  public void testCompareLastWords() {
    System.out.println("compareLastWords");
    CharSequence patternString = null;
    CharSequence mainString = null;
    StringFinderString instance = null;
    boolean expResult = false;
    boolean result = false;
    
    patternString = "a";
    mainString = "a";
    instance = new StringFinderString().addMainString(mainString);
    expResult = true;
    result = instance.compareLastWords(patternString);
    assertEquals(expResult, result);
    
    patternString = "a";
    mainString = "A";
    instance = new StringFinderString().addMainString(mainString);
    expResult = false;
    result = instance.compareLastWords(patternString);
    assertEquals(expResult, result);
    
    patternString = "Aa";
    mainString = "Aa";
    instance = new StringFinderString().addMainString(mainString);
    expResult = true;
    result = instance.compareLastWords(patternString);
    assertEquals(expResult, result);
    
    patternString = "Aa";
    mainString = "BbAa";
    instance = new StringFinderString().addMainString(mainString);
    expResult = true;
    result = instance.compareLastWords(patternString);
    assertEquals(expResult, result);
  }
  

  /**
   * Test of getWordsListSize method, of class StringFinderString.
   */
  @Test
  public void testGetWordsListSize() {
    System.out.println("getWordsListSize");
    
    assertEquals(0, new StringFinderString().addMainString("").getWordsListSize());
    
    assertEquals(1, new StringFinderString().addMainString("B").getWordsListSize());
  }
  

 }
