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

  public static final IElementType BAD_CHARACTER     = TokenType.BAD_CHARACTER;
  public static final IElementType RESERVED          = new CoffeeScriptElementType("RESERVED");

  public static final IElementType WHITESPACE        = new CoffeeScriptElementType("WHITESPACE");
  public static final IElementType TERMINATOR        = new CoffeeScriptElementType("TERMINATOR");

  public static final IElementType IDENTIFIER        = new CoffeeScriptElementType("IDENTIFIER");

  public static final IElementType STRING_LITERAL    = new CoffeeScriptElementType("STRING_LITERAL");
  public static final IElementType STRING            = new CoffeeScriptElementType("STRING");
  public static final IElementType NUMBER            = new CoffeeScriptElementType("NUMBER");
  public static final IElementType BOOL              = new CoffeeScriptElementType("BOOL");

  public static final IElementType CLASS             = new CoffeeScriptElementType("CLASS");
  public static final IElementType EXTENDS           = new CoffeeScriptElementType("EXTENDS");

  public static final IElementType LINE_COMMENT      = new CoffeeScriptElementType("COMMENT");
  public static final IElementType BLOCK_COMMENT     = new CoffeeScriptElementType("BLOCK_COMMENT");

  public static final IElementType EQUAL             = new CoffeeScriptElementType("EQUAL");
  public static final IElementType COMPOUND_ASSIGN   = new CoffeeScriptElementType("COMPOUND_ASSIGN");
  public static final IElementType COMPARE           = new CoffeeScriptElementType("COMPARE");
  public static final IElementType LOGIC             = new CoffeeScriptElementType("LOGIC");
  public static final IElementType RELATION          = new CoffeeScriptElementType("RELATION");

  public static final IElementType RANGE             = new CoffeeScriptElementType("RANGE");

  public static final IElementType CALL_START        = new CoffeeScriptElementType("CALL_START");
  public static final IElementType CALL_END          = new CoffeeScriptElementType("CALL_END");
  public static final IElementType PARAM_START       = new CoffeeScriptElementType("PARAM_START");
  public static final IElementType PARAM_END         = new CoffeeScriptElementType("PARAM_END");
  public static final IElementType PARENTHESIS_START = new CoffeeScriptElementType("PARENTHESIS_START");
  public static final IElementType PARENTHESIS_END   = new CoffeeScriptElementType("PARENTHESIS_END");

  public static final IElementType BRACKET_START     = new CoffeeScriptElementType("BRACKET_START");
  public static final IElementType BRACKET_END       = new CoffeeScriptElementType("BRACKET_END");
  public static final IElementType INDEX_START       = new CoffeeScriptElementType("INDEX_START");
  public static final IElementType INDEX_END         = new CoffeeScriptElementType("INDEX_END");

  public static final IElementType IF                = new CoffeeScriptElementType("IF");
  public static final IElementType ELSE              = new CoffeeScriptElementType("ELSE");
  public static final IElementType THEN              = new CoffeeScriptElementType("THEN");
  public static final IElementType UNLESS            = new CoffeeScriptElementType("UNLESS");

  public static final IElementType FOR               = new CoffeeScriptElementType("FOR");
  public static final IElementType FORIN             = new CoffeeScriptElementType("FORIN");
  public static final IElementType FOROF             = new CoffeeScriptElementType("FOROF");

  public static final IElementType WHILE             = new CoffeeScriptElementType("WHILE");
  public static final IElementType UNTIL             = new CoffeeScriptElementType("UNTIL");

  public static final IElementType DOT               = new CoffeeScriptElementType("DOT");
  public static final IElementType COMMA             = new CoffeeScriptElementType("COMMA");
  public static final IElementType COLON             = new CoffeeScriptElementType("COLON");
  public static final IElementType THIS              = new CoffeeScriptElementType("THIS");
  public static final IElementType FUNCTION          = new CoffeeScriptElementType("FUNCTION");

  public static final IElementType PLUS              = new CoffeeScriptElementType("PLUS");

  public static final IElementType TRY               = new CoffeeScriptElementType("TRY");
  public static final IElementType CATCH             = new CoffeeScriptElementType("CATCH");
  public static final IElementType FINALLY           = new CoffeeScriptElementType("FINALLY");
}
