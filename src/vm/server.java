package vm;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class server
{

  public static XmlRpcClient client        = null;
  static String              XMLRPC_SERVER = "http://staging.inkcloud.io//test_listener.php ";
  String name_airline;
  String fulladdress;
  String credentials;
  String screen_mode;
  String connection_bar;
  String username;
  public String[] jsonAirlines;
  
  public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
  {
    server mt = new server();
    mt.get_json();
  }

  public boolean connect()
  {
    try
    {
      if (client == null)
      {
        client = new XmlRpcClient();
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL(XMLRPC_SERVER));
        client.setConfig(config);
        System.out.println("XMLRPC Client created, Conecting to [" + XMLRPC_SERVER + "]");
      }
    } catch (Exception e)
    {
      System.out.println("Error on connect method [" + e.toString() + "]");
      return false;
    }
    return true;
  }

  public Object execute_xmlrpc(String method_name, Object[] params)
  {
    Object[] result = null;
    try
    {
      result = (Object[]) client.execute(method_name, params);
    } catch (Exception e)
    {
      System.out.println("Error execute_xmlrpc method: " + method_name + " - Error message: [" + e.getMessage() + "]");
    }
    return result;
  }

  public String execute_xmlrpc_string_result(String method_name, Object[] params)
  {
    String result = null;
    try
    {
      result = (String) client.execute(method_name, params);
    } catch (Exception e)
    {
      System.out.println("Error execute_xmlrpc method: " + method_name + " - Error message: [" + e.getMessage() + "]");
    }
    return result;
  }

  public void get_json() throws FileNotFoundException, UnsupportedEncodingException  
  {
    PrintWriter writer = null;

    System.out.println("->Get JSON");
    String R;
    if (this.connect() == true)
    {


        Object[] params = new Object[1];
        params[0] = "";

        R =  this.execute_xmlrpc_string_result("get_json", params);
        if (R == null)
        {
            System.out.println("Error receiving application from inkdcs - function get_json");
        } else
        {
            JsonParser parser = new JsonParser();
            JsonArray gsonArr = parser.parse(R).getAsJsonArray();
            int c=0;
            for (JsonElement obj : gsonArr) {
                c++;
            }
            jsonAirlines = new String[c];
            int i=0;
            File fichero = new File(".");
            for (JsonElement obj : gsonArr) {                      
                // Object of array
                JsonObject gsonObj = obj.getAsJsonObject();     
                
      
                name_airline = gsonObj.get("nombre_aerolinea").getAsString();
                jsonAirlines[i]=name_airline;
                i++;
                writer = new PrintWriter(fichero.getAbsolutePath()+"/build/classes/files/ink"+name_airline +".rdp", "UTF-8");
                // Primitives elements of object                
                fulladdress = gsonObj.get("direccion").getAsString();
                credentials = gsonObj.get("credenciales").getAsString();
                screen_mode = gsonObj.get("pantalla").getAsString();
                connection_bar = gsonObj.get("barra_conexion").getAsString();
                username = gsonObj.get("nombre_usuario").getAsString();
      
                writer.println(fulladdress);
                writer.println(credentials);
                writer.println(screen_mode);
                writer.println(connection_bar);
                writer.println(username);
                writer.close();
            }  
        }
    }     
          

          
      
      

  }

}

