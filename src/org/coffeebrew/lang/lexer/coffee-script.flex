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

TERMINATOR          = [\n\r]
WHITESPACE          = [\ ]+
IDENTIFIER          = [a-zA-Z\$_]([a-zA-Z_0-9$])*
NUMBER              = (0(x|X)[0-9a-fA-F]+)|(-?[0-9]+(\.[0-9]+)?(e[+\-]?[0-9]+)?)
DOUBLE_QUOTE_STRING = (\\.|[^\"])*
SINGLE_QUOTE_STRING = (\\.|[^\'])*
LINE_COMMENT        = #{1,2}[^#][^\n]*
BLOCK_COMMENT       = ###~###
REGEX               = \/.*\/[imgy]{0,4}

THIS            = @|this
RESERVED        = case|default|function|var|void|with|const|let|enum|export|import|native|__hasProp|__extends|__slice|__bind|__indexOf
LOGIC           = and|&&|or|\|\||&|\||\^
COMPARE         = ==|\!=|<|>|<=|>=|is|isnt
COMPOUND_ASSIGN = -=|\+=|\/=|\*=|%=|\|\|=|&&=|\?=|<<=|>>=|>>>=|&=|\^=|\|=|or=
BOOL            = true|yes|on|false|no|off
UNARY           = do|new|typeof|delete|\~|\!

%state YYIDENTIFIER, YYNUMBER, YYDOUBLEQUOTE, YYSINGLEQUOTE
%state YYCOLON, YYFOR

%%

<YYINITIAL> {
  {RESERVED}                  { yybegin(YYIDENTIFIER);   return CoffeeScriptTokenTypes.RESERVED;           }

  "class"                     {                          return CoffeeScriptTokenTypes.CLASS;              }
  "extends"                   {                          return CoffeeScriptTokenTypes.EXTENDS;            }
  "try"                       {                          return CoffeeScriptTokenTypes.TRY;                }
  "catch"                     {                          return CoffeeScriptTokenTypes.CATCH;              }
  "finally"                   {                          return CoffeeScriptTokenTypes.FINALLY;            }
  {THIS}                      {                          return CoffeeScriptTokenTypes.THIS;               }
  "->"                        {                          return CoffeeScriptTokenTypes.FUNCTION;           }
  "=>"                        {                          return CoffeeScriptTokenTypes.FUNCTION_BIND;      }

  "if"                        {                          return CoffeeScriptTokenTypes.IF;                 }
  "then"                      {                          return CoffeeScriptTokenTypes.THEN;               }
  "else"                      {                          return CoffeeScriptTokenTypes.ELSE;               }
  "unless"                    {                          return CoffeeScriptTokenTypes.UNLESS;             }
  "in"                        {                          return CoffeeScriptTokenTypes.RELATION;           }
  "for"                       { yybegin(YYFOR);          return CoffeeScriptTokenTypes.FOR;                }
  "while"                     {                          return CoffeeScriptTokenTypes.WHILE;              }
  "until"                     {                          return CoffeeScriptTokenTypes.UNTIL;              }
  "switch"                    {                          return CoffeeScriptTokenTypes.SWITCH;             }
  "when"                      {                          return CoffeeScriptTokenTypes.WHEN;               }

  {BOOL}                      {                          return CoffeeScriptTokenTypes.BOOL;               }
  {LOGIC}                     {                          return CoffeeScriptTokenTypes.LOGIC;              }
  {COMPARE}                   {                          return CoffeeScriptTokenTypes.COMPARE;            }
  {COMPOUND_ASSIGN}           {                          return CoffeeScriptTokenTypes.COMPOUND_ASSIGN;    }
  {UNARY}                     {                          return CoffeeScriptTokenTypes.UNARY;              }

  {REGEX}                     {                          return CoffeeScriptTokenTypes.REGEX;              }
  {IDENTIFIER}                { yybegin(YYIDENTIFIER);   return CoffeeScriptTokenTypes.IDENTIFIER;         }
  {NUMBER}                    { yybegin(YYNUMBER);       return CoffeeScriptTokenTypes.NUMBER;             }

  \"                          { yybegin(YYDOUBLEQUOTE);  return CoffeeScriptTokenTypes.STRING_LITERAL;     }
  \'                          { yybegin(YYSINGLEQUOTE);  return CoffeeScriptTokenTypes.STRING_LITERAL;     }

  "="                         {                          return CoffeeScriptTokenTypes.EQUAL;              }

  "["                         {                          return CoffeeScriptTokenTypes.BRACKET_START;      }
  "]"                         {                          return CoffeeScriptTokenTypes.BRACKET_END;        }

  "("                         {                          return CoffeeScriptTokenTypes.PARENTHESIS_START;  }
  ")"                         {                          return CoffeeScriptTokenTypes.PARENTHESIS_END;    }

  "."                         {                          return CoffeeScriptTokenTypes.DOT  ;              }
  ","                         {                          return CoffeeScriptTokenTypes.COMMA;              }

  "+"                         {                          return CoffeeScriptTokenTypes.PLUS;               }

  {LINE_COMMENT}              {                          return CoffeeScriptTokenTypes.LINE_COMMENT;       }
  {BLOCK_COMMENT}             {                          return CoffeeScriptTokenTypes.BLOCK_COMMENT;      }

  {TERMINATOR}                {                          return CoffeeScriptTokenTypes.TERMINATOR;         }
  {WHITESPACE}                {                          return CoffeeScriptTokenTypes.WHITESPACE;         }
}

<YYIDENTIFIER> {
  "="                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.EQUAL;              }
  "::"                        { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.PROTOTYPE;          }
  ":"                         { yybegin(YYCOLON);        return CoffeeScriptTokenTypes.COLON;              }
  "."                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.DOT  ;              }
  ","                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.COMMA;              }
  "("                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.PARENTHESIS_START;  }
  ")"                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.PARENTHESIS_END;    }
  "]"                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.BRACKET_END;        }
  "["                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.BRACKET_START;      }
  {TERMINATOR}                { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.TERMINATOR;         }
  {WHITESPACE}                { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.WHITESPACE;         }
}

<YYNUMBER> {
  ".."                        { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.RANGE;              }
  "..."                       { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.RANGE;              }
  ","                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.COMMA;              }
  "]"                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.BRACKET_END;        }
  "["                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.BRACKET_START;      }
  {TERMINATOR}                { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.TERMINATOR;         }
  {WHITESPACE}                { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.WHITESPACE;         }
}

<YYDOUBLEQUOTE> {
  \"                          { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.STRING_LITERAL;     }
  {DOUBLE_QUOTE_STRING}       {                          return CoffeeScriptTokenTypes.STRING;             }
}

<YYSINGLEQUOTE> {
  \'                          { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.STRING_LITERAL;     }
  {SINGLE_QUOTE_STRING}       {                          return CoffeeScriptTokenTypes.STRING;             }
}

<YYCOLON> {
  "("                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.PARENTHESIS_START;  }
  "->"                        { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.FUNCTION;           }
  {TERMINATOR}                { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.TERMINATOR;         }
  {WHITESPACE}                {                          return CoffeeScriptTokenTypes.WHITESPACE;         }
}

<YYFOR> {
  ","                         {                          return CoffeeScriptTokenTypes.COMMA;              }
  "of"                        { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.FOROF;              }
  "in"                        { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.FORIN;              }
  {IDENTIFIER}                {                          return CoffeeScriptTokenTypes.IDENTIFIER;         }
  {WHITESPACE}                {                          return CoffeeScriptTokenTypes.WHITESPACE;         }
}

.                             { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.BAD_CHARACTER;      }
