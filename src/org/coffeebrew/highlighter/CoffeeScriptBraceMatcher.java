package org.coffeebrew.highlighter;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.coffeebrew.lang.lexer.CoffeeScriptTokenTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Brace matcher for the CoffeeScript language
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public class CoffeeScriptBraceMatcher implements PairedBraceMatcher {

  private static final BracePair[] PAIRS = {
          new BracePair(CoffeeScriptTokenTypes.PARENTHESIS_START, CoffeeScriptTokenTypes.PARENTHESIS_END, false),
          new BracePair(CoffeeScriptTokenTypes.BRACKET_START, CoffeeScriptTokenTypes.BRACKET_END, false),
          new BracePair(CoffeeScriptTokenTypes.BRACE_START, CoffeeScriptTokenTypes.BRACE_END, false),
          new BracePair(CoffeeScriptTokenTypes.REGEX_START, CoffeeScriptTokenTypes.REGEX_END, false),
          new BracePair(CoffeeScriptTokenTypes.REGEX_BRACKET_START, CoffeeScriptTokenTypes.REGEX_BRACKET_END, false),
          new BracePair(CoffeeScriptTokenTypes.REGEX_PARENTHESIS_START, CoffeeScriptTokenTypes.REGEX_PARENTHESIS_END, false),
          new BracePair(CoffeeScriptTokenTypes.REGEX_BRACE_START, CoffeeScriptTokenTypes.REGEX_BRACE_END, true),
          new BracePair(CoffeeScriptTokenTypes.INTERPOLATION_START, CoffeeScriptTokenTypes.INTERPOLATION_END, true),
  };

  public BracePair[] getPairs() {
    return PAIRS;
  }

  public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType ibraceType, @Nullable IElementType tokenType) {
    return true;
  }

  public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
    return openingBraceOffset;
  }

}
