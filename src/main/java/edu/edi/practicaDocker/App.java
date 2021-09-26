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
    static ArrayList<Tabla> tabla=new ArrayList<>();
  private static String obtenerDatos(Request req, Response res) {
	  res.type("application/json");
	  //ArrayList<Tabla> tabla=create.leer();
	  ArrayList<Tabla> t=new ArrayList<Tabla>();
	  for(int i=tabla.size()-10;i<tabla.size();i++) {
		  if(i>=0) {
			  t.add(tabla.get(i));
		  }
	  }
	  Gson gson=new Gson();
	  String JSON= gson.toJson(t);
	  return JSON;
	}

private static String enviarPalabra(Request req, Response res) {
		Tabla t=new Tabla(req.body());
		tabla.add(t);
		return req.body();
	}

private static int getPort() {
      if (System.getenv("PORT") != null) {
          return Integer.parseInt(System.getenv("PORT"));
      }
      return 4567;
  }
  
  
}
