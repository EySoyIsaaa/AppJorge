# AppJorge - Demo Android con Intents, Fragments y Listas

Aplicación Android (Kotlin) completamente funcional, preparada para abrir en **Android Studio**.

## Qué incluye

- `MainActivity` como pantalla principal.
- Navegación con **Fragments**:
  - `InicioFragment`
  - `ListaFragment`
- Uso de **Intent explícito** para abrir `DetailActivity` desde:
  - Botón del `InicioFragment`
  - Click en elementos de la lista del `ListaFragment`
- **Generación dinámica de listas** (20 elementos) con `RecyclerView`.

> No incluye funcionalidad de "Hola Mundo".

## Requisitos

- Android Studio Iguana o superior
- SDK Android 34
- JDK 17

## Abrir en Android Studio (macOS)

```bash
cd /ruta/a/AppJorge
open -a "Android Studio" .
```

Luego sincroniza Gradle y ejecuta en emulador/dispositivo.

## Nota sobre binarios en PR

Este repo no versiona `gradle/wrapper/gradle-wrapper.jar` para evitar errores de PR por archivos binarios.

Si tu entorno lo necesita, regenera el wrapper con:

```bash
gradle wrapper --gradle-version 8.7 --no-validate-url
```
