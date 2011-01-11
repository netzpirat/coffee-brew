package org.coffeebrew;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.fileTypes.FileTypeManager;
import org.jetbrains.annotations.NotNull;

/**
 * Main application component that laods the CoffeeScript language support
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public class CoffeeScriptLoader implements ApplicationComponent {

  public void initComponent() {
    ApplicationManager.getApplication().runWriteAction(
            new Runnable() {
              public void run() {
                FileTypeManager.getInstance().registerFileType(CoffeeScriptFileType.COFFEE_SCRIPT_FILE_TYPE, new String[]{CoffeeScriptFileType.DEFAULT_EXTENSION});
              }
            }
    );
  }

  public void disposeComponent() {
  }

  @NotNull
  public String getComponentName() {
    return "coffeescript.support.loader";
  }

}
