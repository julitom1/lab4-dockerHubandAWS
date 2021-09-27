package edu.edi.practicaDocker;

import com.mongodb.client.MongoClient;

import com.mongodb.client.MongoClients;

import org.bson.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Connection {

    public static void main(String[] args) {
    	System.out.println("hola");
        String connectionString = "mongodb://127.0.0.1:27017";

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
           
      
            databases.forEach(db -> System.out.println(db.toJson()));

        }

    }

}