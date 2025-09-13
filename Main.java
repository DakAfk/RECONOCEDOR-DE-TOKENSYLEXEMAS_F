package Analizador;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java Analizador.Main <archivo_entrada.go> <archivo_salida.txt>");
            return;
        }

        String rutaEntrada = args[0];
        String rutaSalida = args[1];

        try (FileReader fr = new FileReader(rutaEntrada)) {
            GoLexer lexer = new GoLexer(fr);

            while (lexer.yylex() != null) {
                // El análisis se va guardando dentro del lexer
            }

            lexer.generarReporte(rutaSalida);
            System.out.println("✅ Análisis completado. Reporte generado en: " + rutaSalida);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
