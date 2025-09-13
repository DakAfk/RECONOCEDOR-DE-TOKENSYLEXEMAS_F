package Analizador;

import java.io.FileReader;
import Modelo.Token;

public class AnalizadorLexico {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Uso: java Analizador.AnalizadorLexico <archivo.go>");
            return;
        }

        FileReader fr = new FileReader(args[0]);
        AnalizadorFlex lexer = new AnalizadorFlex(fr);

        Token token;
        while ((token = lexer.yylex()) != null) {
            System.out.println(token);
        }
    }
}
