package org.coffeebrew.lang.lexer;

import com.intellij.psi.tree.IElementType;
import org.coffeebrew.file.CoffeeScriptFileType;

/**
 * Custom CoffeeScript element types.
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public class CoffeeScriptElementType extends IElementType {

  private String name = null;

  public CoffeeScriptElementType(String name) {
    super(name, CoffeeScriptFileType.COFFEE_SCRIPT_FILE_TYPE.getLanguage());

    this.name = name;
  }

  public String toString() {
    return name;
  }

}
