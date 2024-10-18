# API Spec

## Authentication
All API must use this authentication

Request :
- Header : 
   - X-API-Key : "your secret api key"
## Create Product
Request : 
- Method : POST
- Endpoint : `/api/products`
- Header :
    - Content-Type : application/json
    - Accept: application/json
- Body :
```json
{
  "id" : "String,Unique",
  "name" : "String",
  "price" : "long",
  "quantity" : "integer"
}
```
Response :
```json
{
  "code" : "number",
  "status" : "String",
  "data" : {
    "id": "String,Unique",
    "name": "String",
    "price": "long",
    "quantity": "integer",
    "createAt": "date"
  }
}
```

## Get Product
Request :
- Method : GET
- Endpoint : `/api/products/{id_product}`
- Header :
    - Accept: application/json
- Response :
```json
{
  "code" : "number",
  "status" : "String",
  "data" : {
    "id" : "String,Unique",
    "name" : "String",
    "price" : "long",
    "quantity" : "integer"
  }
}
```

## Update Product
Request :
- Method : PUT
- Endpoint : `/api/products/{id_product}`
- Header :
    - Content-Type : application/json
    - Accept: application/json
- Body :
```json
{
  "name" : "String",
  "price" : "long",
  "quantity" : "integer"
}
```
Response :
```json
{
  "code" : "number",
  "status" : "String",
  "data" : {
    "id" : "String,Unique",
    "name" : "String",
    "price" : "long",
    "quantity" : "integer",
    "createAt" : "date",
    "updateAt" : "date"
  }
}
```

## List Product
Request :
- Method : GET
- Endpoint : `/api/products`
- Header :
    - Content-Type : application/json
    - Accept: application/json
- Query Param : 
    - pageSize : number
    - page : number

Response :
```json
{
  "code" : "number",
  "status" : "String",
  "data" : [
    {
      "id" : "String,Unique", 
      "name" : "String", 
      "price" : "long", 
      "quantity" : "integer"
    },
    {
      "id" : "String,Unique",
      "name" : "String",
      "price" : "long",
      "quantity" : "integer"
    }
  ]
}
```

## Delete Product
Request :
- Method : DELETE
- Endpoint : `/api/products/{id_product}`
- Header :
    - Content-Type : application/json
    - Accept: application/json
  
Response :
```json
{
  "code" : "number",
  "status" : "String"
}
```