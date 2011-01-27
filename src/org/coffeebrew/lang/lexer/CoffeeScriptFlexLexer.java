package org.coffeebrew.lang.lexer;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

/**
 * Adapter for the CoffeeScript flex lexer
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public class CoffeeScriptFlexLexer extends FlexAdapter {

  public CoffeeScriptFlexLexer() {
    super(new CoffeeScriptLexer((Reader) null));
  }

  public void start(final CharSequence buffer, int startOffset, int endOffset, final int initialState) {
    super.start(buffer, 0, endOffset, initialState);
  }

}
