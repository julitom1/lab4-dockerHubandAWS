package edu.edi.practicaDocker;
import spark.Request;
import spark.Filter;
import static spark.Spark.*;
import spark.Response;


public class App {

    public static void main(String [] args){
    	staticFiles.location("/public");
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");
        post("palabras", (req, res) -> enviarPalabra(req,res));
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
