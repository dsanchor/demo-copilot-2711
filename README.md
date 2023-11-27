# Spring Boot Rest API Demo

## Compilación del proyecto

Para compilar el proyecto se debe ejecutar el siguiente comando:

```bash
mvn clean install
```

## Ejecución del proyecto

```bash	
mvn spring-boot:run
```

## Test con curl
    
```bash
curl -X GET http://localhost:8080/hello
```

## Test operación reverse

```bash
curl http://localhost:8080/reverse?input=hello
```

## Test operacion remove-vowels

```bash
curl http://localhost:8080/remove-vowels?input=hello
```

## Ejecutar test unitarios

```bash
mvn test
```

## Conterinerización

### Crear imagen docker

```bash
docker build -t demo2711 .
```

### Ejecutar imagen docker

```bash
docker run -p 8080:8080 demo2711
```