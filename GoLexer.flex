package Analizador;

import java.util.*;
import java.io.*;

%%

%public
%class GoLexer
%unicode
%function yylex
%type String
%integer

%{
    // Diccionario para contar reservadas
    private Map<String, Integer> reservadas = new HashMap<>();
    private List<String> errores = new ArrayList<>();
    private List<String> tokens = new ArrayList<>();

    private void addReservada(String palabra) {
        reservadas.put(palabra, reservadas.getOrDefault(palabra, 0) + 1);
    }

    public void generarReporte(String rutaSalida) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaSalida))) {
            pw.println("===== TOKENS RECONOCIDOS =====");
            for (String t : tokens) {
                pw.println(t);
            }

            pw.println("\n===== CONTEO DE PALABRAS RESERVADAS =====");
            for (Map.Entry<String,Integer> e : reservadas.entrySet()) {
                pw.println(e.getKey() + " -> " + e.getValue());
            }

            pw.println("\n===== ERRORES LÉXICOS =====");
            if (errores.isEmpty()) {
                pw.println("No se encontraron errores.");
            } else {
                for (String err : errores) {
                    pw.println(err);
                }
            }
        }
    }
%}

DIGITO    = [0-9]
LETRA     = [a-zA-Z_]
ID        = {LETRA}({LETRA}|{DIGITO})*
INT_LIT   = {DIGITO}+
WS        = [ \t\r\n]+

%%

{WS}       { /* ignorar espacios en blanco */ }

"package"  { addReservada("package"); tokens.add("PACKAGE -> " + yytext()); }
"import"   { addReservada("import");  tokens.add("IMPORT -> " + yytext()); }
"func"     { addReservada("func");    tokens.add("FUNC -> " + yytext()); }

"="        { tokens.add("ASSIGN -> " + yytext()); }
"+"        { tokens.add("PLUS -> " + yytext()); }
"-"        { tokens.add("MINUS -> " + yytext()); }
"*"        { tokens.add("MULT -> " + yytext()); }
"/"        { tokens.add("DIV -> " + yytext()); }

"("        { tokens.add("LPAREN -> " + yytext()); }
")"        { tokens.add("RPAREN -> " + yytext()); }
"{"        { tokens.add("LBRACE -> " + yytext()); }
"}"        { tokens.add("RBRACE -> " + yytext()); }
";"        { tokens.add("SEMICOLON -> " + yytext()); }
"\""       { tokens.add("QUOTE -> " + yytext()); }

{ID}       { tokens.add("IDENTIFIER -> " + yytext()); }
{INT_LIT}  { tokens.add("INT_LITERAL -> " + yytext()); }

.          { errores.add("⚠ Error léxico: caracter no reconocido '" + yytext() + "'"); }

<<EOF>>    { return null; }
