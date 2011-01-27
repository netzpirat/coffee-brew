package org.coffeebrew.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.coffeebrew.file.CoffeeScriptFileType;
import org.coffeebrew.lang.lexer.CoffeeScriptFlexLexer;
import org.coffeebrew.lang.lexer.CoffeeScriptTokenSets;
import org.coffeebrew.lang.psi.impl.CoffeeScriptFileImpl;
import org.jetbrains.annotations.NotNull;

public class CoffeeScriptParserDefinition implements ParserDefinition {

  private static final IFileElementType FILE_ELEMENT_TYPE = new IFileElementType(CoffeeScriptFileType.COFFEE_SCRIPT_LANGUAGE);

  @NotNull
  public Lexer createLexer(Project project) {
    return new CoffeeScriptFlexLexer();
  }

  public PsiParser createParser(Project project) {
    return new CoffeeScriptParser();
  }

  public IFileElementType getFileNodeType() {
    return FILE_ELEMENT_TYPE;
  }

  @NotNull
  public TokenSet getWhitespaceTokens() {
    return CoffeeScriptTokenSets.WHITESPACE_TOKEN_SET;
  }

  @NotNull
  public TokenSet getCommentTokens() {
    return CoffeeScriptTokenSets.COMMENTS_TOKEN_SET;
  }

  @NotNull
  public TokenSet getStringLiteralElements() {
    return CoffeeScriptTokenSets.STRING_TOKEN_SET;
  }

  @NotNull
  public PsiElement createElement(ASTNode node) {
    return null;
  }

  public PsiFile createFile(FileViewProvider viewProvider) {
    return (PsiFile) new CoffeeScriptFileImpl(viewProvider);
  }

  public ParserDefinition.SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
    return ParserDefinition.SpaceRequirements.MAY;
  }

}
