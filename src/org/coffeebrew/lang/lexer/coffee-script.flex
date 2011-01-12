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

%{
    private Stack<IElementType> bracketStack = new Stack<IElementType>();

    private void pushBracket(IElementType bracket) {
        bracketStack.push(bracket);
    }

    private IElementType popBracket() {
        return bracketStack.pop();
    }

%}

TERMINATOR          = [\n\r]
WHITESPACE          = [\ ]+
IDENTIFIER          = [a-zA-Z\$_]([a-zA-Z_0-9$])*
NUMBER              = (0(x|X)[0-9a-fA-F]+)|(-?[0-9]+(\.[0-9]+)?(e[+\-]?[0-9]+)?)
DOUBLE_QUOTE_STRING = (\\.|[^\"])*
SINGLE_QUOTE_STRING = (\\.|[^\'])*
LINE_COMMENT        = #{1,2}[^#][^\n]*
BLOCK_COMMENT       = ###~###

THIS            = @|this
RESERVED        = case|default|function|var|void|with|const|let|enum|export|import|native|__hasProp|__extends|__slice|__bind|__indexOf
LOGIC           = and|&&|or|\|\||&|\||\^
COMPARE         = ==|\!=|<|>|<=|>=
COMPOUND_ASSIGN = -=|\+=|\/=|\*=|%=|\|\|=|&&=|\?=|<<=|>>=|>>>=|&=|\^=|\|=

%state YYIDENTIFIER, YYNUMBER, YYDOUBLEQUOTE, YYSINGLEQUOTE
%state YYCOLON, YYFOR
%state YYCALLSTART, YYPARAMSTART

%%

<YYINITIAL> {
  {RESERVED}                  { yybegin(YYIDENTIFIER);   return CoffeeScriptTokenTypes.RESERVED;           }

  "class"                     {                          return CoffeeScriptTokenTypes.CLASS;              }
  "extends"                   {                          return CoffeeScriptTokenTypes.EXTENDS;            }
  {THIS}                      {                          return CoffeeScriptTokenTypes.THIS;               }
  "->"                        {                          return CoffeeScriptTokenTypes.FUNCTION;           }

  "if"                        {                          return CoffeeScriptTokenTypes.IF;                 }
  "then"                      {                          return CoffeeScriptTokenTypes.THEN;               }
  "else"                      {                          return CoffeeScriptTokenTypes.ELSE;               }
  "unless"                    {                          return CoffeeScriptTokenTypes.UNLESS;             }

  "for"                       { yybegin(YYFOR);          return CoffeeScriptTokenTypes.FOR;                }

  "while"                     {                          return CoffeeScriptTokenTypes.WHILE;              }
  "until"                     {                          return CoffeeScriptTokenTypes.UNTIL;              }

  {LOGIC}                     {                          return CoffeeScriptTokenTypes.LOGIC;              }
  {COMPARE}                   {                          return CoffeeScriptTokenTypes.COMPARE;            }
  {COMPOUND_ASSIGN}           { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.COMPOUND_ASSIGN;    }

  {IDENTIFIER}                { yybegin(YYIDENTIFIER);   return CoffeeScriptTokenTypes.IDENTIFIER;         }

  {NUMBER}                    { yybegin(YYNUMBER);       return CoffeeScriptTokenTypes.NUMBER;             }

  \"                          { yybegin(YYDOUBLEQUOTE);  return CoffeeScriptTokenTypes.STRING_LITERAL;     }
  \'                          { yybegin(YYSINGLEQUOTE);  return CoffeeScriptTokenTypes.STRING_LITERAL;     }

  "="                         {                          return CoffeeScriptTokenTypes.EQUAL;              }

  "["                         {                          pushBracket(CoffeeScriptTokenTypes.BRACKET_END);
                                                         return CoffeeScriptTokenTypes.BRACKET_START;      }
  "]"                         {                          return popBracket();                              }

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
  ":"                         { yybegin(YYCOLON);        return CoffeeScriptTokenTypes.COLON;              }
  "."                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.DOT  ;              }
  ","                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.COMMA;              }
  "("                         { yybegin(YYCALLSTART);    return CoffeeScriptTokenTypes.CALL_START;         }
  "]"                         { yybegin(YYINITIAL);      return popBracket();                              }
  "["                         { yybegin(YYINITIAL);      pushBracket(CoffeeScriptTokenTypes.INDEX_END);
                                                         return CoffeeScriptTokenTypes.INDEX_START;        }
  {TERMINATOR}                { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.TERMINATOR;         }
  {WHITESPACE}                { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.WHITESPACE;         }
}

<YYNUMBER> {
  ".."                        { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.RANGE;              }
  "..."                       { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.RANGE;              }
  ","                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.COMMA;              }
  "]"                         { yybegin(YYINITIAL);      return popBracket();                              }
  "["                         { yybegin(YYINITIAL);      pushBracket(CoffeeScriptTokenTypes.INDEX_END);
                                                         return CoffeeScriptTokenTypes.INDEX_START;        }
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

<YYCALLSTART> {
  {THIS}                      {                          return CoffeeScriptTokenTypes.THIS;               }
  ","                         {                          return CoffeeScriptTokenTypes.COMMA;              }
  ")"                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.CALL_END;           }
  {IDENTIFIER}                {                          return CoffeeScriptTokenTypes.IDENTIFIER;         }
}

<YYCOLON> {
  "("                         { yybegin(YYPARAMSTART);   return CoffeeScriptTokenTypes.PARAM_START;        }
  "->"                        { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.FUNCTION;           }
  {TERMINATOR}                { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.TERMINATOR;         }
  {WHITESPACE}                {                          return CoffeeScriptTokenTypes.WHITESPACE;         }
}

<YYPARAMSTART> {
  {THIS}                      {                          return CoffeeScriptTokenTypes.THIS;               }
  ","                         {                          return CoffeeScriptTokenTypes.COMMA;              }
  ")"                         { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.PARAM_END;          }
  {IDENTIFIER}                {                          return CoffeeScriptTokenTypes.IDENTIFIER;         }
}

<YYFOR> {
  ","                         {                          return CoffeeScriptTokenTypes.COMMA;              }
  "of"                        { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.FOROF;              }
  "in"                        { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.FORIN;              }
  {IDENTIFIER}                {                          return CoffeeScriptTokenTypes.IDENTIFIER;         }
  {WHITESPACE}                {                          return CoffeeScriptTokenTypes.WHITESPACE;         }
}

.                             { yybegin(YYINITIAL);      return CoffeeScriptTokenTypes.BAD_CHARACTER;      }
