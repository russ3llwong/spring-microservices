# spring-microservices

This project consists of microservices aims to act as a currency converter.

## Services & Applications

- **Limit Service**

Provides the maximum & minimum quantities allowed for conversion.

- **Currency Exchange Service**

Provides currency-exchange rates to Currency Conversion Service. Communicates with database. 

- **Currency Conversion Service**

Converts currencies when given quantity and types of currencies to convert from/to.

- **H2 Database**

In-memory databse to store data.

- **Spring Cloud Config Server**

Stores configurations of services. Please refer to **Configurations.MD** for references.

- **Feign REST Client**

Provides a proxy to talk to other services. Makes REST calls much easier.

- **Ribbon**

Communicates with Eureka naming server to obtain URLs of services to handle load balancing.

- **Eureka Naming Server**

Communicates with Ribbon and provides URLs to service clients that have registered with the Eureka server.

- **Zuul API Gateway Server**

Intercepts requests for authentication, rate limits or logging purposes.

- **RabbitMQ**

Stores messages/logs and communicates with Zipkin.

- **Zipkin Distributed Tracing Server**

Communicates with RabbitMQ and traces requests sent across services. Makes it easier to monitor and troubleshoot.

## Ports

|Application|Port  |
|--|--|
| Limits Service | 8080, 8081...  |
| Spring Cloud Config Server | 8888|
| Currency Exchange Service | 8000, 8001...|
| Currency Converter Service | 8100, 8101...|
|Eureka Naming Server | 8761|
| Zuul API Gateway Server | 8765|
| Zipkin Distributed Tracing Server| 9411|

## URLs

|     Application       |     URL          |
| ------------- | ------------- |
| Limits Service | http://localhost:8080/limits POST -> http://localhost:8080/actuator/refresh|
|Spring Cloud Config Server| http://localhost:8888/limits-service/default http://localhost:8888/limits-service/dev |
|  Currency Converter Service - Direct Call| http://localhost:8100/currency-converter/from/USD/to/INR/quantity/10|
|  Currency Converter Service - Feign| http://localhost:8100/currency-converter-feign/from/EUR/to/INR/quantity/10000|
| Currency Exchange Service | http://localhost:8000/currency-exchange/from/EUR/to/INR http://localhost:8001/currency-exchange/from/USD/to/INR|
| Eureka | http://localhost:8761/|
| Zuul - Currency Exchange & Exchange Services | http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/10|
| Zipkin | http://localhost:9411/zipkin/ |
| Spring Cloud Bus Refresh | http://localhost:8080/bus/refresh |

## Rabbit MQ Instalation

Link to downloads
- https://www.rabbitmq.com/download.html

## Zipkin Installation

Quick Start Page
- https://zipkin.io/pages/quickstart

Command to run (Mac)
```
RABBIT_URI=amqp://localhost java -jar zipkin.jar
```
