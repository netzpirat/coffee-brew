package org.coffeebrew.lang.lexer;

import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
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
  public static final IElementType ERROR_ELEMENT = TokenType.ERROR_ELEMENT;
  public static final IElementType WHITE_SPACE = TokenType.WHITE_SPACE;

  public static final IElementType TERMINATOR = new CoffeeScriptElementType("TERMINATOR", SyntaxHighlighterColors.JAVA_SEMICOLON);

  public static final IElementType DOT = new CoffeeScriptElementType("DOT", SyntaxHighlighterColors.DOT);
  public static final IElementType COMMA = new CoffeeScriptElementType("COMMA", SyntaxHighlighterColors.COMMA);

  public static final IElementType IDENTIFIER = new CoffeeScriptElementType("IDENTIFIER", HighlighterColors.TEXT);

  public static final IElementType NUMBER = new CoffeeScriptElementType("NUMBER", SyntaxHighlighterColors.NUMBER);
  public static final IElementType BOOL = new CoffeeScriptElementType("BOOL", SyntaxHighlighterColors.NUMBER);

  public static final IElementType STRING_LITERAL = new CoffeeScriptElementType("STRING_LITERAL", SyntaxHighlighterColors.STRING);
  public static final IElementType STRING = new CoffeeScriptElementType("STRING", SyntaxHighlighterColors.STRING);

  public static final IElementType HEREDOC_START = new CoffeeScriptElementType("HEREDOC_START", SyntaxHighlighterColors.STRING);
  public static final IElementType HEREDOC = new CoffeeScriptElementType("HEREDOC", SyntaxHighlighterColors.STRING);
  public static final IElementType HEREDOC_END = new CoffeeScriptElementType("HEREDOC_END", SyntaxHighlighterColors.STRING);

  public static final IElementType REGEX_START = new CoffeeScriptElementType("REGEX_START", SyntaxHighlighterColors.STRING);
  public static final IElementType REGEX = new CoffeeScriptElementType("REGEX", SyntaxHighlighterColors.STRING);
  public static final IElementType REGEX_ESCAPE = new CoffeeScriptElementType("REGEX_ESCAPE", SyntaxHighlighterColors.STRING);
  public static final IElementType REGEX_BRACKET_START = new CoffeeScriptElementType("REGEX_BRACKET_START", SyntaxHighlighterColors.STRING);
  public static final IElementType REGEX_BRACKET_END = new CoffeeScriptElementType("REGEX_BRACKET_END", SyntaxHighlighterColors.STRING);
  public static final IElementType REGEX_END = new CoffeeScriptElementType("REGEX_END", SyntaxHighlighterColors.STRING);
  public static final IElementType REGEX_FLAG = new CoffeeScriptElementType("REGEX_FLAG", SyntaxHighlighterColors.STRING);

  public static final IElementType HEREGEX_START = new CoffeeScriptElementType("HEREGEX_START", SyntaxHighlighterColors.STRING);
  public static final IElementType HEREGEX = new CoffeeScriptElementType("HEREGEX", SyntaxHighlighterColors.STRING);
  public static final IElementType HEREGEX_END = new CoffeeScriptElementType("HEREGEX_END", SyntaxHighlighterColors.STRING);

  public static final IElementType INTERPOLATION_START = new CoffeeScriptElementType("INTERPOLATION_START", SyntaxHighlighterColors.STRING);
  public static final IElementType INTERPOLATION_END = new CoffeeScriptElementType("INTERPOLATION_END", SyntaxHighlighterColors.STRING);

  public static final IElementType JAVASCRIPT_LITERAL = new CoffeeScriptElementType("JAVASCRIPT_LITERAL", SyntaxHighlighterColors.STRING);
  public static final IElementType JAVASCRIPT = new CoffeeScriptElementType("JAVASCRIPT", SyntaxHighlighterColors.STRING);

  public static final IElementType LINE_COMMENT = new CoffeeScriptElementType("COMMENT", SyntaxHighlighterColors.LINE_COMMENT);
  public static final IElementType BLOCK_COMMENT = new CoffeeScriptElementType("BLOCK_COMMENT", SyntaxHighlighterColors.JAVA_BLOCK_COMMENT);

  public static final IElementType PARENTHESIS_START = new CoffeeScriptElementType("PARENTHESIS_START", SyntaxHighlighterColors.PARENTHS);
  public static final IElementType PARENTHESIS_END = new CoffeeScriptElementType("PARENTHESIS_END", SyntaxHighlighterColors.PARENTHS);

  public static final IElementType BRACKET_START = new CoffeeScriptElementType("BRACKET_START", SyntaxHighlighterColors.BRACKETS);
  public static final IElementType BRACKET_END = new CoffeeScriptElementType("BRACKET_END", SyntaxHighlighterColors.BRACKETS);

  public static final IElementType BRACE_START = new CoffeeScriptElementType("BRACE_START", SyntaxHighlighterColors.BRACES);
  public static final IElementType BRACE_END = new CoffeeScriptElementType("BRACE_END", SyntaxHighlighterColors.BRACES);

  public static final IElementType EQUAL = new CoffeeScriptElementType("EQUAL", SyntaxHighlighterColors.OPERATION_SIGN);
  public static final IElementType COMPOUND_ASSIGN = new CoffeeScriptElementType("COMPOUND_ASSIGN", SyntaxHighlighterColors.OPERATION_SIGN);
  public static final IElementType COMPARE = new CoffeeScriptElementType("COMPARE", SyntaxHighlighterColors.OPERATION_SIGN);
  public static final IElementType LOGIC = new CoffeeScriptElementType("LOGIC", SyntaxHighlighterColors.OPERATION_SIGN);
  public static final IElementType RANGE = new CoffeeScriptElementType("RANGE", SyntaxHighlighterColors.OPERATION_SIGN);
  public static final IElementType SPLAT = new CoffeeScriptElementType("SPLAT", SyntaxHighlighterColors.OPERATION_SIGN);
  public static final IElementType THIS = new CoffeeScriptElementType("THIS", SyntaxHighlighterColors.OPERATION_SIGN);
  public static final IElementType COLON = new CoffeeScriptElementType("COLON", SyntaxHighlighterColors.OPERATION_SIGN);
  public static final IElementType PROTOTYPE = new CoffeeScriptElementType("PROTOTYPE", SyntaxHighlighterColors.OPERATION_SIGN);
  public static final IElementType FUNCTION = new CoffeeScriptElementType("FUNCTION", SyntaxHighlighterColors.OPERATION_SIGN);
  public static final IElementType FUNCTION_BIND = new CoffeeScriptElementType("FUNCTION_BIND", SyntaxHighlighterColors.OPERATION_SIGN);
  public static final IElementType EXIST = new CoffeeScriptElementType("EXIST", SyntaxHighlighterColors.OPERATION_SIGN);
  public static final IElementType PLUS = new CoffeeScriptElementType("PLUS", SyntaxHighlighterColors.OPERATION_SIGN);
  public static final IElementType MINUS = new CoffeeScriptElementType("MINUS", SyntaxHighlighterColors.OPERATION_SIGN);
  public static final IElementType MATH = new CoffeeScriptElementType("MATH", SyntaxHighlighterColors.OPERATION_SIGN);

  public static final IElementType UNARY = new CoffeeScriptElementType("UNARY", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType CLASS = new CoffeeScriptElementType("CLASS", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType EXTENDS = new CoffeeScriptElementType("EXTENDS", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType IF = new CoffeeScriptElementType("IF", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType ELSE = new CoffeeScriptElementType("ELSE", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType THEN = new CoffeeScriptElementType("THEN", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType UNLESS = new CoffeeScriptElementType("UNLESS", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType FOR = new CoffeeScriptElementType("FOR", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType IN = new CoffeeScriptElementType("IN", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType OF = new CoffeeScriptElementType("OF", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType BY = new CoffeeScriptElementType("BY", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType WHILE = new CoffeeScriptElementType("WHILE", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType UNTIL = new CoffeeScriptElementType("UNTIL", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType SWITCH = new CoffeeScriptElementType("SWITCH", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType WHEN = new CoffeeScriptElementType("WHEN", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType TRY = new CoffeeScriptElementType("TRY", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType CATCH = new CoffeeScriptElementType("CATCH", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType THROW = new CoffeeScriptElementType("THROW", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType FINALLY = new CoffeeScriptElementType("FINALLY", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType BREAK = new CoffeeScriptElementType("BREAK", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType CONTINUE = new CoffeeScriptElementType("CONTINUE", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType RETURN = new CoffeeScriptElementType("RETURN", SyntaxHighlighterColors.KEYWORD);
  public static final IElementType INSTANCE_OF = new CoffeeScriptElementType("INSTANCE_OF", SyntaxHighlighterColors.KEYWORD);

}
