# Discovery Service

This is one of the micro-service of Ordering System that manages discovery of the micro services using Netflix’s Eureka.


## Run Locally

Clone the project

```bash
  git clone https://github.com/nazrul-kabir/ordering-micro-service
```

Go to discovery-service sub directory

```bash
  cd ordering-micro-service/discovery-service
```

Build and run the service

```bash
  ./gradlew bootRun
```
and confirm that it works by visiting http://localhost:3000. You should see a Eureka dashboard which displays information about the running instances.

