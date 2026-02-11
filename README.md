# AppJorge - Demo Android de múltiples vistas

Aplicación Android (Kotlin) preparada para abrir en **Android Studio**. Incluye en una sola pantalla:

- Toolbar (barra superior)
- Menú lateral (Navigation Drawer)
- Menú inferior (Bottom Navigation)
- Lista de tarjetas (RecyclerView + MaterialCardView)
- Botones de acción
- Mensajes de feedback (Toast)

## Requisitos

- Android Studio Iguana o superior
- SDK Android 34
- JDK 17

## Cómo abrir en Android Studio

1. Abre Android Studio.
2. Selecciona **Open** y elige esta carpeta (`/workspace/AppJorge`).
3. Espera a que termine el sync de Gradle.
4. Ejecuta la app en un emulador o dispositivo Android.

## Nota importante sobre archivos binarios en PR

Para evitar problemas al crear PR en plataformas que no aceptan binarios, **este repo no versiona** `gradle/wrapper/gradle-wrapper.jar`.

Si Android Studio o tu entorno lo solicita, puedes regenerarlo así:

```bash
gradle wrapper --gradle-version 8.7 --no-validate-url
```

> También puedes usar la opción de Android Studio para sincronizar/regenerar el wrapper cuando lo pida.

## Estructura principal

- `app/src/main/java/com/example/appjorge/MainActivity.kt`
- `app/src/main/res/layout/activity_main.xml`
- `app/src/main/res/layout/content_main.xml`
- `app/src/main/res/menu/menu_drawer.xml`
- `app/src/main/res/menu/menu_bottom.xml`

