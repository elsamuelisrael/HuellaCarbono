Reto | Programando una calculadora de huella de carbono en Android

Objetivo: Desarrollar una aplicación Android que ofrezca información sobre las afectaciones al medio ambiente y calcule la huella de carbono para, así, implementarla en aspectos cotidianos.

1. Genera un proyecto nuevo para aplicaciones Androidde este modo:
  - Proyecto Bottom Navigation Views Activity.
  - Genera la configuración para Teléfono y Tableta con nombre HuellaCarbono.

2. Utiliza la información relacionada a la huella de carbono para crear la ventana principal o home, para hacerlo:

	- Ubica el archivo fragment_home.xml vista diseño e inserta los elementos componibles arrastrando un TextView hacia la ventana.
	- Configura los elementos composables para presentar la información de huella de carbono.

3. Selecciona la información para crear una segunda ventana con la información de la calculadora de huella de carbono que incluya:

	- Huella de carbono en el entorno familiar.
	- Huella de carbono en el transporte.
	- Huella de carbono en el estilo de vida.

4. Desarrolla el programa de la aplicación en Android para las dos ventanas, para esto:

	- Configura los elementos composables para presentar la información de huella de carbono en vista diseño.
	- Configura los elementos composables para presentar la información de huella de carbono en vista código.
	- Configura la información relacionada con calculadora de huella de carbono en 2 ventanas:
		- Home, que contiene información de la huella de carbono en el archivo activity_main.xml en vista diseño.
		- label del menú de navegación, modificando las variables del menú de navegación en el archivo strings.xml.
	- Configura los elementos composables en el archivo fragment_dashboard.xml vista diseño, para hacerlo:
		- Inserta la etiqueta o TextView, arrastrandolos hacia el fragmento o fagment.
		- Inserta la caja de texto de tipo numérico o number, arrastrándolos hacia el fragmento o fagment.
		- Inserta los elementos componibles, arrastrándolos hacia el fragmento o fagment.
	-Configura los elementos composables en vista código, para esto:
		- Programa la etiqueta o TextView, arrastrándolos hacia el fragmento o fagment.
		- Programa la caja de texto de tipo numérico o number, arrastrándolos hacia el fragmento o fagment.
		- Utiliza el código para completar la configuración en vista diseño.
		- Utiliza el código para completar la configuración en vista código.

5. Define la navegación, para hacerlo:
	- Configura la actividad principal en el archivo MainActivity.kt.
	- Configuración en archivo activity_main.xml en vista diseño.
	- Configuración en archivo activity_main.xml en vista código.
	- En vista diseño del archivo mobile_navigation.xml.
	- En vista código del archivo mobile_navigation.xml.
