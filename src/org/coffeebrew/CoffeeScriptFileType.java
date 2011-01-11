package org.coffeebrew;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * CoffeeScript file properties
 *
 * @author Michael kessler
 * @since 0.1.0
 */
public class CoffeeScriptFileType extends LanguageFileType {

  public static final CoffeeScriptFileType COFFEE_SCRIPT_FILE_TYPE = new CoffeeScriptFileType();
  public static final Language COFFEE_SCRIPT_LANGUAGE = COFFEE_SCRIPT_FILE_TYPE.getLanguage();

  @NonNls
  public static final String DEFAULT_EXTENSION = "coffee";

  private CoffeeScriptFileType() {
    super(new CoffeeScriptLanguage());
  }

  @NotNull
  @NonNls
  public String getName() {
    return "CoffeeScript";
  }

  @NonNls
  @NotNull
  public String getDescription() {
    return "CoffeeScript Files";
  }

  @NotNull
  @NonNls
  public String getDefaultExtension() {
    return DEFAULT_EXTENSION;
  }

  public Icon getIcon() {
    return CoffeeScriptIcons.FILE_TYPE;
  }

}
