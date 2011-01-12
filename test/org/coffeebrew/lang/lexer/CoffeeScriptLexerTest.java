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
  public void lineTerminator() {
    assertLexerExample("line_terminator");
  }

  @Test
  public void whiteSpace() {
    assertLexerExample("white_space");
  }

  @Test
  public void identifier() {
    assertLexerExample("identifier_equals");
  }

}
