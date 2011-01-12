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
IDENTIFIER = [a-zA-Z\$_]([a-zA-Z_0-9$])*
NUMBER     = (0(x|X)[0-9a-fA-F]+)|([0-9]+(\.[0-9]+)?(e[+\-]?[0-9]+)?)

%state YYIDENTIFIER, YYNUMBER

%%

<YYINITIAL> {

  {IDENTIFIER}                { yybegin(YYIDENTIFIER);   return CoffeeScriptTokenTypes.IDENTIFIER;     }

  {NUMBER}                    { yybegin(YYNUMBER);       return CoffeeScriptTokenTypes.NUMBER;         }

  {TERMINATOR}                {                          return CoffeeScriptTokenTypes.TERMINATOR;     }
  {WHITESPACE}                {                          return CoffeeScriptTokenTypes.WHITESPACE;     }
}

<YYIDENTIFIER> {
  "="                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.EQUALS;         }
  {TERMINATOR}                {                          return CoffeeScriptTokenTypes.TERMINATOR;     }
  {WHITESPACE}                {                          return CoffeeScriptTokenTypes.WHITESPACE;     }
}

<YYNUMBER> {
  {TERMINATOR}                { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.TERMINATOR;     }
  {WHITESPACE}                {                          return CoffeeScriptTokenTypes.WHITESPACE;     }
}

.                             { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.BAD_CHARACTER;  }
