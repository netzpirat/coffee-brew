package org.coffeebrew.lang.lexer;

import org.junit.Test;

/**
 * Tests the lexer with real CoffeeScript example files
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public class CoffeeScriptLexerTest extends CoffeeScriptLexerExampleTestCase {

  @Test
  public void terminators() {
    assertLexerExample("terminators");
  }

  @Test
  public void whitespaces() {
    assertLexerExample("whitespaces");
  }

  @Test
  public void numbers() {
    assertLexerExample("numbers");
  }

  @Test
  public void strings() {
    assertLexerExample("strings");
  }

  @Test
  public void aliases() {
    //assertLexerExample("aliases");
  }

  @Test
  public void reserved() {
    assertLexerExample("reserved");
  }

  @Test
  public void comments() {
    assertLexerExample("comments");
  }

  @Test
  public void arrays() {
    assertLexerExample("arrays");
  }

  @Test
  public void classes() {
    assertLexerExample("classes");
  }

  @Test
  public void ifs() {
    assertLexerExample("ifs");
  }

  @Test
  public void fors() {
    assertLexerExample("fors");
  }

  @Test
  public void whiles() {
    assertLexerExample("whiles");
  }

  @Test
  public void ranges() {
    assertLexerExample("ranges");
  }

}
