package org.coffeebrew.lang.lexer;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

/**
 * Define the CoffeeScript tokens used within the CoffeeScriptLexer
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public interface CoffeeScriptTokenTypes {

  public static final IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;
  public static final IElementType ERROR_ELEMENT = TokenType.ERROR_ELEMENT;

  public static final IElementType WHITE_SPACE = TokenType.WHITE_SPACE;

  public static final IElementType TERMINATOR = new CoffeeScriptElementType("TERMINATOR");

  public static final IElementType DOT = new CoffeeScriptElementType("DOT");
  public static final IElementType COMMA = new CoffeeScriptElementType("COMMA");
  public static final IElementType COLON = new CoffeeScriptElementType("COLON");
  public static final IElementType SEMICOLON = new CoffeeScriptElementType("SEMICOLON");

  public static final IElementType IDENTIFIER = new CoffeeScriptElementType("IDENTIFIER");

  public static final IElementType NUMBER = new CoffeeScriptElementType("NUMBER");
  public static final IElementType BOOL = new CoffeeScriptElementType("BOOL");

  public static final IElementType ESCAPE_SEQUENCE = new CoffeeScriptElementType("ESCAPE_SEQUENCE");

  public static final IElementType STRING_LITERAL = new CoffeeScriptElementType("STRING_LITERAL");
  public static final IElementType STRING = new CoffeeScriptElementType("STRING");

  public static final IElementType HEREDOC_START = new CoffeeScriptElementType("HEREDOC_START");
  public static final IElementType HEREDOC = new CoffeeScriptElementType("HEREDOC");
  public static final IElementType HEREDOC_END = new CoffeeScriptElementType("HEREDOC_END");

  public static final IElementType REGEX_START = new CoffeeScriptElementType("REGEX_START");
  public static final IElementType REGEX = new CoffeeScriptElementType("REGEX");
  public static final IElementType REGEX_BRACKET_START = new CoffeeScriptElementType("REGEX_BRACKET_START");
  public static final IElementType REGEX_BRACKET_END = new CoffeeScriptElementType("REGEX_BRACKET_END");
  public static final IElementType REGEX_PARENTHESIS_START = new CoffeeScriptElementType("REGEX_PARENTHESIS_START");
  public static final IElementType REGEX_PARENTHESIS_END = new CoffeeScriptElementType("REGEX_PARENTHESIS_END");
  public static final IElementType REGEX_BRACE_START = new CoffeeScriptElementType("REGEX_BRACE_START");
  public static final IElementType REGEX_BRACE_END = new CoffeeScriptElementType("REGEX_BRACE_END");
  public static final IElementType REGEX_END = new CoffeeScriptElementType("REGEX_END");
  public static final IElementType REGEX_FLAG = new CoffeeScriptElementType("REGEX_FLAG");

  public static final IElementType HEREGEX_START = new CoffeeScriptElementType("HEREGEX_START");
  public static final IElementType HEREGEX = new CoffeeScriptElementType("HEREGEX");
  public static final IElementType HEREGEX_END = new CoffeeScriptElementType("HEREGEX_END");

  public static final IElementType INTERPOLATION_START = new CoffeeScriptElementType("INTERPOLATION_START");
  public static final IElementType INTERPOLATION_END = new CoffeeScriptElementType("INTERPOLATION_END");

  public static final IElementType JAVASCRIPT_LITERAL = new CoffeeScriptElementType("JAVASCRIPT_LITERAL");
  public static final IElementType JAVASCRIPT = new CoffeeScriptElementType("JAVASCRIPT");

  public static final IElementType LINE_COMMENT = new CoffeeScriptElementType("COMMENT");
  public static final IElementType BLOCK_COMMENT = new CoffeeScriptElementType("BLOCK_COMMENT");

  public static final IElementType PARENTHESIS_START = new CoffeeScriptElementType("PARENTHESIS_START");
  public static final IElementType PARENTHESIS_END = new CoffeeScriptElementType("PARENTHESIS_END");

  public static final IElementType BRACKET_START = new CoffeeScriptElementType("BRACKET_START");
  public static final IElementType BRACKET_END = new CoffeeScriptElementType("BRACKET_END");

  public static final IElementType BRACE_START = new CoffeeScriptElementType("BRACE_START");
  public static final IElementType BRACE_END = new CoffeeScriptElementType("BRACE_END");

  public static final IElementType EQUAL = new CoffeeScriptElementType("EQUAL");
  public static final IElementType COMPOUND_ASSIGN = new CoffeeScriptElementType("COMPOUND_ASSIGN");
  public static final IElementType COMPARE = new CoffeeScriptElementType("COMPARE");
  public static final IElementType LOGIC = new CoffeeScriptElementType("LOGIC");
  public static final IElementType RANGE = new CoffeeScriptElementType("RANGE");
  public static final IElementType SPLAT = new CoffeeScriptElementType("SPLAT");
  public static final IElementType THIS = new CoffeeScriptElementType("THIS");
  public static final IElementType PROTOTYPE = new CoffeeScriptElementType("PROTOTYPE");
  public static final IElementType FUNCTION = new CoffeeScriptElementType("FUNCTION");
  public static final IElementType FUNCTION_BIND = new CoffeeScriptElementType("FUNCTION_BIND");
  public static final IElementType EXIST = new CoffeeScriptElementType("EXIST");
  public static final IElementType PLUS = new CoffeeScriptElementType("PLUS");
  public static final IElementType MINUS = new CoffeeScriptElementType("MINUS");
  public static final IElementType MATH = new CoffeeScriptElementType("MATH");

  public static final IElementType UNARY = new CoffeeScriptElementType("UNARY");
  public static final IElementType CLASS = new CoffeeScriptElementType("CLASS");
  public static final IElementType EXTENDS = new CoffeeScriptElementType("EXTENDS");
  public static final IElementType IF = new CoffeeScriptElementType("IF");
  public static final IElementType ELSE = new CoffeeScriptElementType("ELSE");
  public static final IElementType THEN = new CoffeeScriptElementType("THEN");
  public static final IElementType UNLESS = new CoffeeScriptElementType("UNLESS");
  public static final IElementType FOR = new CoffeeScriptElementType("FOR");
  public static final IElementType IN = new CoffeeScriptElementType("IN");
  public static final IElementType OF = new CoffeeScriptElementType("OF");
  public static final IElementType BY = new CoffeeScriptElementType("BY");
  public static final IElementType WHILE = new CoffeeScriptElementType("WHILE");
  public static final IElementType UNTIL = new CoffeeScriptElementType("UNTIL");
  public static final IElementType SWITCH = new CoffeeScriptElementType("SWITCH");
  public static final IElementType WHEN = new CoffeeScriptElementType("WHEN");
  public static final IElementType TRY = new CoffeeScriptElementType("TRY");
  public static final IElementType CATCH = new CoffeeScriptElementType("CATCH");
  public static final IElementType THROW = new CoffeeScriptElementType("THROW");
  public static final IElementType FINALLY = new CoffeeScriptElementType("FINALLY");
  public static final IElementType BREAK = new CoffeeScriptElementType("BREAK");
  public static final IElementType CONTINUE = new CoffeeScriptElementType("CONTINUE");
  public static final IElementType RETURN = new CoffeeScriptElementType("RETURN");
  public static final IElementType INSTANCE_OF = new CoffeeScriptElementType("INSTANCE_OF");

}
