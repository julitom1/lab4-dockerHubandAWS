package edu.edi.practicaDocker;

import java.util.Date;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;

import com.mongodb.client.MongoClients;

import com.mongodb.client.MongoCollection;

import com.mongodb.client.MongoDatabase;

import java.awt.List;
import java.util.ArrayList;

import org.bson.Document;

import org.bson.types.ObjectId;
public class ConnectionDataBase {

	public static final ConnectionDataBase _instance=new ConnectionDataBase();

	public static ConnectionDataBase getInstance() {
		return _instance;
	}
    public static void crear(Tabla tb) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://db")) {

            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("arem");

            MongoCollection<Document> gradesCollection = sampleTrainingDB.getCollection("tablas");
            

            Document documento = new Document("_id", new ObjectId());

        
            documento.append("palabra",tb.getPalabra() )

                   .append("fecha", tb.getFecha());

            gradesCollection.insertOne(documento);

        }

    }
    public static ArrayList<Tabla> leer() {

        try (MongoClient mongoClient = MongoClients.create("mongodb://db")) {

            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("arem");

            MongoCollection<Document> gradesCollection = sampleTrainingDB.getCollection("tablas");
            ArrayList<Tabla> datos=new ArrayList<Tabla>();
            for(Document d:gradesCollection.find()) {
            	datos.add(new Tabla((String)d.get("palabra"),(Date)d.get("fecha")));
            }
            // find one document with new Document

            return datos;
                        

        }

    }
    public static void main(String[] args) {
    	//leer();
    
    }

}
