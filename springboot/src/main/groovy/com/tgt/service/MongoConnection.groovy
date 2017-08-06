package com.tgt.service

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.client.MongoDatabase
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

import javax.annotation.PreDestroy

@Scope("singleton")
@Component
class MongoConnection {
    MongoClientURI uri = new MongoClientURI("mongodb://target:test@ds051645.mlab.com:51645/product")
    MongoClient mongo
    MongoDatabase db

    public MongoDatabase getConnection() {
        mongo = new MongoClient(uri);
        db = mongo.getDatabase(uri.getDatabase())
        return db
    }

    @PreDestroy
    public void closeConnection() {
        mongo.close()
    }
}
