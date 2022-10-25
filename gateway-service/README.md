# Gateway Service

This is one of the micro-service of Ordering System that manages the Routing and Server-Side Load Balancing with [Netflix's Zuul](https://github.com/Netflix/zuul)



## Run Locally

Clone the project

```bash
  git clone https://github.com/nazrul-kabir/ordering-micro-service
```

Go to gateway-service sub directory

```bash
  cd ordering-micro-service/gateway-service
```

Build and run the service

```bash
  ./gradlew bootRun
```
and confirm that it works by visiting http://localhost:8080/orders. You should see the list of orders as same as http://localhost:3002/api/v1/order.

