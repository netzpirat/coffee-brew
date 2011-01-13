package org.coffeebrew.lang.highlighter;

import com.intellij.ide.highlighter.HtmlFileHighlighter;
import com.intellij.openapi.application.ApplicationNamesInfo;
import com.intellij.openapi.editor.XmlHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.OptionsBundle;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import org.coffeebrew.CoffeeScriptIcons;
import org.coffeebrew.lang.lexer.CoffeeScriptTokenSets;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.sql.Array;
import java.util.Map;

/**
 * CoffeeScript color settings page
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public class CoffeeScriptColorSettingsPage {

//  private static final AttributesDescriptor[] ATTRS = new AttributesDescriptor[]{
//          new AttributesDescriptor("Number", CoffeeScriptSyntaxHighlighter.NUMBER),
//          new AttributesDescriptor("Operator", CoffeeScriptSyntaxHighlighter.OPERATOR),
//          new AttributesDescriptor("Assignment", CoffeeScriptSyntaxHighlighter.ASSIGNMENT),
//          new AttributesDescriptor("Line comment", CoffeeScriptSyntaxHighlighter.COMMENT),
//          new AttributesDescriptor("Block comment", CoffeeScriptSyntaxHighlighter.BLOCK_COMMENT),
//          new AttributesDescriptor("Single quoted string", CoffeeScriptSyntaxHighlighter.SINGLE_QUOTE_STRING),
//          new AttributesDescriptor("Double quoted string", CoffeeScriptSyntaxHighlighter.DOUBLE_QUOTE_STRING),
//          new AttributesDescriptor("Single quoted heredoc", CoffeeScriptSyntaxHighlighter.SINGLE_QUOTE_HEREDOC),
//          new AttributesDescriptor("Double quoted heredoc", CoffeeScriptSyntaxHighlighter.DOUBLE_QUOTE_HEREDOC),
//          new AttributesDescriptor("String literal", CoffeeScriptSyntaxHighlighter.STRING_LITERAL),
//          new AttributesDescriptor("Keyword", CoffeeScriptSyntaxHighlighter.KEYWORD),
//          new AttributesDescriptor("Reserved keyword", CoffeeScriptSyntaxHighlighter.RESERVED_WORD),
//          new AttributesDescriptor("Interpolation", CoffeeScriptSyntaxHighlighter.INTERPOLATION),
//  };

  @NotNull
  public String getDisplayName() {
    return "CoffeeScript";
  }

  public Icon getIcon() {
    return CoffeeScriptIcons.FILE_TYPE;
  }

  @NotNull
  public AttributesDescriptor[] getAttributeDescriptors() {
    // TODO: Get attribute descriptors from TokenSet
    //CoffeeScriptTokenSets.SYNTAX_HIGHLIGHTER_TOKEN_SET.getTypes();
    return new AttributesDescriptor[]{};
  }

  @NotNull
  public ColorDescriptor[] getColorDescriptors() {
    return ColorDescriptor.EMPTY_ARRAY;
  }

  @NotNull
  public CoffeeScriptSyntaxHighlighter getHighlighter() {
    return new CoffeeScriptSyntaxHighlighter();
  }

  @NotNull
  public String getDemoText() {
    return "###\n" +
            "Some examples\n" +
            "###\n" +
            "class Animal\n" +
            "  constructor: (@name) -> \n" +
            "  move: (meters) -> alert @name + \" moved \" + meters + \"m.\"\n" +
            "\n" +
            "class Snake extends Animal\n" +
            "  move: -> \n" +
            "    alert \'Slithering...\'\n" +
            "    super 5\n" +
            "\n" +
            "# Assignment:\n" +
            "number   = 42\n" +
            "opposite = true\n" +
            "\n" +
            "# Conditions:\n" +
            "number = -42 if opposite\n" +
            "\n" +
            "# Functions: \n" +
            "square = (x) -> x * x\n" +
            "\n" +
            "# Arrays:\n" +
            "list = [1, 2, 3, 4, 5]\n" +
            "\n" +
            "# Objects:\n" +
            "math =\n" +
            "  root:   Math.sqrt\n" +
            "  square: square\n" +
            "  cube:   (x) -> x * square x\n" +
            "\n" +
            "# Splats:\n" +
            "race = (winner, runners...) ->\n" +
            "  print winner, runners\n" +
            "\n" +
            "# Existence:\n" +
            "alert \"I knew it!\" if elvis?\n" +
            "\n" +
            "# Array comprehensions:\n" +
            "cubes = math.cube num for num in list\n" +
            "\n" +
            "# Interpolation\n" +
            "s = \"The result is #{ number }\"\n" +
            "\n" +
            "# Heredocs\n" +
            "text = \"\"\"\n" +
            " Result \n" +
            "    is #{ @numbder }\"\"\"\n" +
            "\n" +
            "o = ''' Another '''\n";
  }

  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return null;
  }

}
