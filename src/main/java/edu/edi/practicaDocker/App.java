package edu.edi.practicaDocker;
import spark.Request;
import com.google.gson.Gson;
import spark.Filter;
import static spark.Spark.*;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import spark.Response;


public class App {

	static Create create;
    public static void main(String [] args){
    	create=Create.getInstance();
    	staticFiles.location("/public");
        port(getPort());
        after((Filter) (request, response) -> {
    		response.header("Access-Control-Allow-Origin","*");
    		response.header("Access-Control-Allow-Methods","GET");
    	});
        get("hello", (req,res) -> "Hello Docker!");
        get("obtener", (req,res) -> obtenerDatos(req,res));
        post("palabras", (req, res) -> enviarPalabra(req,res));
  }

  private static String obtenerDatos(Request req, Response res) {
	  System.out.println("2222222222222222222222222222");
	  res.type("application/json");
	  ArrayList<Tabla> tabla=create.leer();
	  Gson gson=new Gson();
	  String JSON= gson.toJson(tabla);
	  return JSON;
	}

private static String enviarPalabra(Request req, Response res) {
		return req.body();
	}

private static int getPort() {
      if (System.getenv("PORT") != null) {
          return Integer.parseInt(System.getenv("PORT"));
      }
      return 4567;
  }
  
  
}
