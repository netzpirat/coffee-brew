package org.coffeebrew.lang.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.coffeebrew.lang.psi.CoffeeScriptElement;

/**
 * @author Michael Kessler
 * @since 0.1.8
 */
public class CoffeeScriptElementImpl extends ASTWrapperPsiElement implements CoffeeScriptElement {

  private final ASTNode node;

  public CoffeeScriptElementImpl(final ASTNode node) {
    super(node);
    this.node = node;
  }

  public String toString() {
    return "CS:" + node.getElementType().toString();
  }

}
