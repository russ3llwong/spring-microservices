## CONFIGURATIONS

### For Refences Only

Below are the properties files of all services stored in the local git config repo used by ** Spring Cloud Config Server**.

- limits-service.properties
```properties
#default values
limits-service.maximum=9999
limits-service.minimum=90
eureka.client.service-url.default-zone=http://localhost:8761/eureka
```

- currency-exchange.properties
```properties
server.port=8000
eureka.client.service-url.default-zone=http://localhost:8761/eureka
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.show-sql=true
spring.h2.console.enabled=true
```

- currency-conversion.properties
```properties
server.port=8100
eureka.client.service-url.default-zone=http://localhost:8761/eureka
```

- eureka-naming-server.properties
```properties
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```

- zuul-api-gateway-server.properties
```properties
server.port=8765
eureka.client.service-url.default-zone=http://localhost:8761/eureka
```

