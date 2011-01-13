package org.coffeebrew.lang.lexer;

import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.tree.IElementType;
import org.coffeebrew.CoffeeScriptFileType;

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

  public TextAttributesKey getStyle() {
    return TextAttributesKey.createTextAttributesKey(
            "COFFEESCRIPT." + name.toUpperCase(),
            SyntaxHighlighterColors.NUMBER.getDefaultAttributes()
    );
  }

  public String toString() {
    return name;
  }

}
