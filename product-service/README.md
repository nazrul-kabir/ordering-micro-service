# Product Service

This is one of the micro-service of Ordering System providing couple of REST APIs to manage products.


## Run Locally

Clone the project

```bash
  git clone https://github.com/nazrul-kabir/ordering-micro-service
```

Go to product-service sub directory

```bash
  cd ordering-micro-service/product-service
```

Build and run the service

```bash
  ./gradlew bootRun
```
# REST API

The REST API to the example app is described below.

## Get list of Products

### Request

`GET /api/v1/product/`

### Response

    [
        {
            "id": 1,
            "name": "Dell Precision 5550",
            "currentStock": 99,
            "description": "The world's smallest and thinnest 15 inch mobile workstation.",
            "type": "Laptop",
            "dateCreated": "2022-10-23T08:33:10.658+00:00",
            "lastModified": "2022-10-23T08:33:10.658+00:00"
        }
    ]


## Create a new Product

### Request

`POST /api/v1/product/`

### Request Body

    {
        "name": "HP Pavilion 14",
        "currentStock": 9,
        "description": "Great buy",
        "type": "Laptop"
    }


### Response

    {
        "name": "HP Pavilion 14",
        "currentStock": 9,
        "description": "Great buy",
        "type": "Laptop"
    }


## Get a specific Product

### Request

`GET api/v1/product/id`


### Response

    {
        "id": 1,
        "name": "Dell Precision 5550",
        "currentStock": 99,
        "description": "The world's smallest and thinnest 15 inch mobile workstation.",
        "type": "Laptop",
        "dateCreated": "2022-10-23T08:33:10.658+00:00",
        "lastModified": "2022-10-23T08:33:10.658+00:00"
    }

## Update a Product

### Request

`POST api/v1/product/update/id`

### Request Body

    {
    "name": "HP Pavilion 14",
    "currentStock": 1,
    "description": "Great buy laptop",
    "type": "Laptop"
    }


### Response

    {
    "name": "HP Pavilion 14",
    "currentStock": 1,
    "description": "Great buy laptop",
    "type": "Laptop"
    }


## Delete a Product

### Request

`DELETE /api/v1/product/id`


### Response

    HTTP/1.1 201 Created
    Date: Thu, 24 Feb 2011 12:36:31 GMT
    Status: 201 Created
    Connection: close
    Content-Type: application/json
    Location: /thing/2
    Content-Length: 35

    {"id":2,"name":"Bar","status":null}


