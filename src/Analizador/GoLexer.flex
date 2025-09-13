package Analizador;

import Modelo.Token;

%%
%public
%class AnalizadorFlex
%unicode
%function yylex
%type Modelo.Token

DIGITO    = [0-9]
LETRA     = [a-zA-Z_]
ID        = {LETRA}({LETRA}|{DIGITO})*
INT_LIT   = {DIGITO}+
WS        = [ \t\r\n]+

%%

{WS}       { /* ignorar espacios en blanco */ }

"package"  { return new Token(Token.PACKAGE,     yytext()); }
"import"   { return new Token(Token.IMPORT,      yytext()); }
"func"     { return new Token(Token.FUNC,        yytext()); }

"="        { return new Token(Token.ASSIGN,      yytext()); }
"+"        { return new Token(Token.PLUS,        yytext()); }
"-"        { return new Token(Token.MINUS,       yytext()); }
"*"        { return new Token(Token.MULT,        yytext()); }
"/"        { return new Token(Token.DIV,         yytext()); }

"("        { return new Token(Token.LPAREN,      yytext()); }
")"        { return new Token(Token.RPAREN,      yytext()); }
"{"        { return new Token(Token.LBRACE,      yytext()); }
"}"        { return new Token(Token.RBRACE,      yytext()); }
";"        { return new Token(Token.SEMICOLON,   yytext()); }
"\""       { return new Token(Token.QUOTE,       yytext()); }

{ID}       { return new Token(Token.IDENTIFIER,  yytext()); }
{INT_LIT}  { return new Token(Token.INT_LITERAL, yytext()); }

.          { System.err.println("⚠ Error léxico: caracter no reconocido '" + yytext() + "'"); }

<<EOF>>    { return null; }
