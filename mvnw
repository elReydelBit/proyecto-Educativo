#!/bin/sh
# Maven Wrapper Script
set -e
MAVEN_WRAPPER_JAR="$(dirname "$0")/.mvn/wrapper/maven-wrapper.jar"
MVNW_REPOURL="https://repo.maven.apache.org/maven2"

if [ -r "$MAVEN_WRAPPER_JAR" ]; then
    if command -v java >/dev/null 2>&1; then
        exec java -jar "$MAVEN_WRAPPER_JAR" "$@"
    fi
fi
# Fallback: use system maven
if command -v mvn >/dev/null 2>&1; then
    exec mvn "$@"
fi
echo "ERROR: Java or Maven not found." >&2; exit 1
