package edu.edi.practicaDocker;
import spark.Request;
import spark.Filter;
import static spark.Spark.*;
import spark.Response;


public class App {

    public static void main(String [] args){
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");
        get("palabras", (req, res) -> devolderHtml(req,res));
  }

  private static int getPort() {
      if (System.getenv("PORT") != null) {
          return Integer.parseInt(System.getenv("PORT"));
      }
      return 4567;
  }
  
  public static String devolderHtml(Request req, Response res) {
	  return "<!DOCTYPE html>\r\n"
	  		+ "<html>\r\n"
	  		+ "    <head>\r\n"
	  		+ "        <meta charset=\\\"UTF-8\\\">\r\n"
	  		+ "        <title>title og the document</title>\r\n"
	  		+ "        <script src=\"https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js\"></script>\r\n"
	  		+ "        <script src=\"/index.js\"></script>\r\n"
	  		+ "        <link rel=\"stylesheet\" href=\"/index.css\"/>\r\n"
	  		+ "        <style>\r\n"
	  		+ "            body { background-color: RED; }\r\n"
	  		+ "        </style>\r\n"
	  		+ "    </head>\r\n"
	  		+ "    <body>\r\n"
	  		+ "        <center>\r\n"
	  		+ " \r\n"
	  		+ "            <input id=\"entrada\" type=\"text\" name=\"Compania\" placeholder=\"Ingrese un dato\">\r\n"
	  		+ "            <br><button type=\"button\" class=\"button\" onclick=\"index.change($('#entrada').val())\">Click me</button>\r\n"
	  		+ " \r\n"
	  		+ "        </center>\r\n"
	  		+ "    </body>\r\n"
	  		+ "</html>";
  }
}
