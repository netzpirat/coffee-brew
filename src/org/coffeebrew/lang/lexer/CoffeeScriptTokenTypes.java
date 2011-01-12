package org.coffeebrew.lang.lexer;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.coffeebrew.lang.lexer.CoffeeScriptElementType;

/**
 * Define the CoffeeScript tokens used within the CoffeeScriptLexer
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public interface CoffeeScriptTokenTypes {

  public static final IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;
  public static final IElementType RESERVED = new CoffeeScriptElementType("RESERVED");

  public static final IElementType WHITESPACE = new CoffeeScriptElementType("WHITESPACE");
  public static final IElementType TERMINATOR = new CoffeeScriptElementType("TERMINATOR");

  public static final IElementType STRING_LITERAL = new CoffeeScriptElementType("STRING_LITERAL");

  public static final IElementType STRING = new CoffeeScriptElementType("STRING");
  public static final IElementType NUMBER = new CoffeeScriptElementType("NUMBER");

  public static final IElementType COMMENT = new CoffeeScriptElementType("COMMENT");
  public static final IElementType HERECOMMENT = new CoffeeScriptElementType("HERECOMMENT");

  public static final IElementType IDENTIFIER = new CoffeeScriptElementType("IDENTIFIER");
  public static final IElementType BOOL = new CoffeeScriptElementType("BOOL");

  public static final IElementType EQUALS = new CoffeeScriptElementType("EQUALS");
  public static final IElementType COMPARE = new CoffeeScriptElementType("COMPARE");
  public static final IElementType RELATION = new CoffeeScriptElementType("RELATION");

  public static final IElementType CALL_START = new CoffeeScriptElementType("CALL_START");
  public static final IElementType CALL_END = new CoffeeScriptElementType("CALL_END");

  public static final IElementType IF = new CoffeeScriptElementType("IF");
  public static final IElementType POST_IF = new CoffeeScriptElementType("POST_IF");

  public static final IElementType DOT = new CoffeeScriptElementType(".");
  public static final IElementType COMMA = new CoffeeScriptElementType(",");

  public static final IElementType BRACKET_START = new CoffeeScriptElementType("[");
}
