### Para correr la aplicacion en NVIM

En la terminal dirigirse a la ruta raiz del projecto Maven y escribir:

- ./nvmw spring-boot:run
  O en Gradle:
- ./gradlew bootRun

Si queremos agregar opciones al levantar el servicio, como elegir un perfil o un puerto:

- ./nvmw spring-boot:run -Dspring-boot.run.profiles=dev -Dspring-boot.run.arguments=--server.port=8080
  O en Gradle:
- ./gradlew bootRun -args='--spring.profiles.active=dev --server.port=8080'
