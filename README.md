## General info

Starbucks REST API

* Type: REST Web Service
* Tools: Spring MVC + Spring Security + Hibernate + MySQL

## REST API Design

| HTTP Method   |      Path          |  Description                                   |
| ------------- | -------------      | -------------                                  |          
| GET           | /api/coffee        | Get a list of Hot Coffees (via Starbucks menu) |
| GET           | /api/coffee/{id}   | Get a Hot Coffee by its ID                     |
| POST          | /api/coffee        | Add a new Hot Coffee to menu                   |
| PUT           | /api/coffee        | Update a Hot Coffee in menu                    |
| DELETE        | /api/coffee/{id}   | Delete a Hot Coffee by its ID                  |

## Database

Tables:
* Coffee (contains info about Starbucks Hot Coffees)
* Users (contains users of the API)
* Authorities (contains roles of the API users)

## Security

There are 3 types of roles:

1) **USER** can perform `GET` operations
2) **EDITOR** can perform `PUT` operation
3) **ADMIN** can perform `POST` and `DELETE` operations

## Examples
- ![GET](https://via.placeholder.com/15/c5f015/000000?text=+) **GET** `/api/coffee/18`

```json
{
    "id": 18,
    "name": "Caffè Latte",
    "type": "Lattes",
    "calories": 190,
    "description": "Our dark, rich espresso balanced with steamed milk and a light layer of foam. A perfect milk-forward warm-up."
}
```
- ![POST](https://via.placeholder.com/15/158/000000?text=+) **POST** `/api/coffee/`
```json
{
    "name": "Espresso Con Panna",
    "type": "Espresso Shots",
    "calories": 35,
    "description": "Espresso meets a dollop of whipped cream to enhance the rich and caramelly flavors of a straight-up shot."
}
```
***Result:***
```json
{
    "id": 9,
    "name": "Espresso Con Panna",
    "type": "Espresso Shots",
    "calories": 35,
    "description": "Espresso meets a dollop of whipped cream to enhance the rich and caramelly flavors of a straight-up shot."
}
```
- ![DELETE](https://via.placeholder.com/15/f03c15/000000?text=+) **DELETE** `/api/coffee/18`
```txt
Deleted Hot Coffee id is 18
```

## Exception Handling
This service handles exception for situation when user make a request with non-existent ID:

- ![GET](https://via.placeholder.com/15/c5f015/000000?text=+) **GET** `/api/coffee/90`

```json
{
    "status": "NOT_FOUND",
    "code": "404",
    "message": "No coffee with this ID: 90",
    "timeStamp": "2021-02-12 01:38:21"
}
```
## Resources

* [Starbucks Menu](https://www.starbucks.com/menu/drinks/hot-coffees)
