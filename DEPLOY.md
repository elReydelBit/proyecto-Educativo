# Guía de despliegue en Railway

Railway es la plataforma recomendada para este proyecto. Detecta Spring Boot automáticamente, no tiene arranque en frío en el tier gratuito y el despliegue desde GitHub tarda menos de 3 minutos.

---

## Parte 1 — Subir el proyecto a GitHub

### Paso 1. Crear cuenta en GitHub

Ve a [github.com](https://github.com) y crea una cuenta si no tienes una.

### Paso 2. Instalar Git en Windows

Descarga el instalador desde [git-scm.com](https://git-scm.com/download/win) y ejecútalo con las opciones por defecto.

Verifica que quedó instalado:
```powershell
git --version
# Debe mostrar: git version 2.x.x
```

### Paso 3. Configurar Git con tus datos

Abre PowerShell y ejecuta (cambia los valores por los tuyos):
```powershell
git config --global user.name "Tu Nombre"
git config --global user.email "tu@email.com"
```

### Paso 4. Crear el repositorio en GitHub

1. Ve a [github.com/new](https://github.com/new)
2. Rellena:
   - **Repository name:** `java-educativo`
   - **Description:** `Plataforma interactiva para aprender Java desde cero`
   - **Visibility:** Public (necesario para el tier gratuito de Railway)
3. **NO** marques ninguna opción adicional (sin README, sin .gitignore)
4. Pulsa **Create repository**

GitHub te mostrará una página con comandos. Anota la URL, tiene este formato:
```
https://github.com/TU_USUARIO/java-educativo.git
```

### Paso 5. Subir el código desde tu máquina

Abre PowerShell en la carpeta del proyecto y ejecuta estos comandos uno a uno:

```powershell
cd "C:\Users\Administrador\Desktop\Claude_Projects\Proyecto en Java\proyecto-Educativo"

# Inicializar Git en la carpeta
git init

# Añadir todos los ficheros
git add .

# Primer commit
git commit -m "Version inicial - Java Educativo"

# Conectar con el repositorio de GitHub (cambia TU_USUARIO)
git remote add origin https://github.com/TU_USUARIO/java-educativo.git

# Subir el código
git push -u origin main
```

Si Git te pide credenciales, introduce tu usuario y contraseña de GitHub.  
Si falla la autenticación, GitHub usa **tokens personales** en lugar de contraseña:
1. Ve a GitHub → tu foto → Settings → Developer settings → Personal access tokens → Tokens (classic)
2. Pulsa **Generate new token**
3. Marca el permiso `repo` y genera el token
4. Usa ese token como contraseña cuando Git te la pida

### Paso 6. Verificar que subió correctamente

Ve a `https://github.com/TU_USUARIO/java-educativo` en el navegador. Debes ver todos los ficheros del proyecto.

---

## Parte 2 — Desplegar en Railway

### Paso 1. Crear cuenta en Railway

Ve a [railway.app](https://railway.app) y pulsa **Login**. Selecciona **Login with GitHub** — así Railway puede acceder a tus repositorios directamente.

### Paso 2. Crear un nuevo proyecto

1. En el dashboard de Railway pulsa **New Project**
2. Selecciona **Deploy from GitHub repo**
3. Si es la primera vez, Railway pedirá permiso para acceder a tus repositorios de GitHub. Pulsa **Configure GitHub App** y autoriza el acceso al repositorio `java-educativo`
4. Selecciona el repositorio `java-educativo` de la lista

### Paso 3. Configurar el despliegue

Railway detecta Spring Boot automáticamente. Aun así, necesitas añadir una variable de entorno para indicarle el puerto:

1. En tu proyecto de Railway, haz clic sobre el servicio creado
2. Ve a la pestaña **Variables**
3. Pulsa **New Variable** y añade:
   - **Name:** `PORT`
   - **Value:** `8080`
4. Pulsa **Add**

### Paso 4. Añadir el Nixpack correcto (JDK 17)

Railway usa Nixpacks para construir el proyecto. Por defecto puede usar una versión de Java diferente. Para forzar JDK 17:

1. En la pestaña **Settings** del servicio, busca **Build Command**
2. Déjalo vacío — Railway lo detecta solo desde el `pom.xml`
3. En **Start Command** escribe exactamente:
```
java -jar target/java-educativo-0.1.0-SNAPSHOT.jar
```

### Paso 5. Añadir el fichero de configuración de Railway (recomendado)

Crea un fichero `railway.toml` en la raíz del proyecto con este contenido:

```toml
[build]
builder = "nixpacks"

[deploy]
startCommand = "java -jar target/java-educativo-0.1.0-SNAPSHOT.jar"
healthcheckPath = "/"
healthcheckTimeout = 300
restartPolicyType = "on-failure"
```

Luego súbelo a GitHub:
```powershell
git add railway.toml
git commit -m "Añadir configuracion Railway"
git push
```

Railway detectará el cambio y redesplegará automáticamente.

### Paso 6. Esperar el primer despliegue

En la pestaña **Deployments** de Railway verás los logs en tiempo real. El proceso tarda entre 2 y 5 minutos la primera vez porque Maven descarga las dependencias.

Cuando veas en los logs:
```
Started JavaEducativoApplication in X.XXX seconds
```
el despliegue ha terminado correctamente.

### Paso 7. Obtener el dominio público

1. Ve a la pestaña **Settings** del servicio
2. En la sección **Networking**, pulsa **Generate Domain**
3. Railway generará un dominio del tipo: `java-educativo-production.up.railway.app`
4. Abre esa URL en el navegador — tu web ya está en internet

---

## Actualizaciones futuras

Cada vez que hagas cambios en el código y los subas a GitHub, Railway desplegará automáticamente la nueva versión:

```powershell
# Después de hacer cambios en el código:
git add .
git commit -m "Descripcion del cambio"
git push
```

Railway detecta el push y redesplega en 2-3 minutos sin intervención manual.

---

## Solución de problemas frecuentes

**El despliegue falla con error de compilación**
- Verifica que el código compila en local con `.\mvnw.cmd -DskipTests package`
- Revisa los logs en Railway → Deployments → el despliegue fallido

**La web tarda mucho en responder**
- El tier gratuito de Railway puede tener latencia en la primera petición
- Es normal que tarde 5-10 segundos la primera vez tras un período sin actividad

**Error 502 o página en blanco**
- Revisa que la variable `PORT=8080` está configurada en Railway
- Comprueba que el Start Command apunta al JAR correcto

**El editor de código no compila**
- El servidor necesita tener JDK disponible en Railway
- Railway incluye JDK por defecto con proyectos Maven/Gradle — no requiere configuración adicional
