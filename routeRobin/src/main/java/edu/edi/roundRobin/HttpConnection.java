package edu.edi.roundRobin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
public class HttpConnection {
	private static final String USER_AGENT = "Mozilla/5.0";
	private static final HttpConnection instance=new HttpConnection();
    /**
     *  Hace conexión con la API externa que se le indico
     * @return Devuelve los datos de esa API externa
     * @throws IOException
     */
    public String getData(String url) throws IOException {
    	String responseStr=null;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

            //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
        	BufferedReader in = new BufferedReader(new InputStreamReader(
            con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
            	response.append(inputLine);
            }
            in.close();


            responseStr = response.toString();
        } else {
                System.out.println("GET request not worked");
        }
            System.out.println("GET DONE");
        
        return responseStr;
    }
    public String putData(String url2,String palabras) throws IOException {
    	String responseStr=null;

        URL url = new URL(url2);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("PUT");
        OutputStreamWriter out = new OutputStreamWriter(
            httpCon.getOutputStream());
        out.write(palabras);
        out.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(
        		httpCon.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
        	response.append(inputLine);
        }
        in.close();


        responseStr = response.toString();
        return responseStr;
        
    }
    public static HttpConnection getInstance() {
    	return instance;
    }
}
