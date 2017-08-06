package com.tgt.service

import com.mongodb.BasicDBObject
import com.mongodb.DB
import com.mongodb.DBCollection
import com.mongodb.DBCursor
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoCursor
import com.mongodb.client.MongoDatabase
import com.tgt.model.ProductMongo
import groovy.util.logging.Slf4j
import org.bson.BSON
import org.bson.Document
import org.bson.conversions.Bson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component

@Slf4j
@Component
class ProductMongoService {
    @Autowired
    MongoConnection mongoConnection

    public ProductMongo getPrice(String id) {
        MongoDatabase db = mongoConnection.getConnection()

        ProductMongo productMongo = new ProductMongo()
        log.info("db:" + db)

        MongoCollection<Document> productPrice = db.getCollection("product_price")
        log.info("table:" + productPrice)

        Document findQuery = new Document("product",id)
        MongoCursor<Document> cursor = productPrice.find(findQuery).iterator()

        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next()
                productMongo.price = doc.get("price")
                productMongo.currencyCode = doc.get("currency_code")
            }
        } finally {
            cursor.close()
        }


        return productMongo
    }

    public void updatePrice(String id, String price) {
        MongoDatabase db = mongoConnection.getConnection()
        MongoCollection<Document> productPrice = db.getCollection("product_price")

        Document findQuery = new Document("product",id)
        BasicDBObject updateStatement = new BasicDBObject()
        updateStatement.put("product",id)
        updateStatement.put("price",price)
        updateStatement.put("currency_code","USD")
        productPrice.findOneAndReplace(findQuery, updateStatement)
    }




}
