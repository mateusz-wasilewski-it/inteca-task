# inteca-task

### Before you start

```
./startDatabase.sh
docker exec -it database bash
mysql -u root -ppassword
create database db_credits;
create database db_customers;
create database db_products;

docker run -p 8000:8000 --network="host" credit
docker run -p 8001:8001 --network="host" customer
docker run -p 8002:8002 --network="host" product
```

### How to use it

POST request `http://localhost:8000/createCredit`
```
{
    "creditName":"name",
    "firstName":"name",
    "surname":"surname",
    "pesel":"pesel",
    "productName":"productName",
    "value":value
}
```

GET request `http://localhost:8000/getCredits`