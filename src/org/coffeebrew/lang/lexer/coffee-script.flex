package org.coffeebrew.lang.lexer;


import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.coffeebrew.lang.lexer.CoffeeScriptTokenTypes;

%%

%unicode

%public
%class CoffeeScriptLexer
%implements FlexLexer
%type IElementType

%function advance

TERMINATOR = [\n\r;]

%%

<YYINITIAL> {
    {TERMINATOR}                { return CoffeeScriptTokenTypes.TERMINATOR; }
}

.                               { yybegin(YYINITIAL);   return CoffeeScriptTokenTypes.WRONG_TOKEN; }
