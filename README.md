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

## Despliegue en AKS

### Variables de entorno

```bash
export RESOURCE_GROUP=aks-demo-alb-rg
export CLUSTER_NAME=demo
export NAMESPACE=demo2711
```

### Obtener credenciales

```bash
az aks get-credentials --resource-group $RESOURCE_GROUP --name $CLUSTER_NAME
```

### Crear namespace

```bash
kubectl create namespace $NAMESPACE
```

### Desplegar aplicación

```bash
kubectl apply -f k8s/application.yaml -n $NAMESPACE
```

### Obtener IP del servicio

```bash
export SVC_IP=$(kubectl get svc demo2711-service  -n $NAMESPACE -o jsonpath='{.status.loadBalancer.ingress[0].ip}')
```

### Test operación reverse

```bash
curl http://$SVC_IP/reverse?input=hello
```