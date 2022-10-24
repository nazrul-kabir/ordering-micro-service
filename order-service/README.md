# Order Service

This is one of the micro-service of Ordering System providing couple of REST APIs to manage products.


## Run Locally

Clone the project

```bash
  git clone https://github.com/nazrul-kabir/ordering-micro-service
```

Go to order-service sub directory

```bash
  cd ordering-micro-service/order-service
```

Build and run the service

```bash
  ./gradlew bootRun
```
# REST API

The REST API to the order service app is described below.

## Get list of Orders

### Request

`GET /api/v1/order/`

### Response

    [
        {
            "id": 1,
            "product": {
                "id": 1,
                "name": "Dell Precision 5550",
                "currentStock": 99,
                "description": "The world's smallest and thinnest 15 inch mobile workstation.",
                "type": "Laptop"
            },
            "quantity": 1,
            "orderState": "RUNNING"
        }
    ]


## Create a new Order

### Request

`POST /api/v1/order/`

### Request Body

    {
        "productId": 1,
        "quantity": 10
    }



### Response

    {
        "id": 3,
        "productId": 1,
        "quantity": 1,
        "orderState": "RUNNING",
        "dateCreated": "2022-10-24T05:38:10.908+00:00",
        "lastModified": "2022-10-24T05:38:10.908+00:00"
    }


## Get a specific Order

### Request

`GET api/v1/order/id`


### Response

    {
        "id": 1,
        "productId": 1,
        "quantity": 1,
        "orderState": "RUNNING",
        "dateCreated": "2022-10-23T18:17:04.517+00:00",
        "lastModified": "2022-10-23T18:17:04.517+00:00"
    }
