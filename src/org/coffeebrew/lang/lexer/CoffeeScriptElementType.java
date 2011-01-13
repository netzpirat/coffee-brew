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
  private TextAttributesKey defaultAttributes;

  public CoffeeScriptElementType(String name, TextAttributesKey defaultAttributes) {
    super(name, CoffeeScriptFileType.COFFEE_SCRIPT_FILE_TYPE.getLanguage());

    this.name = name;
    this.defaultAttributes = defaultAttributes;
  }

  /**
   * Returns the style of the CoffeeScript element
   *
   * @return
   */
  public TextAttributesKey getStyle() {
    return TextAttributesKey.createTextAttributesKey(
            "COFFEESCRIPT." + name.toUpperCase(),
            defaultAttributes.getDefaultAttributes()
    );
  }

  public String toString() {
    return name;
  }

}
