package org.coffeebrew.lang.lexer;


import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.coffeebrew.lang.lexer.CoffeeScriptTokenTypes;
import java.util.Stack;

%%

%debug

%unicode

%public
%class CoffeeScriptLexer
%implements FlexLexer
%type IElementType

%function advance

TERMINATOR          = [\n\r;]|\\\n
WHITE_SPACE          = [\ ]+
IDENTIFIER          = [a-zA-Z\$_]([a-zA-Z_0-9$])*
NUMBER              = (0(x|X)[0-9a-fA-F]+)|(-?[0-9]+(\.[0-9]+)?(e[+\-]?[0-9]+)?)
DOUBLE_QUOTE_STRING = (\\.|[^\"\n\r])*
SINGLE_QUOTE_STRING = (\\.|[^\'\n\r])*
LINE_COMMENT        = #{1,2}[^#][^\n]*
BLOCK_COMMENT       = ###~###
REGEX               = \/.*\/[imgy]{0,4}
JAVASCRIPT          = [^`]+

THIS            = @|this
RESERVED        = case|default|function|var|void|with|const|let|enum|export|import|native|__hasProp|__extends|__slice|__bind|__indexOf
LOGIC           = and|&&|or|\|\||&|\||\^|\?
COMPARE         = ==|\!=|<|>|<=|>=|is|isnt
COMPOUND_ASSIGN = -=|\+=|\/=|\*=|%=|\|\|=|&&=|\?=|<<=|>>=|>>>=|&=|\^=|\|=|or=
BOOL            = true|yes|on|false|no|off|undefined|null
UNARY           = do|new|typeof|delete|\~|\!|not

%state YYIDENTIFIER, YYNUMBER
%state YYDOUBLEQUOTE, YYSINGLEQUOTE, YYJAVASCRIPT

%%

<YYINITIAL> {
  {RESERVED}                  {                          return CoffeeScriptTokenTypes.ERROR_ELEMENT;      }

  {THIS}                      {                          return CoffeeScriptTokenTypes.THIS;               }

  "class"                     {                          return CoffeeScriptTokenTypes.CLASS;              }
  "extends"                   {                          return CoffeeScriptTokenTypes.EXTENDS;            }
  "try"                       {                          return CoffeeScriptTokenTypes.TRY;                }
  "catch"                     {                          return CoffeeScriptTokenTypes.CATCH;              }
  "finally"                   {                          return CoffeeScriptTokenTypes.FINALLY;            }
  "if"                        {                          return CoffeeScriptTokenTypes.IF;                 }
  "then"                      {                          return CoffeeScriptTokenTypes.THEN;               }
  "else"                      {                          return CoffeeScriptTokenTypes.ELSE;               }
  "unless"                    {                          return CoffeeScriptTokenTypes.UNLESS;             }
  "for"                       {                          return CoffeeScriptTokenTypes.FOR;                }
  "in"                        {                          return CoffeeScriptTokenTypes.IN;                 }
  "of"                        {                          return CoffeeScriptTokenTypes.OF;                 }
  "while"                     {                          return CoffeeScriptTokenTypes.WHILE;              }
  "until"                     {                          return CoffeeScriptTokenTypes.UNTIL;              }
  "switch"                    {                          return CoffeeScriptTokenTypes.SWITCH;             }
  "when"                      {                          return CoffeeScriptTokenTypes.WHEN;               }

  {BOOL}                      {                          return CoffeeScriptTokenTypes.BOOL;               }
  {LOGIC}                     {                          return CoffeeScriptTokenTypes.LOGIC;              }
  {COMPARE}                   {                          return CoffeeScriptTokenTypes.COMPARE;            }
  {COMPOUND_ASSIGN}           {                          return CoffeeScriptTokenTypes.COMPOUND_ASSIGN;    }
  {UNARY}                     {                          return CoffeeScriptTokenTypes.UNARY;              }

  \"                          { yybegin(YYDOUBLEQUOTE);  return CoffeeScriptTokenTypes.STRING_LITERAL;     }
  \'                          { yybegin(YYSINGLEQUOTE);  return CoffeeScriptTokenTypes.STRING_LITERAL;     }

  {REGEX}                     {                          return CoffeeScriptTokenTypes.REGEX;              }
  "`"                         { yybegin(YYJAVASCRIPT);   return CoffeeScriptTokenTypes.JAVASCRIPT_LITERAL; }

  {IDENTIFIER}                { yybegin(YYIDENTIFIER);   return CoffeeScriptTokenTypes.IDENTIFIER;         }
  {NUMBER}                    { yybegin(YYNUMBER);       return CoffeeScriptTokenTypes.NUMBER;             }


  "->"                        {                          return CoffeeScriptTokenTypes.FUNCTION;           }
  "=>"                        {                          return CoffeeScriptTokenTypes.FUNCTION_BIND;      }

  "="                         {                          return CoffeeScriptTokenTypes.EQUAL;              }

  "["                         {                          return CoffeeScriptTokenTypes.BRACKET_START;      }
  "]"                         {                          return CoffeeScriptTokenTypes.BRACKET_END;        }

  "("                         {                          return CoffeeScriptTokenTypes.PARENTHESIS_START;  }
  ")"                         {                          return CoffeeScriptTokenTypes.PARENTHESIS_END;    }

  "{"                         {                          return CoffeeScriptTokenTypes.BRACE_START;        }
  "}"                         {                          return CoffeeScriptTokenTypes.BRACE_END;          }

  "."                         {                          return CoffeeScriptTokenTypes.DOT;                }
  ":"                         {                          return CoffeeScriptTokenTypes.COLON;              }
  ","                         {                          return CoffeeScriptTokenTypes.COMMA;              }

  "+"                         {                          return CoffeeScriptTokenTypes.PLUS;               }
  "-"                         {                          return CoffeeScriptTokenTypes.MINUS;              }
  "*"                         {                          return CoffeeScriptTokenTypes.MATH;               }
  "%"                         {                          return CoffeeScriptTokenTypes.MATH;               }

  {LINE_COMMENT}              {                          return CoffeeScriptTokenTypes.LINE_COMMENT;       }
  {BLOCK_COMMENT}             {                          return CoffeeScriptTokenTypes.BLOCK_COMMENT;      }

  {TERMINATOR}                {                          return CoffeeScriptTokenTypes.TERMINATOR;         }
  {WHITE_SPACE}               {                          return CoffeeScriptTokenTypes.WHITE_SPACE;        }
}

<YYIDENTIFIER, YYNUMBER> {
  "."                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.DOT;                }
  ":"                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.COLON;              }
  "::"                        { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.PROTOTYPE;          }
  ","                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.COMMA;              }
  "["                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.BRACKET_START;      }
  "]"                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.BRACKET_END;        }
  {TERMINATOR}                { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.TERMINATOR;         }
  {WHITE_SPACE}               { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.WHITE_SPACE;        }
}

<YYIDENTIFIER> {
  "?"                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.EXIST;              }
  "..."                       { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.SPLAT;              }
  "("                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.PARENTHESIS_START;  }
  ")"                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.PARENTHESIS_END;    }
}

<YYNUMBER> {
  ".."                        { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.RANGE;              }
  "..."                       { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.RANGE;              }
}

<YYDOUBLEQUOTE, YYSINGLEQUOTE> {
  [\n\r]                      {                          return CoffeeScriptTokenTypes.TERMINATOR;         }
}

<YYDOUBLEQUOTE> {
  \"                          { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.STRING_LITERAL;     }
  {DOUBLE_QUOTE_STRING}       {                          return CoffeeScriptTokenTypes.STRING;             }
}

<YYSINGLEQUOTE> {
  \'                          { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.STRING_LITERAL;     }
  {SINGLE_QUOTE_STRING}       {                          return CoffeeScriptTokenTypes.STRING;             }
}

<YYJAVASCRIPT> {
  "`"                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.JAVASCRIPT_LITERAL; }
  {JAVASCRIPT}                {                          return CoffeeScriptTokenTypes.JAVASCRIPT;         }
}

.                             { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.BAD_CHARACTER;      }
