## Instrucciones de instalación y uso

### Módulo de lectura y preparación de código 

**Requisitos previos**  
- Java 11+ instalado y configurado en tu `PATH`.  
- IntelliJ IDEA (o tu editor favorito) para abrir y compilar el proyecto.  

**Pasos para ejecutar el módulo de lectura**  
1. Clona el repositorio:  
   ```bash
   git clone https://github.com/tuUsuario/ProyectoReconocedorTokens.git
   cd ProyectoReconocedorTokens
   
2 Coloca tus archivos .go en la carpeta src/recursos/}
3 Abre el proyecto en IntelliJ IDEA.
4 Ejecuta la clase app.Main:
     Haz clic derecho en app/Main.java → Run 'Main'
5 Cuando la consola pida la ruta, ingresa la ruta completa al archivo .go.
6 Verás en pantalla cada línea del archivo, numerada:
     Ingrese la ruta del archivo .go: C:\…\Prueba1.go
 Archivo leído correctamente. Contenido:
Línea 1: package main
Línea 2:
Línea 3: import "fmt"
…
//////////////

Parte 2: Módulo léxico
Descripción
Este módulo recibe como entrada un archivo fuente (por ejemplo, Prueba1.go), lo procesa con el scanner generado por JFlex y muestra en consola la lista de tokens reconocidos.
Estructura mínima del proyecto
ProyectoReconocedorTokens/
lib/jflex-full-1.9.1.jar
src/Analizador/
GoLexer.flex               ← especificación JFlex
AnalizadorFlex.java        ← generado por JFlex
AnalizadorLexico.java      ← clase con método main
src/modelo/
Token.java                 ← clase con constantes y toString()
ejemplos/
prueba.go                  ← archivo de prueba
Pasos para Parte 2
- Generar el scanner
Desde la raíz del proyecto:
java -jar lib/jflex-full-1.9.1.jar -d src/Analizador src/Analizador/GoLexer.flex
- Compilar las clases
- Crear carpeta de salida:
mkdir build
- Compilar todo en un solo comando:
javac -d build src/modelo/Token.java src/Analizador/AnalizadorFlex.java src/Analizador/AnalizadorLexico.java
- Ejecutar el analizador
java -cp build Analizador.AnalizadorLexico Recursos/Prueba1.go
Tokens reconocidos
PACKAGE, IMPORT, FUNC
ASSIGN (=), PLUS (+), MINUS (–), MULT (*), DIV (/), SEMIC (;)
LBRACE ({), RBRACE (}), LPAREN (()), RPAREN ()), COMMA (,), DOT (.)
STRING (literales de cadena), ID (identificadores), LITERAL (literales numéricas)
Reglas especiales
- Espacios, tabs y saltos de línea se ignoran.
- Existe una regla catch-all que captura cualquier símbolo no reconocido e imprime un mensaje de advertencia en stderr en lugar de abortar.
Con esto queda cubierta la parte de Persona 2: validación de archivo, generación de scanner, extracción e impresión de tokens.
