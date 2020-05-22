# Backend de proyecto entrevista LATAM

Este es el documento explica como instalar este microservicio de ejemplo.

# Documentación útil
* https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html
* https://spring.io/guides/gs/consuming-rest/

#Ejecutar el proyecto:

Verificar primeramente que el puerto 5679 se encuentre disponible.

Asegurar tener gradle instalado, de lo contrario instalar mediante: https://gradle.org/install/

En la carpeta raíz del proyecto ejecutar una consola de comandos los siguientes comandos:

.\gradlew clean build

.\gradlew run

Servicio quedará disponible en la siguiente url: http://localhost:5679/getInfoPerson
