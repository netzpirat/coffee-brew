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

  public static final IElementType WRONG_TOKEN = TokenType.BAD_CHARACTER;

  /* **************************************************************************************************
 *  Whitespaces & NewLines
 * ****************************************************************************************************/

  public static final IElementType WHITESPACE = new CoffeeScriptElementType("WHITESPACE", true);
  public static final IElementType TERMINATOR = new CoffeeScriptElementType("TERMINATOR");

  /* **************************************************************************************************
 *  Comments
 * ****************************************************************************************************/

  public static final IElementType COMMENT = new CoffeeScriptElementType("COMMENT", true);
  public static final IElementType HERECOMMENT = new CoffeeScriptElementType("HERECOMMENT");

  /* **************************************************************************************************
 *  Identifiers
 * ****************************************************************************************************/

  public static final IElementType IDENTIFIER = new CoffeeScriptElementType("IDENTIFIER");


  /* **************************************************************************************************
 *  Strings & regular expressions
 * ****************************************************************************************************/

  public static final IElementType STRING = new CoffeeScriptElementType("STRING");

}
