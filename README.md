# Analizador e intérprete Java con JFlex, CUP y Swing

Proyecto de Organización de Lenguajes y Compiladores 1 con especificaciones léxicas/sintácticas, clases de expresiones/instrucciones y una interfaz Swing para analizar programas y consultar resultados.

## Requisitos

JDK 23 y Apache Ant, según la configuración NetBeans incluida. Las bibliotecas CUP de lib/ son dependencias necesarias y se conservan versionadas.

## Ejecución

Los comandos parten de la raíz del repositorio, salvo donde se indica otra terminal.

```bash
cd OLC1_Proyecto1_202302220
ant jar
ant run
```

## Recorrido de demostración

Abrir un archivo de examples/ desde la interfaz y ejecutar el análisis. Consultar los manuales para la sintaxis del lenguaje y los reportes. Los archivos Lexer.jflex y Parser.cup están en src/olc1_proyecto1_202302220/analizador/.

## Organización

Carpetas de la entrega: [`OLC1_Proyecto1_202302220/`](OLC1_Proyecto1_202302220/), [`documentation/`](documentation/), [`examples/`](examples/), [`proyecto/`](proyecto/).

## Documentación

- [manualTecnico](documentation/manualTecnico.mkd)
- [manualUsuario](documentation/manualUsuario.mkd)
- [gramatica](documentation/gramatica.mkd)

## Alcance y límites

La compilación normal usa las fuentes Java del lexer/parser incluidas. Para modificar la gramática hace falta JFlex y CUP: seguir el procedimiento del manual y regenerar los archivos de forma consistente.

## Contexto y licencia

Trabajo académico o de aprendizaje conservado en el portafolio de [Enner Mendizabal](https://github.com/Ennero). Los créditos de los trabajos en grupo se conservan en sus entregas y manuales.

Consultar [LICENSE](LICENSE) para la licencia de la raíz. Las dependencias y los componentes con avisos o licencias propios conservan sus condiciones.
