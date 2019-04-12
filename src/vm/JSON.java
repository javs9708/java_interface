package vm;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.PrintWriter;


public class JSON {

  public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        

        try {
           
            Object obj = parser.parse(new FileReader("./src/files/vm.json"));
            JSONObject jsonObject = (JSONObject) obj;


            String fulladdress = (String) jsonObject.get("direccion");
            System.out.println(fulladdress);

            String credentials = (String) jsonObject.get("credenciales");
            System.out.println(credentials);

            String screen_mode = (String) jsonObject.get("pantalla");
            System.out.println(screen_mode);
            
            String connection_bar = (String) jsonObject.get("barra_conexion");
            System.out.println(connection_bar);
            
            String username = (String) jsonObject.get("nombre_usuario");
            System.out.println(username);

            //JSONObject innerObject = (JSONObject) jsonObject.get("Posts");
            //System.out.println(innerObject.toJSONString());

            // loop array
            /*JSONArray tags = (JSONArray) jsonObject.get("Tags");
            Iterator<String> iterator = tags.iterator();
            while (iterator.hasNext()) {
                    System.out.println(iterator.next());
            }
            */
                
            PrintWriter writer = new PrintWriter("./src/files/ink.rdp", "UTF-8");
            writer.println(fulladdress);
            writer.println(credentials);
            writer.println(screen_mode);
            writer.println(connection_bar);
            writer.println(username);
            writer.close();

        } catch (FileNotFoundException e) {
                //manejo de error
        } catch (IOException e) {
                //manejo de error
        } catch (ParseException e) {
                //manejo de error
        }
       

}


}
