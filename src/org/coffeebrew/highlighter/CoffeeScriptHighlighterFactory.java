package org.coffeebrew.highlighter;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import org.jetbrains.annotations.NotNull;

/**
 * CoffeeScript Syntax highlighter factory
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public class CoffeeScriptHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {

  @NotNull
  protected CoffeeScriptSyntaxHighlighter createHighlighter() {
    return new CoffeeScriptSyntaxHighlighter();
  }

}
