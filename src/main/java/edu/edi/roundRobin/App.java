package edu.edi.roundRobin;
import spark.Request;
import spark.Filter;
import static spark.Spark.*;

import java.io.IOException;

import com.google.gson.Gson;

import spark.Response;


public class App {

	private static RoundRobin wr;
	private static HttpConnection conection;
    

    public static void main(String [] args){
    	wr=RoundRobin.getInstance();
    	conection=HttpConnection.getInstance();
        port(getPort());
        after((Filter) (request, response) -> {
    		response.header("Access-Control-Allow-Origin","*");
    		response.header("Access-Control-Allow-Methods","GET");
    	});
        get("hello", (req,res) -> "Hello Docker!");
        get("obtener", (req,res) -> obtenerDatos(req,res));
        put("palabras", (req, res) -> enviarPalabra(req,res));
  }
    
  private static String obtenerDatos(Request req, Response res) {
	  String urlService=wr.getRoundRobin();
	  System.out.println(urlService);
	  String resultado="";
	  try {
		  resultado=conection.getData(urlService+"/obtener");
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	  res.type("application/json");

	  return resultado;
	}

private static String enviarPalabra(Request req, Response res) {
		String urlService=wr.getRoundRobin();
		System.out.println(urlService);
		String resultado="";
		  try {
			  resultado=conection.putData(urlService+"/palabras",req.body());
		  } catch (IOException e) {
			e.printStackTrace();
		  }
		  res.type("application/json");
		return resultado;
	}

private static int getPort() {
      if (System.getenv("PORT") != null) {
          return Integer.parseInt(System.getenv("PORT"));
      }
      return 4568;
      
  }
  
  
}
