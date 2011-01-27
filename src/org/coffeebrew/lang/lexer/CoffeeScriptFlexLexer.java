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

}
