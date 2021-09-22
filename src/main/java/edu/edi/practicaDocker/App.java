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
        post("palabras", (req, res) -> enviarPalabra(req,res));
  }

  private static Object enviarPalabra(Request req, Response res) {
		req.attribute(null);
		return null;
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
			+ "<script>\r\n"
			+ "function enviar(){\r\n"
			+ "var for = document.getElementById('formulario')\r\n"
			+ "let promise = new Promise( (resolve, reject) => {\r\n"
			+ "				var postPromise = $.ajax({\r\n"
			+ "				url: \"http://localhost:8080/blueprints/\",\r\n"
			+ "				type: 'POST',\r\n"
			+ "				data: {\"palabra\":\"for\"},\r\n"
			+ "				contentType: \"application/json\"\r\n"
			+ "			});\r\n"
			+ "			resolve(postPromise);\r\n"
			+ "			});\r\n"
			+ "			\r\n"
			+ "			return promise;\r\n"
			+ "}\r\n"
			+ "</script>\r\n"
	  		+ "    <head>\r\n"
	  		+ "        <meta charset=\\\"UTF-8\\\">\r\n"
	  		+ "        <title>title og the document</title>\r\n"
	  		+ "        <script src=\"https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js\"></script>\r\n"
	  		+ "        <link rel=\"stylesheet\" href=\"/index.css\"/>\r\n"
	  		+ "        <style>\r\n"
	  		+ "            body { background-color: RED; }\r\n"
	  		+ "        </style>\r\n"
	  		+ "    </head>\r\n"
	  		+ "    <body>\r\n"
	  		+ "        <center>\r\n"
	  		+ " \r\n"
	  		+ "            <input id=\"entrada\" type=\"text\" name=\"Compania\" placeholder=\"Ingrese un dato\">\r\n"
	  		+ "            <br><button id=\"formulario\" type=\"button\" class=\"button\" onclick=\"enviar()\">Click me</button>\r\n"
	  		+ " \r\n"
	  		+ "        </center>\r\n"
	  		+ "    </body>\r\n"
	  		+ "</html>";
  }
}
