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

TERMINATOR          = [\n\r]
WHITESPACE          = [\ ]+
IDENTIFIER          = [a-zA-Z\$_]([a-zA-Z_0-9$])*
NUMBER              = (0(x|X)[0-9a-fA-F]+)|([0-9]+(\.[0-9]+)?(e[+\-]?[0-9]+)?)
DOUBLE_QUOTE_STRING = (\\.|[^\"])*
SINGLE_QUOTE_STRING = (\\.|[^\'])*
LINE_COMMENT        = #{1,2}[^#][^\n]*
BLOCK_COMMENT       = ###~###

RESERVED = case|default|function|var|void|with|const|let|enum|export|import|native|__hasProp|__extends|__slice|__bind|__indexOf
CLASS    = class
EXTENDS  = extends
THIS     = @
FUNCTION = ->

%state YYIDENTIFIER, YYNUMBER, YYDOUBLEQUOTE, YYSINGLEQUOTE
%state YYCOLON
%state YYCALLSTART, YYPARAMSTART

%%

<YYINITIAL> {
  {RESERVED}                  { yybegin(YYIDENTIFIER);   return CoffeeScriptTokenTypes.RESERVED;       }

  {CLASS}                     {                          return CoffeeScriptTokenTypes.CLASS;          }
  {EXTENDS}                   {                          return CoffeeScriptTokenTypes.EXTENDS;        }
  {THIS}                      {                          return CoffeeScriptTokenTypes.THIS;           }
  {FUNCTION}                  {                          return CoffeeScriptTokenTypes.FUNCTION;       }

  {IDENTIFIER}                { yybegin(YYIDENTIFIER);   return CoffeeScriptTokenTypes.IDENTIFIER;     }

  {NUMBER}                    { yybegin(YYNUMBER);       return CoffeeScriptTokenTypes.NUMBER;         }

  \"                          { yybegin(YYDOUBLEQUOTE);  return CoffeeScriptTokenTypes.STRING_LITERAL; }
  \'                          { yybegin(YYSINGLEQUOTE);  return CoffeeScriptTokenTypes.STRING_LITERAL; }

  "="                         {                          return CoffeeScriptTokenTypes.EQUALS;         }

  "["                         {                          return CoffeeScriptTokenTypes.BRACKET_START;  }
  "]"                         {                          return CoffeeScriptTokenTypes.BRACKET_END;    }

  ","                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.COMMA;          }

  "+"                         {                          return CoffeeScriptTokenTypes.PLUS;           }

  {LINE_COMMENT}              {                          return CoffeeScriptTokenTypes.LINE_COMMENT;   }
  {BLOCK_COMMENT}             {                          return CoffeeScriptTokenTypes.BLOCK_COMMENT;  }

  {TERMINATOR}                {                          return CoffeeScriptTokenTypes.TERMINATOR;     }
  {WHITESPACE}                {                          return CoffeeScriptTokenTypes.WHITESPACE;     }

}

<YYIDENTIFIER> {
  "="                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.EQUALS;         }
  "]"                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.BRACKET_END;    }
  ":"                         { yybegin(YYCOLON);        return CoffeeScriptTokenTypes.COLON;          }
  ","                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.COMMA;          }
  "("                         { yybegin(YYCALLSTART);    return CoffeeScriptTokenTypes.CALL_START;     }
  {TERMINATOR}                { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.TERMINATOR;     }
  {WHITESPACE}                { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.WHITESPACE;     }
}

<YYNUMBER> {
  ","                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.COMMA;          }
  {TERMINATOR}                { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.TERMINATOR;     }
  {WHITESPACE}                {                          return CoffeeScriptTokenTypes.WHITESPACE;     }
}

<YYDOUBLEQUOTE> {
  \"                          { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.STRING_LITERAL; }
  {DOUBLE_QUOTE_STRING}       {                          return CoffeeScriptTokenTypes.STRING;         }
}

<YYSINGLEQUOTE> {
  \'                          { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.STRING_LITERAL; }
  {SINGLE_QUOTE_STRING}       {                          return CoffeeScriptTokenTypes.STRING;         }
}

<YYCALLSTART> {
  {THIS}                      {                          return CoffeeScriptTokenTypes.THIS;           }
  {IDENTIFIER}                {                          return CoffeeScriptTokenTypes.IDENTIFIER;     }
  ","                         {                          return CoffeeScriptTokenTypes.COMMA;          }
  ")"                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.CALL_END;       }
}

<YYCOLON> {
  "("                         { yybegin(YYPARAMSTART);   return CoffeeScriptTokenTypes.PARAM_START;     }
  {FUNCTION}                  { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.FUNCTION;       }
  {TERMINATOR}                { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.TERMINATOR;     }
  {WHITESPACE}                {                          return CoffeeScriptTokenTypes.WHITESPACE;     }
}

<YYPARAMSTART> {
  {THIS}                      {                          return CoffeeScriptTokenTypes.THIS;           }
  {IDENTIFIER}                {                          return CoffeeScriptTokenTypes.IDENTIFIER;     }
  ","                         {                          return CoffeeScriptTokenTypes.COMMA;          }
  ")"                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.PARAM_END;      }
}

.                             { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.BAD_CHARACTER;  }
