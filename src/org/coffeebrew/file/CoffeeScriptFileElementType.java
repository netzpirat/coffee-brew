package org.coffeebrew.file;

import com.intellij.lang.*;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IFileElementType;

/**
 * @author Michael Kessler
 * @since 0.1.5
 */
public class CoffeeScriptFileElementType extends IFileElementType {

  public CoffeeScriptFileElementType() {
    super("CoffeeScript File", CoffeeScriptFileType.COFFEE_SCRIPT_LANGUAGE);
  }

  public ASTNode parseContents(ASTNode chameleon) {
    final PsiElement psi = chameleon.getPsi();
    assert psi != null : "Bad chameleon: " + chameleon;
    final Project project = psi.getProject();
    final PsiBuilderFactory factory = PsiBuilderFactory.getInstance();

    final PsiBuilder builder = factory.createBuilder(project, chameleon);

    final PsiParser parser = LanguageParserDefinitions.INSTANCE.forLanguage(getLanguage()).createParser(project);
    return parser.parse(this, builder);
  }
}
