package com.javaeducativo.service;

import com.javaeducativo.model.Exercise;
import com.javaeducativo.model.Exercise.Nivel;
import com.javaeducativo.model.JavaLesson;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LessonService {

    private final List<JavaLesson> lessons = new ArrayList<>();

    public LessonService() {
        buildModulo1();
        buildModulo2();
        buildModulo3();
        buildModulo4();
        buildModulo5();
    }

    // ════════════════════════════════════════════════════════════════════════
    // MÓDULO 1: Framework de trabajo en Java
    // ════════════════════════════════════════════════════════════════════════
    private void buildModulo1() {

        lessons.add(new JavaLesson(
            "m1-estructura",
            "Framework de trabajo en Java",
            "Estructura minima de un programa",
            "Cuando escribes codigo Java, no puedes simplemente poner instrucciones sueltas. " +
            "Java exige que todo el codigo este dentro de una CLASE, y que la ejecucion empiece " +
            "siempre por un metodo especial llamado MAIN.\n\n" +
            "Piensalo asi: la CLASE es el contenedor (como un sobre), y MAIN es la primera " +
            "instruccion que Java busca cuando arrancas el programa. Sin estos dos elementos, " +
            "Java no sabe ni por donde empezar.\n\n" +
            "En el ejemplo: 'public class HolaMundo' crea la clase. " +
            "'public static void main(String[] args)' es el punto de entrada. " +
            "'System.out.println(...)' imprime texto en pantalla y salta de linea.",
            "public class HolaMundo {                        // 1. Declara la clase\n" +
            "    public static void main(String[] args) {   // 2. Punto de entrada\n" +
            "        System.out.println(\"Hola, mundo\");    // 3. Imprime en pantalla\n" +
            "    }                                          // 4. Cierra el metodo\n" +
            "}                                             // 5. Cierra la clase",
            "Hola, mundo",
            "Si vienes de Python: en Python puedes escribir print('hola') directamente " +
            "en un fichero y ejecutarlo. En Java eso no es posible: SIEMPRE necesitas " +
            "una clase y un metodo main. Es mas verboso, pero hace que el codigo " +
            "sea mas explicito sobre su estructura.",
            List.of(
                "https://docs.oracle.com/en/java/javase/17/",
                "https://www.baeldung.com/java-main-method",
                "https://www.w3schools.com/java/java_syntax.asp"
            ),
            List.of(
                new Exercise(Nivel.LEER,
                    "Lee el programa de abajo linea a linea. " +
                    "Antes de ejecutarlo, escribe en papel o mentalmente que texto crees que aparecera. " +
                    "Luego pulsa Ejecutar para comprobar si acertaste.",
                    "public class Prueba {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        // Esta linea imprime el texto entre comillas\n" +
                    "        System.out.println(\"Java mola\");\n" +
                    "    }\n" +
                    "}",
                    "Java mola",
                    "Fijate en System.out.println(...): todo lo que escribas entre las comillas " +
                    "aparecera exactamente igual en pantalla."
                ),
                new Exercise(Nivel.MODIFICAR,
                    "El programa muestra 'Hola, mundo'. Tu tarea: cambiar ese texto para que " +
                    "muestre tu propio nombre.\n\n" +
                    "Busca la linea con System.out.println y cambia el texto entre las comillas. " +
                    "No toques nada mas. Pulsa Ejecutar cuando hayas hecho el cambio.",
                    "public class HolaMundo {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        System.out.println(\"Hola, mundo\"); // <-- cambia esto\n" +
                    "    }\n" +
                    "}",
                    "Hola, [tu nombre]",
                    "Solo tienes que cambiar el texto entre las comillas dobles. " +
                    "Por ejemplo: System.out.println(\"Hola, Ana\");"
                ),
                new Exercise(Nivel.ESCRIBIR,
                    "Crea un programa Java completo desde cero que muestre en pantalla:\n\n" +
                    "   Mi primer programa funciona\n\n" +
                    "Recuerda los tres ingredientes obligatorios:\n" +
                    "1. Una clase (puedes llamarla como quieras, sin espacios)\n" +
                    "2. El metodo main dentro de la clase\n" +
                    "3. System.out.println(...) con tu texto entre comillas",
                    null,
                    "Mi primer programa funciona",
                    "Estructura basica:\n" +
                    "public class MiClase {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        System.out.println(\"tu texto aqui\");\n" +
                    "    }\n" +
                    "}"
                )
            )
        ));

        lessons.add(new JavaLesson(
            "m1-variables",
            "Framework de trabajo en Java",
            "Variables: guardar y cambiar valores",
            "Una variable es una caja con nombre que guarda un valor. Puedes mirar lo que hay " +
            "dentro, cambiarlo, o usarlo en calculos.\n\n" +
            "En Java, antes de crear una variable DEBES decirle al compilador que tipo de " +
            "datos va a guardar. Esto se llama TIPADO ESTATICO y es una de las diferencias " +
            "principales con Python.\n\n" +
            "Los tipos mas comunes son:\n" +
            "- int    → numeros enteros (25, -3, 0)\n" +
            "- double → numeros decimales (19.99, 3.14)\n" +
            "- String → texto (siempre entre comillas dobles)\n" +
            "- boolean → verdadero o falso (true / false)\n\n" +
            "En el ejemplo veras como declarar, asignar y cambiar el valor de una variable.",
            "public class Variables {\n" +
            "    public static void main(String[] args) {\n" +
            "\n" +
            "        int edad = 25;          // tipo + nombre + valor inicial\n" +
            "        String nombre = \"Laura\"; // String siempre entre comillas dobles\n" +
            "\n" +
            "        System.out.println(nombre); // muestra: Laura\n" +
            "        System.out.println(edad);   // muestra: 25\n" +
            "\n" +
            "        edad = 26;             // cambiar el valor (sin repetir el tipo)\n" +
            "        System.out.println(edad);   // ahora muestra: 26\n" +
            "    }\n" +
            "}",
            "Laura\n25\n26",
            "En Python escribirias: edad = 25 (sin tipo). En Java: int edad = 25 (con tipo). " +
            "El motivo es que Java comprueba los tipos ANTES de ejecutar el programa, lo que " +
            "evita muchos errores en tiempo de ejecucion. Una vez declarada como int, " +
            "la variable edad no puede guardar texto.",
            List.of(
                "https://www.w3schools.com/java/java_variables.asp",
                "https://www.baeldung.com/java-primitives"
            ),
            List.of(
                new Exercise(Nivel.LEER,
                    "Lee el programa. Antes de ejecutarlo, predice:\n" +
                    "- ¿Que tres lineas apareceran en pantalla?\n" +
                    "- ¿Por que ciudad muestra 'Barcelona' y no 'Madrid'?\n\n" +
                    "Ejecuta para comprobar.",
                    "public class LeerVar {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        String ciudad = \"Madrid\";   // asignacion inicial\n" +
                    "        int n = 3;\n" +
                    "        ciudad = \"Barcelona\";       // sobreescribe el valor anterior\n" +
                    "        System.out.println(ciudad); // ¿que muestra?\n" +
                    "        System.out.println(n);\n" +
                    "        System.out.println(\"Fin\");\n" +
                    "    }\n" +
                    "}",
                    "Barcelona\n3\nFin",
                    "Cuando escribes ciudad = \"Barcelona\"; el valor anterior (Madrid) " +
                    "se pierde. La variable solo guarda el ultimo valor asignado."
                ),
                new Exercise(Nivel.MODIFICAR,
                    "Este programa tiene un ERROR tipico de principiante: se intenta usar " +
                    "la variable 'pais' ANTES de asignarle un valor.\n\n" +
                    "Java no permite eso y el programa no compilara. Tu tarea: mover " +
                    "la linea de asignacion para que este ANTES del println.\n\n" +
                    "Ejecuta para ver el error primero, luego corrigelo.",
                    "public class CorregirVar {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        String pais;              // declarada pero SIN valor\n" +
                    "        System.out.println(pais); // ERROR: pais no tiene valor aun\n" +
                    "        pais = \"Espana\";          // asignacion (llega demasiado tarde)\n" +
                    "    }\n" +
                    "}",
                    "Espana",
                    "Mueve la linea 'pais = \"Espana\";' para que este ANTES del println. " +
                    "O bien, combina declaracion y asignacion en una sola linea: " +
                    "String pais = \"Espana\";"
                ),
                new Exercise(Nivel.ESCRIBIR,
                    "Crea un programa que:\n" +
                    "1. Declare una variable String con tu nombre\n" +
                    "2. Declare una variable int con tu edad\n" +
                    "3. Muestre cada una en una linea distinta\n\n" +
                    "Cuando ejecutes, deberias ver tu nombre en la primera linea " +
                    "y tu edad en la segunda.",
                    null,
                    "",
                    "String nombre = \"TuNombre\";\n" +
                    "int edad = TuEdad;\n" +
                    "System.out.println(nombre);\n" +
                    "System.out.println(edad);"
                )
            )
        ));
    }

    // ════════════════════════════════════════════════════════════════════════
    // MÓDULO 2: Tipos de datos
    // ════════════════════════════════════════════════════════════════════════
    private void buildModulo2() {

        lessons.add(new JavaLesson(
            "m2-primitivos",
            "Tipos de datos",
            "Tipos primitivos: int, double, boolean y char",
            "Java distingue entre tipos PRIMITIVOS y objetos. Los primitivos son los " +
            "tipos mas basicos: guardan directamente el valor (no son objetos).\n\n" +
            "Los 4 que usaras constantemente:\n\n" +
            "  int     → enteros: -2147483648 a 2147483647. Uso: edades, contadores, indices.\n" +
            "  double  → decimales: con punto, no con coma. Uso: precios, medidas, porcentajes.\n" +
            "  boolean → solo true o false. Uso: banderas, condiciones, estados on/off.\n" +
            "  char    → UN solo caracter, entre comillas SIMPLES: 'A', 'z', '3'. " +
            "Uso: iniciales, codigos de un caracter.\n\n" +
            "Nota importante: String NO es un tipo primitivo, es una clase. " +
            "Por eso se escribe con mayuscula y tiene metodos. Lo veremos en la siguiente leccion.",
            "public class Primitivos {\n" +
            "    public static void main(String[] args) {\n" +
            "\n" +
            "        int     edad    = 25;    // entero: sin decimales ni comillas\n" +
            "        double  precio  = 19.99; // decimal: punto, no coma\n" +
            "        boolean activo  = true;  // solo true o false\n" +
            "        char    inicial = 'J';   // UN caracter entre comillas SIMPLES\n" +
            "\n" +
            "        System.out.println(edad);    // 25\n" +
            "        System.out.println(precio);  // 19.99\n" +
            "        System.out.println(activo);  // true\n" +
            "        System.out.println(inicial); // J\n" +
            "    }\n" +
            "}",
            "25\n19.99\ntrue\nJ",
            "En Python no existen los tipos primitivos: todo es un objeto. " +
            "En Java, int y double son primitivos (mas rapidos en memoria). " +
            "Si necesitas un entero con metodos (por ejemplo para convertirlo a String), " +
            "Java tiene versiones objeto: Integer, Double, Boolean, Character.",
            List.of(
                "https://www.baeldung.com/java-primitives",
                "https://www.programiz.com/java-programming/data-types",
                "https://www.w3schools.com/java/java_data_types.asp"
            ),
            List.of(
                new Exercise(Nivel.LEER,
                    "Lee el programa. Antes de ejecutarlo, predice:\n" +
                    "- ¿Que muestra la primera linea? Pista: suma un int y un double.\n" +
                    "- ¿Que muestra la segunda? Pista: es un boolean.\n\n" +
                    "Ejecuta para comprobar tu prediccion.",
                    "public class TiposLeer {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        int    x = 10;    // entero\n" +
                    "        double y = 3.5;   // decimal\n" +
                    "        boolean b = false;\n" +
                    "\n" +
                    "        // Cuando sumas int + double, Java devuelve double\n" +
                    "        System.out.println(x + y);\n" +
                    "        System.out.println(b);\n" +
                    "    }\n" +
                    "}",
                    "13.5\nfalse",
                    "En Java, cuando operas un int con un double, el resultado es siempre double. " +
                    "10 + 3.5 = 13.5 (no 13)."
                ),
                new Exercise(Nivel.MODIFICAR,
                    "El programa ya declara 'int edad' y 'boolean activo' y los muestra.\n\n" +
                    "Tu tarea: añadir una tercera variable de tipo CHAR con tu inicial " +
                    "(la primera letra de tu nombre) y mostrarla con un tercer println.\n\n" +
                    "Recuerda: char usa comillas SIMPLES, no dobles.",
                    "public class AnadirChar {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        int     edad   = 30;\n" +
                    "        boolean activo = true;\n" +
                    "\n" +
                    "        System.out.println(edad);\n" +
                    "        System.out.println(activo);\n" +
                    "        // Añade aqui tu variable char y su println\n" +
                    "    }\n" +
                    "}",
                    "",
                    "Escribe: char inicial = 'X';  (cambia X por tu inicial)\n" +
                    "Luego añade: System.out.println(inicial);"
                ),
                new Exercise(Nivel.ESCRIBIR,
                    "Crea un programa que declare y muestre 4 variables, una de cada tipo:\n\n" +
                    "- Un int con tu edad\n" +
                    "- Un double con tu altura en metros (ej: 1.75)\n" +
                    "- Un boolean que indique si te gusta Java (true o false)\n" +
                    "- Un char con la inicial de tu nombre\n\n" +
                    "Muestra cada una con su propio println.",
                    null,
                    "",
                    "int edad = ...;\n" +
                    "double altura = ...;\n" +
                    "boolean gustajava = ...;\n" +
                    "char inicial = '...';\n" +
                    "// Cuatro System.out.println, uno por variable"
                )
            )
        ));

        lessons.add(new JavaLesson(
            "m2-string",
            "Tipos de datos",
            "String: texto y sus metodos",
            "String es el tipo que usas para guardar texto. A diferencia de int o double, " +
            "String NO es un primitivo: es una CLASE. Eso significa que tiene metodos, " +
            "es decir, funciones propias que puedes llamar sobre el texto.\n\n" +
            "Para llamar a un metodo de String escribes:\n" +
            "   nombreVariable.nombreMetodo()\n\n" +
            "Los metodos mas utiles para empezar:\n\n" +
            "  .length()           → cuantos caracteres tiene el texto\n" +
            "  .toUpperCase()      → convierte todo a MAYUSCULAS\n" +
            "  .toLowerCase()      → convierte todo a minusculas\n" +
            "  .contains(\"texto\")  → true si contiene ese texto, false si no\n" +
            "  .replace(\"a\",\"b\")   → sustituye todas las ocurrencias de 'a' por 'b'\n" +
            "  .substring(0, 4)    → extrae una parte (desde indice 0 hasta 3)\n\n" +
            "Importante: los indices en Java empiezan en 0, no en 1.",
            "public class Strings {\n" +
            "    public static void main(String[] args) {\n" +
            "\n" +
            "        String nombre = \"Java Educativo\";\n" +
            "\n" +
            "        // .length() cuenta los caracteres (espacios incluidos)\n" +
            "        System.out.println(nombre.length());        // 14\n" +
            "\n" +
            "        // .toUpperCase() devuelve una copia en mayusculas\n" +
            "        System.out.println(nombre.toUpperCase());   // JAVA EDUCATIVO\n" +
            "\n" +
            "        // .contains() devuelve true o false\n" +
            "        System.out.println(nombre.contains(\"Java\")); // true\n" +
            "\n" +
            "        // El operador + concatena (une) cadenas\n" +
            "        System.out.println(\"Hola, \" + nombre);     // Hola, Java Educativo\n" +
            "    }\n" +
            "}",
            "14\nJAVA EDUCATIVO\ntrue\nHola, Java Educativo",
            "En Python tambien tienes metodos de cadena: len(s), s.upper(), 'texto' in s. " +
            "La diferencia de sintaxis es que en Python 'len' es una funcion separada (len(s)), " +
            "mientras que en Java es un metodo del objeto (s.length()). " +
            "El resultado es el mismo, la forma de escribirlo cambia.",
            List.of(
                "https://www.baeldung.com/java-string",
                "https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html",
                "https://www.w3schools.com/java/java_strings.asp"
            ),
            List.of(
                new Exercise(Nivel.LEER,
                    "Lee el programa. Para cada println, predice el resultado ANTES de ejecutar:\n\n" +
                    "- s.length()         → ¿cuantos caracteres tiene 'hola mundo'?\n" +
                    "- s.toUpperCase()    → ¿como queda en mayusculas?\n" +
                    "- s.replace(...)     → ¿que palabra sustituye a cual?\n\n" +
                    "Ejecuta para comprobar.",
                    "public class StringLeer {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        String s = \"hola mundo\"; // 10 caracteres (espacio incluido)\n" +
                    "\n" +
                    "        System.out.println(s.length());              // cuantos caracteres\n" +
                    "        System.out.println(s.toUpperCase());         // en mayusculas\n" +
                    "        System.out.println(s.replace(\"hola\", \"adios\")); // sustituir\n" +
                    "    }\n" +
                    "}",
                    "10\nHOLA MUNDO\nadios mundo",
                    "Cuenta los caracteres de 'hola mundo': h-o-l-a-ESPACIO-m-u-n-d-o = 10."
                ),
                new Exercise(Nivel.MODIFICAR,
                    "El programa muestra el texto en mayusculas. Tu tarea: añadir UNA linea " +
                    "que muestre solo los primeros 4 caracteres del texto.\n\n" +
                    "Para eso usaras el metodo substring(inicio, fin):\n" +
                    "- inicio: desde donde empiezas a extraer (0 = primer caracter)\n" +
                    "- fin: hasta donde llegas (NO incluido)\n\n" +
                    "Ejemplo: \"Hola\".substring(0, 2) devuelve \"Ho\"",
                    "public class SubStr {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        String texto = \"Programacion Java\";\n" +
                    "\n" +
                    "        System.out.println(texto.toUpperCase());\n" +
                    "        // Añade aqui la linea que muestre los primeros 4 caracteres\n" +
                    "    }\n" +
                    "}",
                    "PROGRAMACION JAVA\nProg",
                    "Añade: System.out.println(texto.substring(0, 4));\n" +
                    "Recuerda: substring(0, 4) extrae desde el indice 0 hasta el 3 (el 4 no se incluye)."
                ),
                new Exercise(Nivel.ESCRIBIR,
                    "Crea un programa con una variable String que contenga tu nombre. " +
                    "El programa debe mostrar tres lineas:\n\n" +
                    "1. La longitud de tu nombre (numero de caracteres)\n" +
                    "2. Tu nombre en mayusculas\n" +
                    "3. true o false segun si tu nombre contiene la letra 'a'\n\n" +
                    "Cada resultado en su propio println.",
                    null,
                    "",
                    "String nombre = \"TuNombre\";\n" +
                    "System.out.println(nombre.length());\n" +
                    "System.out.println(nombre.toUpperCase());\n" +
                    "System.out.println(nombre.contains(\"a\"));"
                )
            )
        ));
    }

    // ════════════════════════════════════════════════════════════════════════
    // MÓDULO 3: Control de flujo
    // Objetivo: que el alumno entienda como hacer que un programa tome
    // decisiones (if/else) y repita acciones (bucles for y while).
    // ════════════════════════════════════════════════════════════════════════
    private void buildModulo3() {

        // ── Lección 3.1 ──────────────────────────────────────────────────────
        lessons.add(new JavaLesson(
            "m3-if",
            "Control de flujo",
            "if / else: tomar decisiones",

            "Hasta ahora todos los programas ejecutaban las instrucciones en orden, " +
            "una tras otra, sin saltarse nada. Con if puedes hacer que algunas " +
            "instrucciones SOLO se ejecuten si se cumple una condicion.\n\n" +
            "La estructura basica es:\n\n" +
            "  if (condicion) {\n" +
            "      // se ejecuta si la condicion es TRUE\n" +
            "  } else {\n" +
            "      // se ejecuta si la condicion es FALSE\n" +
            "  }\n\n" +
            "Las condiciones mas usadas son:\n" +
            "  ==   igual a          (edad == 18)\n" +
            "  !=   distinto de      (nombre != \"\")\n" +
            "  >    mayor que        (nota > 5)\n" +
            "  >=   mayor o igual    (nota >= 5)\n" +
            "  <    menor que        (precio < 100)\n" +
            "  <=   menor o igual    (edad <= 17)\n\n" +
            "Si necesitas mas de dos casos, puedes encadenar con 'else if':\n" +
            "  if (nota >= 9)       → Sobresaliente\n" +
            "  else if (nota >= 7)  → Notable\n" +
            "  else if (nota >= 5)  → Aprobado\n" +
            "  else                 → Suspenso",

            // CÓDIGO CON COMENTARIOS: muestra if, else if y else
            "public class Decisiones {\n" +
            "    public static void main(String[] args) {\n" +
            "\n" +
            "        int edad = 20;\n" +
            "\n" +
            "        // La condicion entre parentesis devuelve true o false\n" +
            "        if (edad >= 18) {\n" +
            "            // Este bloque se ejecuta cuando la condicion es true\n" +
            "            System.out.println(\"Mayor de edad\");\n" +
            "        } else {\n" +
            "            // Este bloque se ejecuta cuando la condicion es false\n" +
            "            System.out.println(\"Menor de edad\");\n" +
            "        }\n" +
            "        // Como edad=20 y 20>=18 es true, muestra: Mayor de edad\n" +
            "    }\n" +
            "}",

            "Mayor de edad",

            "En Python el if no usa parentesis ni llaves: se basa en la indentacion. " +
            "En Java los parentesis en la condicion son OBLIGATORIOS y las llaves {} " +
            "delimitan cada bloque. El resultado es identico, solo cambia la sintaxis.",

            List.of(
                "https://www.baeldung.com/java-control-structures",
                "https://www.w3schools.com/java/java_conditions.asp",
                "https://www.programiz.com/java-programming/if-else-statement"
            ),

            List.of(
                new Exercise(Nivel.LEER,
                    "Lee el programa con atencion. La variable nota vale 4.\n\n" +
                    "Antes de ejecutar, decide: ¿la condicion 'nota >= 5' es true o false?\n" +
                    "Con ese resultado, ¿que bloque (if o else) se ejecuta?\n\n" +
                    "Ejecuta para verificar.",
                    "public class Nota {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        int nota = 4; // el valor que se evalua\n" +
                    "\n" +
                    "        if (nota >= 5) {\n" +
                    "            // ¿se ejecuta este bloque?\n" +
                    "            System.out.println(\"Aprobado\");\n" +
                    "        } else {\n" +
                    "            // ¿o este?\n" +
                    "            System.out.println(\"Suspenso\");\n" +
                    "        }\n" +
                    "    }\n" +
                    "}",
                    "Suspenso",
                    "4 >= 5 es FALSE, por lo tanto se ejecuta el bloque else. " +
                    "Prueba a cambiar nota a 7 y vuelve a ejecutar para ver la diferencia."
                ),
                new Exercise(Nivel.MODIFICAR,
                    "El programa solo distingue entre Aprobado y Suspenso. " +
                    "Pero con nota = 8 deberia mostrar 'Notable'.\n\n" +
                    "Tu tarea: añadir un 'else if' entre el if y el else para que:\n" +
                    "- nota >= 7 → muestre 'Notable'\n" +
                    "- nota >= 5 → siga mostrando 'Aprobado'\n" +
                    "- resto     → siga mostrando 'Suspenso'\n\n" +
                    "Ejecuta primero para ver que muestra ahora con nota=8, luego modifica.",
                    "public class Notas {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        int nota = 8;\n" +
                    "\n" +
                    "        if (nota >= 5) {\n" +
                    "            System.out.println(\"Aprobado\");\n" +
                    "        } else {\n" +
                    "            System.out.println(\"Suspenso\");\n" +
                    "        }\n" +
                    "        // El problema: nota=8 muestra 'Aprobado' cuando deberia ser 'Notable'\n" +
                    "        // Añade: else if (nota >= 7) ANTES del else actual\n" +
                    "    }\n" +
                    "}",
                    "Notable",
                    "Inserta esto entre el if y el else:\n" +
                    "} else if (nota >= 7) {\n" +
                    "    System.out.println(\"Notable\");\n" +
                    "Atento al orden: las condiciones se evaluan de arriba a abajo, " +
                    "la primera que sea true 'gana' y las demas se ignoran."
                ),
                new Exercise(Nivel.ESCRIBIR,
                    "Escribe un programa que clasifique una temperatura segun estas reglas:\n\n" +
                    "  temperatura < 10    → muestra 'Frio'\n" +
                    "  temperatura 10-25   → muestra 'Templado'\n" +
                    "  temperatura > 25    → muestra 'Calor'\n\n" +
                    "Declara una variable int temperatura con el valor que quieras y prueba " +
                    "distintos valores para verificar que las tres ramas funcionan.",
                    null,
                    "",
                    "int temperatura = 15;\n" +
                    "if (temperatura < 10) {\n" +
                    "    System.out.println(\"Frio\");\n" +
                    "} else if (temperatura <= 25) {\n" +
                    "    System.out.println(\"Templado\");\n" +
                    "} else {\n" +
                    "    System.out.println(\"Calor\");\n" +
                    "}"
                )
            )
        ));

        // ── Lección 3.2 ──────────────────────────────────────────────────────
        lessons.add(new JavaLesson(
            "m3-bucles",
            "Control de flujo",
            "Bucles: for y while",

            "Un bucle repite un bloque de codigo varias veces. Sin bucles, para imprimir " +
            "los numeros del 1 al 100 tendrias que escribir 100 lineas. Con un bucle: 3.\n\n" +
            "Java tiene dos bucles principales:\n\n" +
            "FOR — cuando sabes exactamente cuantas veces quieres repetir:\n" +
            "  for (inicio; condicion; actualizacion) {\n" +
            "      // codigo que se repite\n" +
            "  }\n" +
            "  Ejemplo: for (int i = 1; i <= 5; i++) repite 5 veces (i=1,2,3,4,5)\n\n" +
            "WHILE — cuando no sabes cuantas veces, pero sabes cuando parar:\n" +
            "  while (condicion) {\n" +
            "      // codigo que se repite MIENTRAS la condicion sea true\n" +
            "  }\n\n" +
            "Regla para elegir cual usar:\n" +
            "- ¿Sabes el numero de repeticiones? → for\n" +
            "- ¿Repites hasta que pase algo? → while",

            // CÓDIGO CON COMENTARIOS: explica cada parte del for y del while
            "public class Bucles {\n" +
            "    public static void main(String[] args) {\n" +
            "\n" +
            "        // FOR: tres partes separadas por punto y coma\n" +
            "        // int i=1  → valor inicial de i\n" +
            "        // i<=3     → condicion: si es true, ejecuta el bloque\n" +
            "        // i++      → incrementa i en 1 despues de cada vuelta\n" +
            "        for (int i = 1; i <= 3; i++) {\n" +
            "            System.out.println(\"Vuelta \" + i); // muestra: Vuelta 1, Vuelta 2, Vuelta 3\n" +
            "        }\n" +
            "\n" +
            "        // WHILE: repite mientras x sea mayor que 0\n" +
            "        int x = 10;\n" +
            "        while (x > 0) {\n" +
            "            x -= 3; // equivale a: x = x - 3\n" +
            "        }\n" +
            "        // Cuando x llega a -2 (10→7→4→1→-2), la condicion x>0 es false y para\n" +
            "        System.out.println(\"x final: \" + x); // -2\n" +
            "    }\n" +
            "}",

            "Vuelta 1\nVuelta 2\nVuelta 3\nx final: -2",

            "En Python: for i in range(1, 4) hace lo mismo que for(int i=1; i<=3; i++). " +
            "La diferencia es que Java es mas explicito: ves exactamente el valor inicial, " +
            "la condicion de parada y el incremento. El while de Java es identico al de Python.",

            List.of(
                "https://www.baeldung.com/java-loops",
                "https://www.programiz.com/java-programming/for-loop",
                "https://www.w3schools.com/java/java_while_loop.asp"
            ),

            List.of(
                new Exercise(Nivel.LEER,
                    "Este bucle no empieza en 1 ni incrementa de 1 en 1. Analiza:\n\n" +
                    "  int i = 0   → empieza en 0\n" +
                    "  i < 4       → para cuando i llega a 4\n" +
                    "  i += 2      → suma 2 en cada vuelta (0, 2, 4...)\n\n" +
                    "¿Cuantas veces se ejecuta el cuerpo del bucle?\n" +
                    "¿Que numeros imprime?\n\n" +
                    "Ejecuta para comprobar.",
                    "public class BucleLeer {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        // Analiza paso a paso:\n" +
                    "        // Vuelta 1: i=0, 0<4 true  → imprime 0, luego i=2\n" +
                    "        // Vuelta 2: i=2, 2<4 true  → imprime 2, luego i=4\n" +
                    "        // Vuelta 3: i=4, 4<4 false → el bucle para\n" +
                    "        for (int i = 0; i < 4; i += 2) {\n" +
                    "            System.out.println(i);\n" +
                    "        }\n" +
                    "    }\n" +
                    "}",
                    "0\n2",
                    "El bucle ejecuta el cuerpo 2 veces (cuando i=0 y cuando i=2). " +
                    "Cuando i llega a 4, la condicion i<4 es false y el bucle termina."
                ),
                new Exercise(Nivel.MODIFICAR,
                    "El bucle actual imprime 1, 2, 3, 4, 5 (ascendente). " +
                    "Tu tarea: modificarlo para que imprima 5, 4, 3, 2, 1 (descendente).\n\n" +
                    "Para ello necesitas cambiar las tres partes del for:\n" +
                    "- El valor inicial (empieza en 5, no en 1)\n" +
                    "- La condicion (hasta que i sea menor que 1)\n" +
                    "- La actualizacion (restar 1 en lugar de sumar)\n\n" +
                    "Ejecuta el original primero, luego modifica.",
                    "public class Descend {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        // Bucle ascendente: 1, 2, 3, 4, 5\n" +
                    "        for (int i = 1; i <= 5; i++) {\n" +
                    "            System.out.println(i);\n" +
                    "        }\n" +
                    "        // Cambia: inicio=5, condicion i>=1, actualizacion i--\n" +
                    "    }\n" +
                    "}",
                    "5\n4\n3\n2\n1",
                    "Solucion: for (int i = 5; i >= 1; i--)\n" +
                    "i-- es equivalente a i = i - 1 (decrementa en 1 cada vuelta)."
                ),
                new Exercise(Nivel.ESCRIBIR,
                    "Escribe un programa que calcule la suma de todos los numeros del 1 al 10 " +
                    "usando un bucle for.\n\n" +
                    "Estrategia:\n" +
                    "1. Declara una variable 'suma' con valor 0 (el acumulador)\n" +
                    "2. Con un bucle, en cada vuelta suma el valor de i a 'suma'\n" +
                    "3. Al terminar el bucle, muestra el resultado\n\n" +
                    "El resultado debe ser 55 (1+2+3+4+5+6+7+8+9+10).",
                    null,
                    "55",
                    "int suma = 0;\n" +
                    "for (int i = 1; i <= 10; i++) {\n" +
                    "    suma = suma + i; // o tambien: suma += i;\n" +
                    "}\n" +
                    "System.out.println(suma);"
                )
            )
        ));
    }

    // ════════════════════════════════════════════════════════════════════════
    // MÓDULO 4: Estructuras de datos
    // Objetivo: que el alumno entienda cuando y como usar ArrayList y HashMap
    // para almacenar multiples valores de forma organizada.
    // ════════════════════════════════════════════════════════════════════════
    private void buildModulo4() {

        // ── Lección 4.1 ──────────────────────────────────────────────────────
        lessons.add(new JavaLesson(
            "m4-arraylist",
            "Estructuras de datos",
            "ArrayList: listas que crecen y encogen",

            "Una variable normal solo guarda UN valor. Pero ¿que pasa si necesitas " +
            "guardar 100 nombres? No vas a declarar 100 variables.\n\n" +
            "ArrayList es una lista que puede guardar MUCHOS valores del mismo tipo, " +
            "y que crece o encoge automaticamente segun los añadas o elimines.\n\n" +
            "Para crear un ArrayList necesitas:\n" +
            "1. Importarlo: import java.util.ArrayList;\n" +
            "2. Declararlo indicando el tipo entre <>: ArrayList<String> nombres\n" +
            "3. Crearlo: new ArrayList<>()\n\n" +
            "Los metodos principales:\n" +
            "  .add(elemento)       → añade al final de la lista\n" +
            "  .get(indice)         → obtiene el elemento en esa posicion (empieza en 0)\n" +
            "  .remove(elemento)    → elimina la primera ocurrencia de ese elemento\n" +
            "  .size()              → cuantos elementos tiene la lista\n" +
            "  .contains(elemento)  → true si el elemento esta en la lista\n\n" +
            "Importante: el tipo entre <> debe ser una CLASE, no un primitivo. " +
            "Por eso se usa Integer (no int), Double (no double), etc.",

            // CÓDIGO CON COMENTARIOS: añadir, acceder, eliminar y mostrar la lista
            "import java.util.ArrayList; // necesario para usar ArrayList\n" +
            "\n" +
            "public class Listas {\n" +
            "    public static void main(String[] args) {\n" +
            "\n" +
            "        // Declara y crea una lista de Strings\n" +
            "        ArrayList<String> frutas = new ArrayList<>();\n" +
            "\n" +
            "        frutas.add(\"Manzana\"); // indice 0\n" +
            "        frutas.add(\"Banana\");  // indice 1\n" +
            "        frutas.add(\"Cereza\"); // indice 2\n" +
            "\n" +
            "        System.out.println(frutas.size());    // 3 (hay tres elementos)\n" +
            "        System.out.println(frutas.get(1));    // Banana (indice 1)\n" +
            "\n" +
            "        frutas.remove(\"Banana\"); // elimina Banana de la lista\n" +
            "        System.out.println(frutas); // [Manzana, Cereza]\n" +
            "    }\n" +
            "}",

            "3\nBanana\n[Manzana, Cereza]",

            "En Python usarias una list: frutas = [] y frutas.append('Manzana'). " +
            "En Java el equivalente es ArrayList<String> y frutas.add('Manzana'). " +
            "La diferencia clave es que en Java debes especificar el tipo de los elementos " +
            "entre <> — esto es lo que se llama GENERICOS y evita mezclar tipos por error.",

            List.of(
                "https://www.baeldung.com/java-arraylist",
                "https://www.w3schools.com/java/java_arraylist.asp",
                "https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html"
            ),

            List.of(
                new Exercise(Nivel.LEER,
                    "Lee el programa. Presta atencion a remove: en una lista de Integer, " +
                    "remove(Integer.valueOf(20)) elimina el ELEMENTO 20, no el elemento " +
                    "en el indice 20 (que es diferente).\n\n" +
                    "Antes de ejecutar, predice:\n" +
                    "- ¿Cuantos elementos quedan despues del remove?\n" +
                    "- ¿Que elemento esta en el indice 0 despues de eliminar el 20?\n\n" +
                    "Ejecuta para comprobar.",
                    "import java.util.ArrayList;\n" +
                    "public class ListaLeer {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        ArrayList<Integer> nums = new ArrayList<>();\n" +
                    "        nums.add(10); // indice 0\n" +
                    "        nums.add(20); // indice 1\n" +
                    "        nums.add(30); // indice 2\n" +
                    "\n" +
                    "        // remove con Integer.valueOf elimina el valor 20 (no el indice 20)\n" +
                    "        nums.remove(Integer.valueOf(20));\n" +
                    "\n" +
                    "        System.out.println(nums.size());  // ¿cuantos quedan?\n" +
                    "        System.out.println(nums.get(0));  // ¿que hay en indice 0?\n" +
                    "    }\n" +
                    "}",
                    "2\n10",
                    "Despues de eliminar el 20, la lista queda [10, 30]. " +
                    "El indice 0 ahora es 10 y el indice 1 es 30. " +
                    "La lista tiene 2 elementos."
                ),
                new Exercise(Nivel.MODIFICAR,
                    "La lista tiene 3 frutas pero el programa no las imprime. " +
                    "Tu tarea: añadir un bucle for-each que recorra la lista " +
                    "e imprima cada fruta en su propia linea.\n\n" +
                    "El bucle for-each en Java tiene esta forma:\n" +
                    "  for (TipoElemento variable : nombreLista) {\n" +
                    "      // usa la variable aqui\n" +
                    "  }\n\n" +
                    "Ejecuta primero para confirmar que no hay salida, luego añade el bucle.",
                    "import java.util.ArrayList;\n" +
                    "public class FrutasLoop {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        ArrayList<String> frutas = new ArrayList<>();\n" +
                    "        frutas.add(\"Kiwi\");\n" +
                    "        frutas.add(\"Mango\");\n" +
                    "        frutas.add(\"Pera\");\n" +
                    "        // Añade aqui el bucle for-each\n" +
                    "    }\n" +
                    "}",
                    "Kiwi\nMango\nPera",
                    "Añade despues del ultimo add:\n" +
                    "for (String f : frutas) {\n" +
                    "    System.out.println(f);\n" +
                    "}\n" +
                    "Este bucle recorre cada elemento de la lista y lo asigna a 'f' en cada vuelta."
                ),
                new Exercise(Nivel.ESCRIBIR,
                    "Crea una lista de 5 numeros enteros. Luego recorrela con un bucle " +
                    "y muestra SOLO los numeros pares.\n\n" +
                    "Para saber si un numero es par, usa el operador modulo:\n" +
                    "  numero % 2 == 0  → true si es par\n" +
                    "  numero % 2 != 0  → true si es impar\n\n" +
                    "El operador % devuelve el resto de la division. " +
                    "4 % 2 = 0 (par), 5 % 2 = 1 (impar).",
                    null,
                    "",
                    "ArrayList<Integer> numeros = new ArrayList<>();\n" +
                    "numeros.add(1);\n" +
                    "numeros.add(2);\n" +
                    "numeros.add(3);\n" +
                    "numeros.add(4);\n" +
                    "numeros.add(5);\n" +
                    "for (int n : numeros) {\n" +
                    "    if (n % 2 == 0) {\n" +
                    "        System.out.println(n);\n" +
                    "    }\n" +
                    "}"
                )
            )
        ));

        // ── Lección 4.2 ──────────────────────────────────────────────────────
        lessons.add(new JavaLesson(
            "m4-hashmap",
            "Estructuras de datos",
            "HashMap: guardar pares clave-valor",

            "ArrayList guarda elementos en orden por posicion (indice 0, 1, 2...). " +
            "Pero a veces necesitas buscar un valor por un NOMBRE, no por posicion.\n\n" +
            "HashMap es como un diccionario: cada entrada tiene una CLAVE y un VALOR. " +
            "Das la clave y obtienes el valor al instante, sin recorrer toda la lista.\n\n" +
            "Ejemplo del mundo real: un agenda de telefonos.\n" +
            "  Clave: nombre de la persona (\"Ana\")\n" +
            "  Valor: su numero de telefono (612345678)\n\n" +
            "Sintaxis: HashMap<TipoClave, TipoValor>\n\n" +
            "Los metodos principales:\n" +
            "  .put(clave, valor)      → añade o sobreescribe una entrada\n" +
            "  .get(clave)             → devuelve el valor para esa clave\n" +
            "  .containsKey(clave)     → true si la clave existe\n" +
            "  .remove(clave)          → elimina la entrada con esa clave\n" +
            "  .size()                 → cuantas entradas tiene el mapa\n" +
            "  .entrySet()             → para recorrer todas las entradas con un bucle\n\n" +
            "Atencion: HashMap NO garantiza el orden de las entradas. " +
            "Si necesitas orden, usa LinkedHashMap.",

            // CÓDIGO CON COMENTARIOS: crear, añadir, consultar y recorrer
            "import java.util.HashMap; // necesario para usar HashMap\n" +
            "\n" +
            "public class Mapa {\n" +
            "    public static void main(String[] args) {\n" +
            "\n" +
            "        // Clave: String (nombre), Valor: Integer (edad)\n" +
            "        HashMap<String, Integer> edades = new HashMap<>();\n" +
            "\n" +
            "        edades.put(\"Ana\",  30); // añadir entrada\n" +
            "        edades.put(\"Luis\", 25);\n" +
            "\n" +
            "        // .get() devuelve el valor para una clave dada\n" +
            "        System.out.println(edades.get(\"Ana\"));          // 30\n" +
            "\n" +
            "        // .containsKey() comprueba si la clave existe\n" +
            "        System.out.println(edades.containsKey(\"Luis\")); // true\n" +
            "\n" +
            "        System.out.println(edades.size());              // 2\n" +
            "    }\n" +
            "}",

            "30\ntrue\n2",

            "En Python el equivalente es un diccionario: edades = {} y edades['Ana'] = 30. " +
            "La sintaxis de Java es mas verbosa pero igual de potente. " +
            "Para acceder en Python: edades['Ana']. En Java: edades.get('Ana'). " +
            "La diferencia practica es que Java obliga a declarar los tipos de clave y valor.",

            List.of(
                "https://www.baeldung.com/java-hashmap",
                "https://www.w3schools.com/java/java_hashmap.asp",
                "https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashMap.html"
            ),

            List.of(
                new Exercise(Nivel.LEER,
                    "Lee el programa. Antes de ejecutar, predice:\n\n" +
                    "- paises.get(\"ES\") → ¿que valor tiene la clave \"ES\"?\n" +
                    "- paises.size()    → ¿cuantas entradas se añadieron?\n\n" +
                    "Ejecuta para comprobar.",
                    "import java.util.HashMap;\n" +
                    "public class MapaLeer {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        HashMap<String, String> paises = new HashMap<>();\n" +
                    "\n" +
                    "        // Clave: codigo del pais, Valor: nombre del pais\n" +
                    "        paises.put(\"ES\", \"Espana\");\n" +
                    "        paises.put(\"FR\", \"Francia\");\n" +
                    "\n" +
                    "        System.out.println(paises.get(\"ES\")); // busca por clave \"ES\"\n" +
                    "        System.out.println(paises.size());    // total de entradas\n" +
                    "    }\n" +
                    "}",
                    "Espana\n2",
                    "La clave \"ES\" tiene el valor \"Espana\", y hay 2 entradas en el mapa."
                ),
                new Exercise(Nivel.MODIFICAR,
                    "El mapa ya tiene dos entradas y un bucle que las imprime en formato 'clave: valor'.\n\n" +
                    "Tu tarea: añadir UNA linea que inserte una tercera entrada con tu nombre " +
                    "como clave y tu puntuacion favorita como valor.\n\n" +
                    "Ejecuta primero para ver las dos entradas actuales, luego añade la tuya.",
                    "import java.util.HashMap;\n" +
                    "public class MapaLoop {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        HashMap<String, Integer> puntos = new HashMap<>();\n" +
                    "        puntos.put(\"Ana\",  100);\n" +
                    "        puntos.put(\"Luis\", 80);\n" +
                    "        // Añade aqui una entrada mas con tu nombre y una puntuacion\n" +
                    "\n" +
                    "        // Este bucle recorre todas las entradas del mapa\n" +
                    "        for (var entrada : puntos.entrySet()) {\n" +
                    "            // entrada.getKey() → la clave\n" +
                    "            // entrada.getValue() → el valor\n" +
                    "            System.out.println(entrada.getKey() + \": \" + entrada.getValue());\n" +
                    "        }\n" +
                    "    }\n" +
                    "}",
                    "",
                    "Añade antes del bucle:\n" +
                    "puntos.put(\"TuNombre\", 95);\n" +
                    "Sustituye TuNombre por tu nombre real y 95 por la puntuacion que quieras."
                ),
                new Exercise(Nivel.ESCRIBIR,
                    "Crea un HashMap con 3 paises y sus capitales:\n\n" +
                    "  Espana    → Madrid\n" +
                    "  Francia   → Paris\n" +
                    "  Alemania  → Berlin\n\n" +
                    "Luego recorre el mapa con un bucle y muestra cada par en el formato:\n" +
                    "  Capital de [pais]: [capital]",
                    null,
                    "",
                    "HashMap<String, String> capitales = new HashMap<>();\n" +
                    "capitales.put(\"Espana\",   \"Madrid\");\n" +
                    "capitales.put(\"Francia\",  \"Paris\");\n" +
                    "capitales.put(\"Alemania\", \"Berlin\");\n" +
                    "for (var e : capitales.entrySet()) {\n" +
                    "    System.out.println(\"Capital de \" + e.getKey() + \": \" + e.getValue());\n" +
                    "}"
                )
            )
        ));
    }

    // ════════════════════════════════════════════════════════════════════════
    // MÓDULO 5: POO — Programacion orientada a objetos
    // Objetivo: que el alumno entienda que es una clase, como crear objetos,
    // y el concepto basico de herencia.
    // Nota tecnica: los ejercicios usan clases internas estaticas (static class)
    // porque Java solo permite una clase public por fichero. Es la forma
    // correcta de tener varias clases en un solo programa ejecutable.
    // ════════════════════════════════════════════════════════════════════════
    private void buildModulo5() {

        // ── Lección 5.1 ──────────────────────────────────────────────────────
        lessons.add(new JavaLesson(
            "m5-clases",
            "POO — Programacion orientada a objetos",
            "Clases y objetos: el molde y la instancia",

            "Hasta ahora hemos usado tipos simples (int, String) y colecciones. " +
            "La Programacion Orientada a Objetos (POO) nos permite crear nuestros " +
            "PROPIOS tipos que agrupan datos y comportamiento.\n\n" +
            "Analogia: una clase es como el PLANO de una casa. El objeto es la casa " +
            "concreta que se construye a partir de ese plano. Puedes construir " +
            "muchas casas (objetos) a partir del mismo plano (clase).\n\n" +
            "Una clase tiene:\n" +
            "  CAMPOS (atributos): variables que pertenecen a la clase (marca, anio)\n" +
            "  CONSTRUCTOR: metodo especial que se llama al crear un objeto (new Coche(...))\n" +
            "  METODOS: acciones que puede realizar el objeto (describir())\n\n" +
            "Para crear un objeto usas 'new':\n" +
            "  Coche miCoche = new Coche(\"Toyota\", 2020);\n\n" +
            "Dentro del constructor, 'this' se refiere al objeto que se esta creando:\n" +
            "  this.marca = marca; // asigna el parametro 'marca' al campo 'marca' del objeto",

            // CÓDIGO CON COMENTARIOS: clase completa con campos, constructor y metodo
            "public class Coche {\n" +
            "\n" +
            "    // CAMPOS: cada objeto Coche tendra su propia marca y anio\n" +
            "    String marca;\n" +
            "    int    anio;\n" +
            "\n" +
            "    // CONSTRUCTOR: mismo nombre que la clase, sin tipo de retorno\n" +
            "    // Se llama automaticamente al hacer 'new Coche(...)'\n" +
            "    public Coche(String marca, int anio) {\n" +
            "        this.marca = marca; // 'this.marca' = campo del objeto\n" +
            "        this.anio  = anio;  // 'marca' solo = parametro recibido\n" +
            "    }\n" +
            "\n" +
            "    // METODO: accion que puede realizar un objeto de tipo Coche\n" +
            "    public void describir() {\n" +
            "        System.out.println(marca + \" (\" + anio + \")\");\n" +
            "    }\n" +
            "\n" +
            "    public static void main(String[] args) {\n" +
            "        Coche c1 = new Coche(\"Toyota\", 2020); // crea un objeto\n" +
            "        Coche c2 = new Coche(\"Honda\",  2018); // crea otro objeto\n" +
            "\n" +
            "        c1.describir(); // llama al metodo sobre c1\n" +
            "        c2.describir(); // llama al metodo sobre c2\n" +
            "    }\n" +
            "}",

            "Toyota (2020)\nHonda (2018)",

            "En Python: class Coche: def __init__(self, marca, anio). " +
            "En Java el constructor tiene el mismo nombre que la clase y no hay 'self': " +
            "se usa 'this' en su lugar. La logica es identica, solo cambia la sintaxis.",

            List.of(
                "https://www.baeldung.com/java-oop",
                "https://docs.oracle.com/javase/tutorial/java/concepts/",
                "https://www.w3schools.com/java/java_classes.asp"
            ),

            List.of(
                new Exercise(Nivel.LEER,
                    "Lee el programa. Identifica:\n\n" +
                    "- ¿Cuantos objetos Persona se crean?\n" +
                    "- ¿Que campos tiene cada objeto?\n" +
                    "- ¿Que muestra el programa?\n\n" +
                    "Nota: este programa usa 'static class Persona' dentro de Main. " +
                    "Eso permite tener dos clases en un solo fichero. " +
                    "El comportamiento es exactamente el mismo que si fueran dos ficheros separados.\n\n" +
                    "Ejecuta para verificar.",
                    "public class Main {\n" +
                    "\n" +
                    "    // Clase interna: Persona con dos campos y un constructor\n" +
                    "    static class Persona {\n" +
                    "        String nombre; // campo nombre\n" +
                    "        int    edad;   // campo edad\n" +
                    "\n" +
                    "        // Constructor: recibe nombre y edad, los guarda en los campos\n" +
                    "        Persona(String nombre, int edad) {\n" +
                    "            this.nombre = nombre;\n" +
                    "            this.edad   = edad;\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Persona p = new Persona(\"Ana\", 30); // crea UN objeto\n" +
                    "        System.out.println(p.nombre); // accede al campo nombre\n" +
                    "        System.out.println(p.edad);   // accede al campo edad\n" +
                    "    }\n" +
                    "}",
                    "Ana\n30",
                    "Se crea un solo objeto Persona con nombre='Ana' y edad=30. " +
                    "p.nombre accede al campo 'nombre' de ese objeto, " +
                    "y p.edad accede al campo 'edad'."
                ),
                new Exercise(Nivel.MODIFICAR,
                    "La clase Persona tiene un constructor pero ningun metodo. " +
                    "Tu tarea: añadir un metodo llamado 'saludar' que imprima:\n\n" +
                    "  Hola, soy [nombre]\n\n" +
                    "Pasos:\n" +
                    "1. Añade el metodo dentro de la clase, antes del main\n" +
                    "2. Llama al metodo desde main con p.saludar()\n\n" +
                    "Los metodos que no devuelven nada se declaran con 'void'.",
                    "public class Persona {\n" +
                    "    String nombre;\n" +
                    "\n" +
                    "    public Persona(String nombre) {\n" +
                    "        this.nombre = nombre;\n" +
                    "    }\n" +
                    "\n" +
                    "    // Añade aqui el metodo saludar()\n" +
                    "    // public void saludar() { ... }\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Persona p = new Persona(\"Luis\");\n" +
                    "        // Añade aqui la llamada: p.saludar();\n" +
                    "    }\n" +
                    "}",
                    "Hola, soy Luis",
                    "Añade antes de main:\n" +
                    "public void saludar() {\n" +
                    "    System.out.println(\"Hola, soy \" + nombre);\n" +
                    "}\n" +
                    "Luego en main añade: p.saludar();"
                ),
                new Exercise(Nivel.ESCRIBIR,
                    "Crea una clase Producto con:\n\n" +
                    "  CAMPOS:      String nombre  y  double precio\n" +
                    "  CONSTRUCTOR: que reciba nombre y precio\n" +
                    "  METODO:      mostrarInfo() que imprima:\n" +
                    "               Producto: [nombre] - Precio: [precio]\n\n" +
                    "En el main, crea 2 objetos Producto diferentes y llama a " +
                    "mostrarInfo() sobre cada uno.",
                    null,
                    "",
                    "public class Producto {\n" +
                    "    String nombre;\n" +
                    "    double precio;\n" +
                    "\n" +
                    "    public Producto(String nombre, double precio) {\n" +
                    "        this.nombre = nombre;\n" +
                    "        this.precio = precio;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void mostrarInfo() {\n" +
                    "        System.out.println(\"Producto: \" + nombre + \" - Precio: \" + precio);\n" +
                    "    }\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Producto p1 = new Producto(\"Teclado\", 49.99);\n" +
                    "        Producto p2 = new Producto(\"Raton\",   19.99);\n" +
                    "        p1.mostrarInfo();\n" +
                    "        p2.mostrarInfo();\n" +
                    "    }\n" +
                    "}"
                )
            )
        ));

        // ── Lección 5.2 ──────────────────────────────────────────────────────
        String herenciaLeer =
            "public class Main {\n" +
            "\n" +
            "    // Clase PADRE: tiene el metodo mensaje()\n" +
            "    static class Base {\n" +
            "        public void mensaje() {\n" +
            "            System.out.println(\"Base\");\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    // Clase HIJA: hereda de Base y SOBREESCRIBE mensaje()\n" +
            "    // @Override indica que este metodo sustituye al del padre\n" +
            "    static class Hija extends Base {\n" +
            "        @Override\n" +
            "        public void mensaje() {\n" +
            "            System.out.println(\"Hija\");\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    public static void main(String[] args) {\n" +
            "        // La variable es de tipo Base, pero el objeto es de tipo Hija\n" +
            "        // Java ejecuta el metodo del objeto REAL (Hija), no del tipo declarado\n" +
            "        Base b = new Hija();\n" +
            "        b.mensaje(); // ¿que metodo se llama?\n" +
            "    }\n" +
            "}";

        String herenciaModificar =
            "public class Main {\n" +
            "\n" +
            "    // Clase padre\n" +
            "    static class Animal {\n" +
            "        String nombre;\n" +
            "        Animal(String nombre) { this.nombre = nombre; }\n" +
            "        public void hablar() {\n" +
            "            System.out.println(nombre + \" dice: ...\");\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    // Añade aqui la clase Gato que extienda Animal:\n" +
            "    // static class Gato extends Animal {\n" +
            "    //     Gato(String nombre) { super(nombre); } // llama al constructor del padre\n" +
            "    //     @Override\n" +
            "    //     public void hablar() { ... }\n" +
            "    // }\n" +
            "\n" +
            "    public static void main(String[] args) {\n" +
            "        Animal a = new Animal(\"Generico\");\n" +
            "        a.hablar();\n" +
            "        // Añade: Animal g = new Gato(\"Misi\"); g.hablar();\n" +
            "    }\n" +
            "}";

        lessons.add(new JavaLesson(
            "m5-herencia",
            "POO — Programacion orientada a objetos",
            "Herencia: reutilizar y especializar clases",

            "La herencia permite crear una clase NUEVA basada en una ya existente. " +
            "La clase nueva (hija) hereda automaticamente todos los campos y metodos " +
            "de la clase original (padre), y puede añadir los suyos propios " +
            "o modificar los heredados.\n\n" +
            "Analogia: Animal es el padre. Perro y Gato son hijos. " +
            "Todos los animales pueden 'hablar', pero cada especie lo hace diferente.\n\n" +
            "Para heredar se usa 'extends':\n" +
            "  class Perro extends Animal { ... }\n\n" +
            "Para llamar al constructor del padre se usa 'super':\n" +
            "  Perro(String nombre) { super(nombre); }\n\n" +
            "Para sobreescribir un metodo del padre se usa '@Override':\n" +
            "  @Override\n" +
            "  public void hablar() { System.out.println(nombre + \" dice: Guau\"); }\n\n" +
            "Concepto clave — POLIMORFISMO: puedes guardar un objeto Perro en una " +
            "variable de tipo Animal. Cuando llamas a hablar(), Java ejecuta la " +
            "version del OBJETO REAL (Perro), no la del tipo declarado (Animal).",

            // CÓDIGO CON COMENTARIOS: padre, hijo con override, y polimorfismo
            "public class Main {\n" +
            "\n" +
            "    // Clase PADRE: comportamiento generico\n" +
            "    static class Animal {\n" +
            "        String nombre;\n" +
            "        Animal(String nombre) { this.nombre = nombre; }\n" +
            "\n" +
            "        public void hablar() {\n" +
            "            System.out.println(nombre + \" dice: ...\"); // version generica\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    // Clase HIJA: hereda Animal y sobreescribe hablar()\n" +
            "    static class Perro extends Animal {\n" +
            "        Perro(String nombre) {\n" +
            "            super(nombre); // llama al constructor de Animal\n" +
            "        }\n" +
            "\n" +
            "        @Override // indica que sobreescribe el metodo del padre\n" +
            "        public void hablar() {\n" +
            "            System.out.println(nombre + \" dice: Guau\"); // version especializada\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    public static void main(String[] args) {\n" +
            "        // Polimorfismo: variable Animal, objeto Perro\n" +
            "        Animal a = new Perro(\"Rex\");\n" +
            "        a.hablar(); // ejecuta hablar() de Perro, no de Animal\n" +
            "    }\n" +
            "}",

            "Rex dice: Guau",

            "En Python: class Perro(Animal): def hablar(self): print(...). " +
            "En Java: class Perro extends Animal { @Override public void hablar() { ... } }. " +
            "La logica es la misma: la clase hija sobreescribe el metodo del padre. " +
            "La anotacion @Override no es obligatoria pero es buena practica: " +
            "si el nombre del metodo tiene una errata, el compilador te avisa.",

            List.of(
                "https://www.baeldung.com/java-inheritance",
                "https://www.programiz.com/java-programming/inheritance",
                "https://www.w3schools.com/java/java_inheritance.asp"
            ),

            List.of(
                new Exercise(Nivel.LEER,
                    "Este programa tiene una clase Base y una clase Hija. " +
                    "La Hija sobreescribe el metodo mensaje().\n\n" +
                    "La pregunta clave: la variable 'b' es de tipo Base, " +
                    "pero el objeto creado es 'new Hija()'.\n\n" +
                    "¿Que version de mensaje() se ejecuta: la de Base o la de Hija?\n\n" +
                    "Piensalo antes de ejecutar. El concepto que demuestra se llama POLIMORFISMO.",
                    herenciaLeer,
                    "Hija",
                    "Java siempre ejecuta el metodo del OBJETO REAL, no del tipo de la variable. " +
                    "Aunque 'b' es de tipo Base, el objeto creado es Hija, " +
                    "por eso se ejecuta el mensaje() de Hija. " +
                    "Esto es el polimorfismo: mismo tipo de variable, comportamiento diferente segun el objeto."
                ),
                new Exercise(Nivel.MODIFICAR,
                    "La clase Animal ya existe con su metodo hablar(). " +
                    "Tu tarea: añadir una clase Gato que:\n\n" +
                    "1. Extienda Animal (hereda nombre y hablar())\n" +
                    "2. Tenga un constructor que llame a super(nombre)\n" +
                    "3. Sobreescriba hablar() para que diga '[nombre] dice: Miau'\n" +
                    "4. En main, crear un Gato llamado 'Misi' y llamar a hablar()\n\n" +
                    "Ejecuta primero para ver el comportamiento del Animal generico, " +
                    "luego añade el Gato.",
                    herenciaModificar,
                    "Generico dice: ...\nMisi dice: Miau",
                    "Añade despues de la clase Animal:\n" +
                    "static class Gato extends Animal {\n" +
                    "    Gato(String nombre) { super(nombre); }\n" +
                    "    @Override\n" +
                    "    public void hablar() {\n" +
                    "        System.out.println(nombre + \" dice: Miau\");\n" +
                    "    }\n" +
                    "}\n" +
                    "Y en main: Animal g = new Gato(\"Misi\"); g.hablar();"
                ),
                new Exercise(Nivel.ESCRIBIR,
                    "Crea una jerarquia de clases:\n\n" +
                    "  Vehiculo (padre):\n" +
                    "    - campo: String tipo\n" +
                    "    - constructor: Vehiculo(String tipo)\n" +
                    "    - metodo: mover() que imprime '[tipo] se mueve'\n\n" +
                    "  Coche (hijo de Vehiculo):\n" +
                    "    - sobreescribe mover() para imprimir 'El coche rueda por la carretera'\n\n" +
                    "  Moto (hijo de Vehiculo):\n" +
                    "    - sobreescribe mover() para imprimir 'La moto zigzaguea entre coches'\n\n" +
                    "En main: crea un Coche y una Moto, llama a mover() sobre cada uno.\n\n" +
                    "Recuerda usar 'static class' para cada clase dentro de Main.",
                    null,
                    "",
                    "static class Vehiculo {\n" +
                    "    String tipo;\n" +
                    "    Vehiculo(String tipo) { this.tipo = tipo; }\n" +
                    "    public void mover() { System.out.println(tipo + \" se mueve\"); }\n" +
                    "}\n" +
                    "static class Coche extends Vehiculo {\n" +
                    "    Coche() { super(\"Coche\"); }\n" +
                    "    @Override\n" +
                    "    public void mover() { System.out.println(\"El coche rueda por la carretera\"); }\n" +
                    "}\n" +
                    "static class Moto extends Vehiculo {\n" +
                    "    Moto() { super(\"Moto\"); }\n" +
                    "    @Override\n" +
                    "    public void mover() { System.out.println(\"La moto zigzaguea entre coches\"); }\n" +
                    "}"
                )
            )
        ));
    }

    public List<JavaLesson> list() { return lessons; }

    public Optional<JavaLesson> findById(String id) {
        return lessons.stream().filter(l -> l.getId().equals(id)).findFirst();
    }

    public Map<String, List<JavaLesson>> groupByModulo() {
        Map<String, List<JavaLesson>> mapa = new LinkedHashMap<>();
        for (JavaLesson l : lessons) {
            mapa.computeIfAbsent(l.getModulo(), k -> new ArrayList<>()).add(l);
        }
        return mapa;
    }
}
