package org.coffeebrew;

import com.intellij.lang.Language;

/**
 * All main properties for the CoffeeScript language
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public class CoffeeScriptLanguage extends Language {

  public CoffeeScriptLanguage() {
    super("CoffeeScript", "text/coffeescript");
  }

  @Override
  public boolean isCaseSensitive() {
    return true;
  }

}
