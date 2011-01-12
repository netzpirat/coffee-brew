package org.coffeebrew.lang.lexer;


import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.coffeebrew.lang.lexer.CoffeeScriptTokenTypes;

%%

%debug

%unicode

%public
%class CoffeeScriptLexer
%implements FlexLexer
%type IElementType

%function advance

TERMINATOR = [\n\r]
WHITESPACE = [\ ]+

%%

<YYINITIAL> {
  {TERMINATOR}                {                          return CoffeeScriptTokenTypes.TERMINATOR;     }
  {WHITESPACE}                {                          return CoffeeScriptTokenTypes.WHITESPACE;     }
}

.                             { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.BAD_CHARACTER;  }
