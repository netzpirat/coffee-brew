package org.coffeebrew.lang.lexer;

import com.intellij.psi.tree.TokenSet;

/**
 * Group the lexer lexer
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public abstract class CoffeeScriptTokenSets implements CoffeeScriptTokenTypes {

  public static TokenSet SYNTAX_HIGHLIGHTER_TOKEN_SET = TokenSet.create(
          TERMINATOR,

          DOT,
          COMMA,

          IDENTIFIER,

          STRING_LITERAL,
          STRING,
          REGEX,

          NUMBER,
          BOOL,

          LINE_COMMENT,
          BLOCK_COMMENT,


          PARENTHESIS_START,
          PARENTHESIS_END,

          BRACKET_START,
          BRACKET_END,

          EQUAL,
          COMPOUND_ASSIGN,
          COMPARE,
          LOGIC,
          RANGE,
          THIS,
          COLON,
          PROTOTYPE,
          FUNCTION,
          FUNCTION_BIND,
          PLUS,

          UNARY,
          CLASS,
          EXTENDS,
          IF,
          ELSE,
          THEN,
          UNLESS,
          FOR,
          IN,
          OF,
          WHILE,
          UNTIL,
          SWITCH,
          WHEN,
          TRY,
          CATCH,
          FINALLY

  );

  public static TokenSet WHITESPACE_TOKEN_SET = TokenSet.create(
          WHITE_SPACE
  );

  public static TokenSet COMMENTS_TOKEN_SET = TokenSet.create(
          LINE_COMMENT,
          BLOCK_COMMENT
  );

  public static TokenSet STRING_TOKEN_SET = TokenSet.create(
          STRING,
          STRING_LITERAL
  );

}
