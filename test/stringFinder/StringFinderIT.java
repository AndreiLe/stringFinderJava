package stringFinder;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringFinderIT {

  @Test
  public void testContainsHomeworkRulesSimplePattern() {
    assertTrue(new StringFinder("a.b.FooBarBaz").contains("FB"));
    assertTrue(new StringFinder("a.b.FooBarBaz").contains("FoBa"));
    assertTrue(new StringFinder("a.b.FooBarBaz").contains("FBar"));
    
    assertTrue(new StringFinder("c.d.FooBar").contains("FB"));
    assertTrue(new StringFinder("c.d.FooBar").contains("FoBa"));
    assertTrue(new StringFinder("c.d.FooBar").contains("FBar"));
    
    assertTrue(new StringFinder("BarBaz").contains("Bar"));
    
    assertFalse(new StringFinder("c.d.FooBar").contains("BF"));
  }
  
  @Test
  public void testContainsHomeworkRulesLowerCasePattern() {
    assertTrue(new StringFinder("FooBarBaz").contains("fbb"));
    assertFalse(new StringFinder("FooBarBaz").contains("fBb"));
  }
    
  @Test
  public void testContainsHomeworkRulesPatternWithWhitespace() {
    assertTrue(new StringFinder("FooBar").contains("FBar "));
    assertFalse(new StringFinder("FooBarBaz").contains("FBar "));
    assertFalse(new StringFinder("a.b.FooBarBaz").contains("Bar "));
  }
  
  @Test
  public void testContainsHomeworkRulesPatternWithAsterisk() {
    assertTrue(new StringFinder("FooBarBaz").contains("B*rBaz"));
    assertFalse(new StringFinder("BrBaz").contains("B*rBaz"));
  }
}
