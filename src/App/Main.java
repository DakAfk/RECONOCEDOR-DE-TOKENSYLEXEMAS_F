package App;

import Entrada.ArchivoEntrada;
import Entrada.FuenteCodigo;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("📂 Ingrese la ruta del archivo .go: ");
        String ruta = sc.nextLine();

        List<String> lineas = ArchivoEntrada.leerArchivo(ruta);
        if (!lineas.isEmpty()) {
            FuenteCodigo fuente = new FuenteCodigo(lineas);
            System.out.println("✅ Archivo leído correctamente. Contenido:");
            fuente.mostrarContenido();
        } else {
            System.out.println("⚠️ No se pudo procesar el archivo.");
        }
    }
}