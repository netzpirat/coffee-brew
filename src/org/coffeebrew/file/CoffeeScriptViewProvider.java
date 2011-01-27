package org.coffeebrew.file;

import com.intellij.lang.Language;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.SingleRootFileViewProvider;
import org.jetbrains.annotations.NotNull;

/**
 * CoffeeScript view provider that disables incremental reparsing
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public class CoffeeScriptViewProvider extends SingleRootFileViewProvider {

  public CoffeeScriptViewProvider(@NotNull PsiManager manager, @NotNull VirtualFile file) {
   super(manager, file);
  }

  public CoffeeScriptViewProvider(@NotNull PsiManager manager, @NotNull VirtualFile virtualFile, final boolean physical) {
    super(manager, virtualFile, physical);
  }

  protected CoffeeScriptViewProvider(@NotNull PsiManager manager, @NotNull VirtualFile virtualFile, final boolean physical, @NotNull Language language) {
    super(manager, virtualFile, physical, language);
  }

  public boolean supportsIncrementalReparse(final Language rootLanguage) {
    return false;
  }

}
