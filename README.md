
# Ordering System Microservice Example

This reference architecture and sample project demonstrates an event-driven microservice architecture that uses Spring Boot, H2, JPA and Netflix’s Eureka as a service discovery tool.


## Micro Services

- Product Management
- Order Management



## Run Locally

Clone the project

```bash
  git clone https://github.com/nazrul-kabir/ordering-micro-service
```

Go to discovery-service sub directory

```bash
  cd ordering-micro-service/discovery-service
```


Spin up ```discovery-service```, followed by the ```product-service``` and ```order-service``` applications, then open the Discovery Service’s Eureka Dashboard at http://localhost:3000 you should see that both services have been registered. 
