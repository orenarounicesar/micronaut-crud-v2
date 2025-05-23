# micronaut-crud-v2

REPO de código fuente
- https://github.com/orenarounicesar/micronaut-crud-v2.git


# Variables de entorno

DATASOURCE_URL: cadena del tipo jdbc:mysql://HOST:PUERTO/NOMBRE_BASE_DE_DATOS

DATASOURCE_USERNAME: Usuario de Conexión a la base de datos

DATASOURCE_PASSWORD: Contraseña de usuario de base de datos


# Curl de ejemplo

- curl -X POST http://HOST:PORT/personas \
-H "Content-Type: application/json" \
-d '{"nombre": "Juan", "apellido": "Pérez", "edad": 30}'


- curl -X GET http://HOST:PORT/personas/1


- curl -X PUT http://HOST:PORT/personas/1 \
-H "Content-Type: application/json" \
-d '{"nombre": "Juan Carlos", "apellido": "Pérez", "edad": 31}'


- curl -X DELETE http://HOST:PORT/personas/1


# Ejemplo de comando de creación de la imagen de docker
- docker build -t micronaut-crud-v2 .

# Ejemplo de comando de ejecución de contenedor
docker run -d -e DATASOURCE_URL=jdbc:mysql://10.10.1.3:3311/esp -e DATASOURCE_USERNAME=root -e DATASOURCE_PASSWORD=root -p 8080:8080 --name micronaut-crud-v2 micronaut-crud-v2



Recursos a desplegar en AWS
- 2 subredes públicas en AZ distintas
- 2 instancias (en cada subred), contenedores del backend
- 1 RDS con MySQL
- 1 ALB publico
