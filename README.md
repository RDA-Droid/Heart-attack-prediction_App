SplashScreen.

### Version minima del SDK Android

MinSDk 21 MaxSdk 33

### Ejemplo

Ejemplo de campors para el apuntamiento de la APP
    
           new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sdkopen.start(
                        SplashScreen.this,
                        "demo",                    "ProyecName"
                        "db92efc69991",              "Apikery"
                        "http://127.0.0.1:5000",       "UrlBase Remplezar por el Local, Recomendable usar Ngrok"
                        new AppHandler() {
                            @Override
                            public void onSuccess(CloseResponse response, int code, String uuidDevice) {
                                finish();
                             }

                            @Override
                            public void onFailure(CloseResponse response) {
                                System.out.println("respuesta: fallo" );
                            }

                        });
            }
        }, 3000);
        finish();

    }

## Tener En cuenta que para la ejecucion debe correr el servicio de Prediccion https://github.com/RDA-Droid/Servicio_Heart-attack-prediction

[![Imagenes2.png](https://i.postimg.cc/cJCbjjZb/Imagenes2.png)](https://postimg.cc/67sc4M8r)
[![Imagenes3.png](https://i.postimg.cc/2jZPrPvp/Imagenes3.png)](https://postimg.cc/5jfPmKnp)
[![Imagenes4.png](https://i.postimg.cc/ZqQMhc5K/Imagenes4.png)](https://postimg.cc/yJFPm0Rw)


## Aspecto Apk:

[![iamgen5-1.jpg](https://i.postimg.cc/xCkBkZ4z/iamgen5-1.jpg)](https://postimg.cc/Fd4T8Tmr)
[![imagen6.jpg](https://i.postimg.cc/5NWD0nqX/imagen6.jpg)](https://postimg.cc/14Mv70dS)
[![imagen7.jpg](https://i.postimg.cc/VvnTgC1s/imagen7.jpg)](https://postimg.cc/kRMfXDBL)
[![imagen8.jpg](https://i.postimg.cc/DyQHbLBB/imagen8.jpg)](https://postimg.cc/LnXNcYd1)
[![imagen9.jpg](https://i.postimg.cc/0yc4VxgS/imagen9.jpg)](https://postimg.cc/NK2b03jG)


### Generar un APK para la Aplicación "App":

Abrir el Proyecto:
Abrir y tener instalado Android Studio y carga el proyecto de "App" si aún no se
ha hecho.

## Configurar Variante de Compilación:
Asegúrate de que estás trabajando con la variante de compilación adecuada (debug o
release) para tu situación.

## Configurar Opciones de Compilación (Opcional):
Si estás generando un APK de lanzamiento, abre el archivo build.gradle de tu módulo de app y
configura las opciones de compilación, como la versión del código y el nombre de la versión.
## Generar el APK:

Ve a la barra de menú en la parte superior, selecciona "Build" y luego "Build Bundle(s) /
APK(s)". Selecciona "Build APK(s)".

## Ubicación del APK Generado:
Una vez que la compilación esté completa, verás un mensaje en la parte inferior con la
ubicación del archivo APK generado. Puedes hacer clic en "Show in Explorer" para abrir la
carpeta del APK.

## Instalar el APK:
Conecta un dispositivo Android a tu computadora y asegúrate de que la depuración USB esté
habilitada. Arrastra y suelta el archivo APK en el dispositivo para instalarlo. O bien, puedes
utilizar el comando adb install desde la línea de comandos
