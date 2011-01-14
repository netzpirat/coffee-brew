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
  public void multipleLines() {
    assertLexerExample("multiple_lines");
  }

  @Test
  public void aliases() {
    assertLexerExample("aliases");
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
  public void objects() {
    assertLexerExample("objects");
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

  @Test
  public void exceptions() {
    assertLexerExample("exceptions");
  }

  @Test
  public void functions() {
    assertLexerExample("functions");
  }

  @Test
  public void compoundAssigns() {
    assertLexerExample("compound_assigns");
  }

  @Test
  public void unaries() {
    assertLexerExample("unaries");
  }

  @Test
  public void prototypes() {
    assertLexerExample("prototypes");
  }

  @Test
  public void switches() {
    assertLexerExample("switches");
  }

  @Test
  public void javascript() {
    assertLexerExample("javascript");
  }

  @Test
  public void comparisons() {
    assertLexerExample("comparisons");
  }

  @Test
  public void existentials() {
    assertLexerExample("existentials");
  }

  @Test
  public void splats() {
    assertLexerExample("splats");
  }

  @Test
  public void bools() {
    assertLexerExample("bools");
  }

  @Test
  public void maths() {
    assertLexerExample("maths");
  }

  @Test
  public void heredocs() {
    assertLexerExample("heredocs");
  }

  @Test
  public void interpolations() {
    assertLexerExample("interpolations");
  }

  @Test
  public void regularExpressions() {
    assertLexerExample("regular_expressions");
  }

  @Test
  public void heregex() {
    assertLexerExample("heregex");
  }

  @Test
  public void quoteReservedKeywords() {
    assertLexerExample("quote_reserved_words");
  }

}
