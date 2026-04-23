# Java Educativo

Plataforma web interactiva para aprender Java desde cero. Incluye lecciones con código comentado, ejercicios progresivos en tres niveles y un editor con ejecución real en el navegador.

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-brightgreen)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange)](https://adoptium.net)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue)](LICENSE)

---

## Demo

> Desplegado en Railway — enlace disponible tras el primer despliegue.

---

## Capturas

| Página principal | Lección con editor |
|---|---|
| Lista de módulos y lecciones | Editor Monaco + ejecución real |

---

## Contenido del curso

| Módulo | Lecciones | Conceptos |
|--------|-----------|-----------|
| 1. Framework de trabajo | Estructura mínima · Variables | Clase, main, System.out.println, tipado estático |
| 2. Tipos de datos | Primitivos · String | int, double, boolean, char, métodos de String |
| 3. Control de flujo | if/else · Bucles | Condiciones, for, while, operadores lógicos |
| 4. Estructuras de datos | ArrayList · HashMap | Colecciones, genéricos, recorrido con bucles |
| 5. POO | Clases y objetos · Herencia | Constructor, this, extends, @Override, polimorfismo |

Cada lección incluye:
- Descripción pedagógica con el "por qué" de cada concepto
- Ejemplo ejecutable con comentarios inline en cada línea
- Nota de comparación para alumnos que vienen de Python u otros lenguajes
- 3 ejercicios progresivos: **leer y predecir → modificar → escribir desde cero**
- Editor Monaco (igual que VS Code) con ejecución real del código Java
- Enlaces a documentación oficial de Oracle y Baeldung

---

## Tecnologías

| Tecnología | Versión | Uso |
|---|---|---|
| Java | 17 (LTS) | Lenguaje del backend |
| Spring Boot | 3.2 | Framework web |
| Thymeleaf | 3.x | Motor de plantillas HTML |
| Monaco Editor | 0.44 | Editor de código en el navegador |
| Tone.js | 14.7 | Síntesis de audio (tema Star Wars) |
| Maven Wrapper | 3.9.6 | Build sin instalar Maven globalmente |

**Ejecución de código:** el servidor compila y ejecuta el Java del alumno directamente con el JDK del servidor, sin depender de APIs externas.

---

## Ejecutar en local

### Requisitos

- **JDK 17** instalado ([descargar en adoptium.net](https://adoptium.net))
- No hace falta instalar Maven (el proyecto incluye Maven Wrapper)

### Pasos

```powershell
# 1. Clonar el repositorio
git clone https://github.com/TU_USUARIO/java-educativo.git
cd java-educativo

# 2. Arrancar (la primera vez descarga dependencias ~2 minutos)
.\mvnw.cmd spring-boot:run

# En Mac/Linux usar:
# ./mvnw spring-boot:run
```

3. Abrir en el navegador: **http://localhost:8080**

### Verificar que JDK 17 está instalado

```powershell
java -version
# Debe mostrar: openjdk version "17.x.x"
```

Si no está instalado, descárgalo desde [adoptium.net](https://adoptium.net) y reinicia el terminal.

---

## Estructura del proyecto

```
java-educativo/
├── pom.xml                                    Maven + dependencias Spring Boot
├── mvnw / mvnw.cmd                            Maven Wrapper (no requiere Maven instalado)
├── .mvn/wrapper/maven-wrapper.properties      Versión de Maven a usar
└── src/main/
    ├── java/com/javaeducativo/
    │   ├── JavaEducativoApplication.java       Arranque de Spring Boot
    │   ├── controller/
    │   │   ├── WebController.java              Rutas web (/, /leccion/{id})
    │   │   └── RunController.java              API /api/run — compila y ejecuta Java
    │   ├── model/
    │   │   ├── JavaLesson.java                 Modelo de lección
    │   │   └── Exercise.java                   Modelo de ejercicio (3 niveles)
    │   └── service/
    │       └── LessonService.java              Contenido de los 5 módulos
    └── resources/
        ├── application.properties             Configuración del servidor
        ├── templates/
        │   ├── index.html                     Página principal (lista de módulos)
        │   └── leccion.html                   Página de lección con editor
        └── static/
            ├── css/main.css                   Tema oscuro profesional
            └── js/
                ├── editor.js                  Monaco Editor + llamada a /api/run
                └── starwars.js                Tema musical Star Wars (Tone.js)
```

---

## Despliegue en Railway

Ver la guía completa de despliegue en [DEPLOY.md](DEPLOY.md).

---

## Licencia

MIT — libre para usar, modificar y distribuir.

---

*Hecho con ❤️ por J. Francisco*
