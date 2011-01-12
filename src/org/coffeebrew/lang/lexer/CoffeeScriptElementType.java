package org.coffeebrew.lang.lexer;

import com.intellij.psi.tree.IElementType;
import org.coffeebrew.CoffeeScriptFileType;

/**
 * Custom CoffeeScript element types.
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
class CoffeeScriptElementType extends IElementType {

  private String debugName = null;

  public CoffeeScriptElementType(String debugName) {
    super(debugName, CoffeeScriptFileType.COFFEE_SCRIPT_FILE_TYPE.getLanguage());
    this.debugName = debugName;
  }


  public String toString() {
    return debugName;
  }

}
