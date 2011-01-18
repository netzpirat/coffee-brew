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
  private boolean hidden = false;

  /**
   * Construct a test lexer token form the plugin lexer token data
   *
   * @param element
   * @param content
   */
  public CoffeeScriptLexerTestToken(IElementType element, CharSequence content) {
    this.token = "[" + element.toString() + " " + content.toString().replace("\n", "\\n").replace("\t", "\\t") + "]";
  }

  /**
   * Construct a test lexer token from the CoffeeScript lexer token
   *
   * @param token
   */
  public CoffeeScriptLexerTestToken(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public boolean equals(Object other) {
    return (other instanceof CoffeeScriptLexerTestToken &&
            token.equals(((CoffeeScriptLexerTestToken) other).getToken()));
  }

  public int hashCode() {
    return token.hashCode();
  }

  public String toString() {
    return token;
  }

  public boolean isHidden() {
    return hidden;
  }

}
