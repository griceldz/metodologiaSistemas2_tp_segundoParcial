
# TP - Patrón Template Method

## Descripción

Este proyecto implementa el patrón de diseño
Template Method en Java, utilizando como ejemplo
un sistema de combate de un videojuego de fantasía.

Se representan tres tipos de personajes:

- Guerrero
- Mago
- Arquero

## Patrón utilizado

Template Method (Método Plantilla).

Este patrón permite definir la estructura general
de un algoritmo en una clase abstracta, delegando
en las subclases la implementación de los pasos
específicos.

## Estructura del proyecto

src/
└── combate/
    ├── Arquero.java
    ├── Guerrero.java
    ├── Mago.java
    ├── Main.java
    └── Personaje.java

## Tecnologías

- Java
- Programación Orientada a Objetos
- Herencia
- Polimorfismo
- Patrón Template Method

## Ejecución

Compilar desde la carpeta principal:

javac -d out src/combate/*.java

Ejecutar:

java -cp out combate.Main

