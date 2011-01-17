package org.coffeebrew.highlighter;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.coffeebrew.CoffeeScriptIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Map;

/**
 * CoffeeScript color settings page
 *
 * @author Michael Kessler
 * @since 0.1.0
 */
public class CoffeeScriptColorSettingsPage implements ColorSettingsPage {

  private static final AttributesDescriptor[] ATTRS = new AttributesDescriptor[]{
          new AttributesDescriptor("Bad character", CoffeeScriptSyntaxHighlighter.BAD_CHARACTER),
          new AttributesDescriptor("Dot", CoffeeScriptSyntaxHighlighter.DOT),
          new AttributesDescriptor("Colon", CoffeeScriptSyntaxHighlighter.COLON),
          new AttributesDescriptor("Comma", CoffeeScriptSyntaxHighlighter.COMMA),
          new AttributesDescriptor("Semicolon", CoffeeScriptSyntaxHighlighter.SEMICOLON),
          new AttributesDescriptor("Parenthesis", CoffeeScriptSyntaxHighlighter.PARENTHESIS),
          new AttributesDescriptor("Brackets", CoffeeScriptSyntaxHighlighter.BRACKETS),
          new AttributesDescriptor("Braces", CoffeeScriptSyntaxHighlighter.BRACES),
          new AttributesDescriptor("Line comment", CoffeeScriptSyntaxHighlighter.LINE_COMMENT),
          new AttributesDescriptor("Block comment", CoffeeScriptSyntaxHighlighter.BLOCK_COMMENT),
          new AttributesDescriptor("Identifier", CoffeeScriptSyntaxHighlighter.IDENTIFIER),
          new AttributesDescriptor("Number", CoffeeScriptSyntaxHighlighter.NUMBER),
          new AttributesDescriptor("Boolean", CoffeeScriptSyntaxHighlighter.BOOLEAN),
          new AttributesDescriptor("String literal", CoffeeScriptSyntaxHighlighter.STRING_LITERAL),
          new AttributesDescriptor("String", CoffeeScriptSyntaxHighlighter.STRING),
          new AttributesDescriptor("Expression substitution mark", CoffeeScriptSyntaxHighlighter.EXPRESSIONS_SUBSTITUTION_MARK),
          new AttributesDescriptor("Escape sequence", CoffeeScriptSyntaxHighlighter.ESCAPE_SEQUENCE),
          new AttributesDescriptor("This references", CoffeeScriptSyntaxHighlighter.THIS),
          new AttributesDescriptor("Prototype", CoffeeScriptSyntaxHighlighter.PROTOTYPE),
          new AttributesDescriptor("Function", CoffeeScriptSyntaxHighlighter.FUNCTION),
          new AttributesDescriptor("Function binding", CoffeeScriptSyntaxHighlighter.FUNCTION_BINDING),
          new AttributesDescriptor("Operations", CoffeeScriptSyntaxHighlighter.OPERATIONS),
          new AttributesDescriptor("Existential operator", CoffeeScriptSyntaxHighlighter.EXISTENTIAL),
          new AttributesDescriptor("Keyword", CoffeeScriptSyntaxHighlighter.KEYWORD),
          new AttributesDescriptor("Range", CoffeeScriptSyntaxHighlighter.RANGE),
          new AttributesDescriptor("Splat", CoffeeScriptSyntaxHighlighter.SPLAT),
          new AttributesDescriptor("Regular expression id", CoffeeScriptSyntaxHighlighter.REGULAR_EXPRESSION_ID),
          new AttributesDescriptor("Regular expression content", CoffeeScriptSyntaxHighlighter.REGULAR_EXPRESSION_CONTENT),
          new AttributesDescriptor("Regular expression flag", CoffeeScriptSyntaxHighlighter.REGULAR_EXPRESSION_FLAG),
          new AttributesDescriptor("Heredoc id", CoffeeScriptSyntaxHighlighter.HEREDOC_ID),
          new AttributesDescriptor("Heredoc content", CoffeeScriptSyntaxHighlighter.HEREDOC_CONTENT),
          new AttributesDescriptor("Heregex id", CoffeeScriptSyntaxHighlighter.HEREGEX_ID),
          new AttributesDescriptor("Heregex content", CoffeeScriptSyntaxHighlighter.HEREGEX_CONTENT),
          new AttributesDescriptor("Javascript id", CoffeeScriptSyntaxHighlighter.JAVASCRIPT_ID),
          new AttributesDescriptor("Javascript content", CoffeeScriptSyntaxHighlighter.JAVASCRIPT_CONTENT),
  };

  @NotNull
  public String getDisplayName() {
    return "CoffeeScript";
  }

  public Icon getIcon() {
    return CoffeeScriptIcons.FILE_TYPE;
  }

  @NotNull
  public AttributesDescriptor[] getAttributeDescriptors() {
    return ATTRS;
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
            "Some tests\n" +
            "###\n" +
            "class Animal\n" +
            "  constructor: (@name) -> \n" +
            "  move: (meters) => alert @name + \" moved \" + meters + \"m.\"\n" +
            "\n" +
            "class Snake extends Animal\n" +
            "  move: -> \n" +
            "    alert \'Slithering...\'\n" +
            "    super 5\n" +
            "\n" +
            "number   = 42; opposite = true\n" +
            "\n" +
            "/^a\\/\\\\[a-Z/\\n]\\u00A3b$/.test 'a//b'\n" +
            "\n" +
            "square = (x) -> x * x\n" +
            "\n" +
            "list = [1...5]\n" +
            "\n" +
            "math =\n" +
            "  root:   Math.sqrt\n" +
            "  cube:   (x) => x * square x\n" +
            "\n" +
            "race = (winner, runners...) ->\n" +
            "  print winner, runners\n" +
            "\n" +
            "alert \"I knew it!\" if elvis?\n" +
            "\n" +
            "cubes = math.cube num for num in list\n" +
            "\n" +
            "text = \"\"\"\n" +
            " Result \n" +
            "    is #{ @number }\"\"\"\n" +
            "\n" +
            "html = ''' " +
            "  <body></body>" +
            "'''\n" +
            "let me = 0 # let is reserved\n" +
            "\n" +
            "String::dasherize = ->\n" +
            "  this.replace /_/g, \"-\"" +
            "\n" +
            "singers = {Jagger: \"Rock\", Elvis: \"Roll\"}\n" +
            "\n" +
            "t = ///\n" +
            "#{ something }[a-z]\n" +
            "///igm\n" +
            "\n" +
            "hi = `function() {\n" +
            "  return [document.title, \"Hello JavaScript\"].join(\": \");\n" +
            "}`";
  }

  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return null;
  }

}
