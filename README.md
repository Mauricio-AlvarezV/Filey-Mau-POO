# Sistema de administracion de stands FILEY

Proyecto academico de Programacion Orientada a Objetos en Java. Permite registrar, consultar, listar, cambiar el estado y eliminar stands disponibles.

## Requisitos
- JDK 17 o superior.

## Estructura

```text
FILEY-Stands-POO/
├── src/
│   └── filey/
│       ├── Main.java
│       ├── datos/
│       │   ├── Editorial.java
│       │   ├── EstadoStand.java
│       │   ├── Stand.java
│       │   ├── StandRepository.java
│       │   └── StandRepositoryMemoria.java
│       └── negocio/
│           └── StandService.java
├── .gitignore
└── README.md
```

## Compilar y ejecutar en Linux

Desde la carpeta del proyecto:

```bash
mkdir -p out
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out filey.Main
```

## Compilar y ejecutar en Windows (PowerShell)

```powershell
New-Item -ItemType Directory -Force out | Out-Null
$archivos = Get-ChildItem -Path .\src -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac -encoding UTF-8 -d out $archivos
java -cp out filey.Main
```

## Funcionamiento
- Cada stand tiene identificador, ancho, largo, precio por metro cuadrado y estado.
- El area se calcula como ancho por largo.
- El precio total se calcula como area por precio por metro cuadrado.
- Los estados posibles son `DISPONIBLE`, `RESERVADO` y `VENDIDO`.
- La capa de negocio valida identificadores duplicados y operaciones no permitidas.
- Los datos se guardan en memoria; al cerrar el programa se pierden.

## Separacion por capas
- `datos`: entidades, enumeraciones y contrato/implementacion del repositorio.
- `negocio`: reglas y operaciones del sistema.
- `Main`: interaccion por consola.

Este proyecto es una implementacion independiente de referencia; no copia el codigo del repositorio consultado.
