# product-api

Datasource <br>
* mongo hosted at mlab.com

Caching
* uses ehcache for storing the product info from RedSky and prices from mongo

Get Product
* http://localhost:8080/product/13860428
* http://localhost:8080/product/51843908
* http://localhost:8080/product/50570764


Update a price <br>
http://localhost:8080/product/13860428 or 51843908 or 50570764<br>
* body: { "price": "67.00" }
