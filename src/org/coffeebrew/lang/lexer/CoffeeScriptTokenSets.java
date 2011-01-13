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
          BAD_CHARACTER,
          RESERVED,
          IDENTIFIER,
          STRING_LITERAL,
          STRING,
          NUMBER,
          BOOL,

          CLASS,
          EXTENDS,

          LINE_COMMENT,
          BLOCK_COMMENT,

          EQUAL,
          COMPOUND_ASSIGN,
          COMPARE,
          LOGIC,
          RELATION,
          UNARY,

          RANGE,

          PARENTHESIS_START,
          PARENTHESIS_END,

          BRACKET_START,
          BRACKET_END,
          IF,
          ELSE,
          THEN,
          UNLESS,

          FOR,
          FORIN,
          FOROF,

          WHILE,
          UNTIL,

          SWITCH,
          WHEN,

          DOT,
          COMMA,

          THIS,

          COLON,
          PROTOTYPE,

          FUNCTION,
          FUNCTION_BIND,

          PLUS,

          TRY,
          CATCH,
          FINALLY,

          REGEX
  );

  public static TokenSet WHITESPACE_TOKEN_SET = TokenSet.create(
          WHITESPACE
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
