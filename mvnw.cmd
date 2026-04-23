@echo off
setlocal

set MAVEN_VERSION=3.9.6
set MAVEN_DIR=%USERPROFILE%\.m2\maven-%MAVEN_VERSION%
set MVN_EXE=%MAVEN_DIR%\bin\mvn.cmd

if not exist "%MVN_EXE%" (
    echo Descargando Apache Maven %MAVEN_VERSION%...
    powershell -Command "Invoke-WebRequest -Uri 'https://archive.apache.org/dist/maven/maven-3/%MAVEN_VERSION%/binaries/apache-maven-%MAVEN_VERSION%-bin.zip' -OutFile '%USERPROFILE%\.m2\maven.zip'"
    powershell -Command "Expand-Archive -Path '%USERPROFILE%\.m2\maven.zip' -DestinationPath '%USERPROFILE%\.m2\' -Force"
    ren "%USERPROFILE%\.m2\apache-maven-%MAVEN_VERSION%" "maven-%MAVEN_VERSION%"
    del "%USERPROFILE%\.m2\maven.zip"
    echo Maven descargado correctamente.
)

"%MVN_EXE%" %*
endlocal
