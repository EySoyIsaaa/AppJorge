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

