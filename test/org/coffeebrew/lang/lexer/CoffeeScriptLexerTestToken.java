package org.coffeebrew.lang.lexer;

import com.intellij.psi.tree.IElementType;

/**
 * Internal testing class for token comparison
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
class CoffeeScriptLexerTestToken {

  private String token;

  public CoffeeScriptLexerTestToken(IElementType element, CharSequence content) {
    this.token = "[" + element.toString() + " " + content.toString() + "]";
  }

  public CoffeeScriptLexerTestToken(String token) {
    this.token = token;
  }

  public String getToken() {
    return this.token;
  }

  public boolean equals(Object other) {
    return (other instanceof CoffeeScriptLexerTestToken && token.equals(((CoffeeScriptLexerTestToken) other).getToken()));
  }

  public int hashCode() {
    return this.token.hashCode();
  }

  public String toString() {
    return this.token;
  }

}
