# Seccion_01_lab
Laboratorio 1 Android - MyForm App

Objetivo
--------
Crear una app con icono (siempre visible en el activity principal), cambiar el título de la app a MyForm, que
sea capaz de, después de recoger datos entre los 3 diferentes activities, compartirlo en Twitter, Facebook o
Whatsapp. Activar Up Action Button, en los activities necesarios.

Wireframe
---------
1º Pantalla: EditText para recoger el nombre del usuario.
2º Pantalla: RadioGroup con 2 RadioButton para seleccionar opción (Saludo, Despedida). SeekBar para la
edad, con TextView para mostrar el número de años.
3º Pantalla: Botón en el centro, una vez pulsado, esconder dicho botón, enseñar Toast con los datos
recogidos (Hola Alejandro, ¿Cómo llevas esos 25 años? #MyForm) o (Espero verte pronto Alejandro, antes
que cumplas 26.. #MyForm) y enseñar botón inferior para compartir el mensaje en Twitter, Facebook o
WhatsApp (entre otros).

* Incluir botón en la parte inferior para pasar de un activity a otro, 1º -> 2º -> 3º
* Incluir Up Action button en los actives 2º y 3º apuntando al Main.
* Añadir validaciones para: nombre vacío y edades permitidas sólo entre 16 y 60 (Si selecciona menos,
esconder botón inferior y Toast informando de dicha restricción).
