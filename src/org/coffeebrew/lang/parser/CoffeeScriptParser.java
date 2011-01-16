package org.coffeebrew.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.impl.source.tree.PlainTextFileElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * Parser implementation for CoffeeScript language support
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public class CoffeeScriptParser implements PsiParser {

  @NotNull
  public ASTNode parse(IElementType root, PsiBuilder builder) {
    return new PlainTextFileElement(builder.getOriginalText());
  }

}
