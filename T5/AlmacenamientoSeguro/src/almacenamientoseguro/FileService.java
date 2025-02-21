package almacenamientoseguro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author CrisGC   
 */
public class FileService {
    public static byte[] readFile(String path) throws UnsupportedEncodingException{
        String data = "";
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    data += line;
                }

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return data.getBytes("ISO-8859-1");
        
    }
    
    public static void writeFile(String name, String data){
        try {
            File file = new File(name);
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(data);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
