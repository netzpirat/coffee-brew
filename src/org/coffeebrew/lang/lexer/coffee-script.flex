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

TERMINATOR         = [\n\r]
WHITESPACE         = [\ ]+
IDENTIFIER         = [a-zA-Z\$_]([a-zA-Z_0-9$])*
NUMBER             = (0(x|X)[0-9a-fA-F]+)|([0-9]+(\.[0-9]+)?(e[+\-]?[0-9]+)?)
DOUBLEQUOTE_STRING = (\\.|[^\"])*
SINGLEQUOTE_STRING = (\\.|[^\'])*

RESERVED = case|default|function|var|void|with|const|let|enum|export|import|native|__hasProp|__extends|__slice|__bind|__indexOf

%state YYIDENTIFIER, YYNUMBER, YYDOUBLEQUOTE, YYSINGLEQUOTE

%%

<YYINITIAL> {
  {RESERVED}                  { yybegin(YYIDENTIFIER);   return CoffeeScriptTokenTypes.RESERVED;       }
  {IDENTIFIER}                { yybegin(YYIDENTIFIER);   return CoffeeScriptTokenTypes.IDENTIFIER;     }

  {NUMBER}                    { yybegin(YYNUMBER);       return CoffeeScriptTokenTypes.NUMBER;         }

  \"                          { yybegin(YYDOUBLEQUOTE);  return CoffeeScriptTokenTypes.STRING_LITERAL; }
  \'                          { yybegin(YYSINGLEQUOTE);  return CoffeeScriptTokenTypes.STRING_LITERAL; }

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

<YYDOUBLEQUOTE> {
  \"                          { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.STRING_LITERAL; }
  {DOUBLEQUOTE_STRING}        {                          return CoffeeScriptTokenTypes.STRING;         }
}

<YYSINGLEQUOTE> {
  \'                          { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.STRING_LITERAL; }
  {SINGLEQUOTE_STRING}        {                          return CoffeeScriptTokenTypes.STRING;         }
}

.                             { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.BAD_CHARACTER;  }
