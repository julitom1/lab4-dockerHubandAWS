package edu.edi.practicaDocker;
import spark.Request;
import com.google.gson.Gson;
import spark.Filter;
import static spark.Spark.*;

import java.util.ArrayList;

import spark.Response;


public class App {

	static ConnectionDataBase create;
    public static void main(String [] args){
    	create=ConnectionDataBase.getInstance();
    	
        port(getPort());
        after((Filter) (request, response) -> {
    		response.header("Access-Control-Allow-Origin","*");
    		response.header("Access-Control-Allow-Methods","GET");
    	});
        get("hello", (req,res) -> "Hello Dockerrr!");
        get("obtener", (req,res) -> obtenerDatos(req,res));
        put("palabras", (req, res) -> enviarPalabra(req,res));
  }
    //static ArrayList<Tabla> tabla=new ArrayList<>();
  private static String obtenerDatos(Request req, Response res) {
	  res.type("application/json");
	  ArrayList<Tabla> tabla=create.leer();
	  ArrayList<Tabla> t=new ArrayList<Tabla>();
	  for(int i=tabla.size()-1;i>=tabla.size()-10;i--) {
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
		create.crear(t);
		String JSON=obtenerDatos(req,res);
		return JSON;
	}

private static int getPort() {
      if (System.getenv("PORT") != null) {
          return Integer.parseInt(System.getenv("PORT"));
      }
      return 4002;
  }
  
  
}
