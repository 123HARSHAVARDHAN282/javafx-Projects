#!/bin/bash

JAVAFX_SDK="/home/harsha/programming/javafx-sdk-21.0.2"
SQLITE_JAR="/home/harsha/programming/sqlite-jdbc-master/sqlite-jdbc-3.44.1.0.jar"
SLF4J_API="/home/harsha/programming/sqlite-jdbc-master/slf4j-api-2.0.13.jar"
SLF4J_SIMPLE="/home/harsha/programming/sqlite-jdbc-master/slf4j-simple-2.0.13.jar"

if [ -z "$1" ]; then
  echo "Usage: ./runfx.sh <JavaFile.java>"
  exit 1
fi

FILENAME="$1"
BASENAME=$(basename "$FILENAME" .java)

CLASSPATH=".:$SQLITE_JAR:$SLF4J_API:$SLF4J_SIMPLE"

# Compile
javac --module-path "$JAVAFX_SDK/lib" --add-modules javafx.controls \
  -cp "$CLASSPATH" "$FILENAME"

if [ $? -ne 0 ]; then
  echo "Compilation failed."
  exit 1
fi

# Run
java --module-path "$JAVAFX_SDK/lib" --add-modules javafx.controls \
  -cp "$CLASSPATH" "$BASENAME"

