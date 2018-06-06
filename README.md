# AirBdb - Grupo 23
-------
### Integrantes ###
- Barba, Dante
- De Luca, Agustin Ramon
- Pellegrino, Mauricio

### How-to ###
-  Descargar mysql-server y ejecutar el servicio.
-  Clonar el **master** branch, o el **tag** de la versión deseada. 
-  Ejecutar el script "createDatabase.sh"
```bash
./createDatabase.sh # Crea el entorno, usuarios y db necesarios.
```
-  Una vez clonado el proyecto desde el **master** branch y lanzada la base de datos, ejecutar en el directorio donde se encuentre el pom.xml: 
```bash
mvn clean install
```
Si los test pasan correctamente la construcción sera correcta.

### How-to Docker ###
La base de datos puede ser ejecutada y administrada en un contenedor de docker.
##### Requisitos #####
- Docker
- Docker-compose 3.1 o superior.

Para lanzar la base de datos utilizando docker se deben ejecutar los siguientes comandos dentro de la carpeta contenedora del archivo "docker-compose.yml"

```bash
docker-compose up -d
```
Luego se debe ejecutar, igual que en el paso anterior, el script "createDatabase.sh" y las sentencias de maven.

### Changelog ###
---
# 2.0.2
- Readme.md actualizado
---
# 2.0.1
- Implementada etapa 1 parte 2.

---
# 1.0
- Implementada primera parte.
