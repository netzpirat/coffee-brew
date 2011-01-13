package org.coffeebrew.lang.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.coffeebrew.lang.lexer.CoffeeScriptElementType;
import org.coffeebrew.lang.lexer.CoffeeScriptFlexLexer;
import org.coffeebrew.lang.lexer.CoffeeScriptLexer;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;
import java.util.HashMap;

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
    if (element instanceof CoffeeScriptElementType){
      return pack(((CoffeeScriptElementType) element).getStyle());
    }

    throw new UnsupportedOperationException(element.toString());
  }

}
