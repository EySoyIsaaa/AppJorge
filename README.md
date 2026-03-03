# AppJorge - Aplicación básica multitarea en Android Studio

Aplicación Android en Kotlin, completamente funcional, pensada para abrir y ejecutar en **Android Studio**.

## Funcionalidades

- Navegación principal con `MainActivity` + `BottomNavigation`.
- `InicioFragment` con demostración de **multitarea**:
  - Ejecuta dos tareas en paralelo (rápida y lenta) usando corrutinas.
  - Cada tarea actualiza su propia barra de progreso y estado.
- Uso de **Intent explícito** para abrir `DetailActivity`.
- `ListaFragment` con `RecyclerView` y 20 elementos generados dinámicamente.

## Requisitos

- Android Studio Iguana o superior
- SDK Android 34
- JDK 17

## Cómo ejecutar

1. Abre el proyecto en Android Studio.
2. Sincroniza Gradle.
3. Ejecuta en un emulador o dispositivo Android.

## Solución rápida de problemas de Gradle

- Este repositorio **no versiona binarios** del wrapper (`gradle-wrapper.jar`) para mantener compatibilidad en PRs.
- Si `./gradlew` falla por jar faltante, regenera el wrapper con: `gradle wrapper --gradle-version 8.7 --no-validate-url`.
- Si estás detrás de proxy corporativo, configura proxy en `~/.gradle/gradle.properties`.
- Si falla con *SDK location not found*, crea `local.properties` con `sdk.dir=/ruta/a/Android/Sdk` o configura `ANDROID_HOME`.
