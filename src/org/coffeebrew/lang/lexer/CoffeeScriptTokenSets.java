package org.coffeebrew.lang.lexer;

import com.intellij.psi.tree.TokenSet;

/**
 * Group the lexer lexer
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public abstract class CoffeeScriptTokenSets implements CoffeeScriptTokenTypes {

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

  public static TokenSet PARENTHESIS_TOKEN_SET = TokenSet.create(
          CALL_START,
          CALL_END,
          PARAM_START,
          PARAM_END,
          PARENTHESIS_START,
          PARENTHESIS_END
  );

  public static TokenSet BRACKET_TOKEN_SET = TokenSet.create(
          BRACKET_START,
          BRACKET_END,
          INDEX_START,
          INDEX_END
  );

}
