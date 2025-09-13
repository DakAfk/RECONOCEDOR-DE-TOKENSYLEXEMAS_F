package Entrada;

import java.util.List;

public class FuenteCodigo {
    private final List<String> lineas;

    public FuenteCodigo(List<String> lineas) {
        this.lineas = lineas;
    }

    public int totalLineas() {
        return lineas.size();
    }

    public String obtenerLinea(int numero) {
        if (numero >= 0 && numero < lineas.size()) {
            return lineas.get(numero);
        }
        return null;
    }

    public void mostrarContenido() {
        for (int i = 0; i < lineas.size(); i++) {
            System.out.printf("Línea %d: %s%n", i + 1, lineas.get(i));
        }
    }
}