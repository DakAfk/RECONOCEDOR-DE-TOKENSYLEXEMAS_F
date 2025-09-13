package Entrada;

import java.io.*;
import java.util.*;

public class ArchivoEntrada {

    public static List<String> leerArchivo(String ruta) {
        List<String> lineas = new ArrayList<>();

        File archivo = new File(ruta);
        if (!archivo.exists()) {
            System.out.println("❌ El archivo no existe.");
            return lineas;
        }

        if (!archivo.getName().endsWith(".go")) {
            System.out.println("⚠️ El archivo no tiene extensión .go");
            return lineas;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo: " + e.getMessage());
        }

        if (lineas.isEmpty()) {
            System.out.println("⚠️ El archivo está vacío.");
        }

        return lineas;
    }
}