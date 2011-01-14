package org.coffeebrew.lang.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.coffeebrew.lang.lexer.CoffeeScriptElementType;
import org.coffeebrew.lang.lexer.CoffeeScriptFlexLexer;
import org.jetbrains.annotations.NotNull;

/**
 * CoffeeScript syntax highlighter
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public class CoffeeScriptSyntaxHighlighter extends SyntaxHighlighterBase {

  @NotNull
  public Lexer getHighlightingLexer() {
    return new CoffeeScriptFlexLexer();
  }

  @NotNull
  public TextAttributesKey[] getTokenHighlights(IElementType element) {
    if (element instanceof CoffeeScriptElementType) {
      return pack(((CoffeeScriptElementType) element).getStyle());

    } else {
      return pack(getDefaultTokenTypeStyle(element));
    }
  }

  /**
   * Returns default style for non CoffeeScript token types
   *
   * @param element
   * @return
   */
  private TextAttributesKey getDefaultTokenTypeStyle(IElementType element) {
    if (element.toString() == "WHITE_SPACE") {
      return HighlighterColors.TEXT;

    } else if (element.toString() == "ERROR_ELEMENT" || element.toString() == "BAD_CHARACTER") {
      return HighlighterColors.BAD_CHARACTER;

    } else {
      throw new UnsupportedOperationException(element.toString());
    }

  }

}
