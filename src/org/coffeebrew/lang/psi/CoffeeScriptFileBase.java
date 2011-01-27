package org.coffeebrew.lang.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import static org.coffeebrew.file.CoffeeScriptFileType.*;

/**
 * A CoffeeScript file
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public class CoffeeScriptFileBase extends PsiFileBase {

    public CoffeeScriptFileBase(FileViewProvider viewProvider) {
        super(viewProvider, COFFEE_SCRIPT_FILE_TYPE.getLanguage());
    }

    @NotNull
    public FileType getFileType() {
        return COFFEE_SCRIPT_FILE_TYPE;
    }

    public String toString() {
        return "CoffeeScript File: " + getName();
    }
}
