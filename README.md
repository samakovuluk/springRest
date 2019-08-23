# Get all regions
GET method http://localhost:8080/regions
```
[
    {
        "id": 1,
        "name": "Восточно-Казахстанская область",
        "cities": [
            {
                "id": 1,
                "name": "Усть-Каменогорск"
            }
        ]
    }
]
```
# Get all cities
GET method http://localhost:8080/cities
```
[
    {
        "id": 1,
        "name": "Усть-Каменогорск"
    }
]
```
# Get exact region
GET method http://localhost:8080/regions/{id}
# Get exact city
GET method http://localhost:8080/cities/{id}

# Add new region
POST method http://localhost:8080/regions
Body
```
 {
    "id": 2,
   "name": "Алматинская область"
 }
```
Response body
```
{
    "id": 2,
    "name": "Алматинская область",
    "cities": []
}
```
# Add new city
POST method http://localhost:8080/cities
Body
```
 {
    "id": 2,
   "name": "Алматы",
   "regionId":2
 }
```
Response body
```
{
    "id": 2,
    "name": "Алматы"
}
```
# Change the name of city
PUT method http://localhost:8080/cities/{id}
Body
```
 {
   "name": "Астана",
   "regionId":2
 }
```
Response body
```
{
    "id": 2,
    "name": "Астана"
}
```
# Change the name of city
PUT method http://localhost:8080/regions/{id}
Body
```
 {
   "name": "Шымкент",
 }
```
Response body
```
{
    "id": 2,
    "name": "Шымкент"
    "cities": []
}
```
# Delete city or region
DELETE method http://localhost:8080/regions/{id}
DELETE method http://localhost:8080/cities/{id}






