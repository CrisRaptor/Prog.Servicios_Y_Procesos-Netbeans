package confidencialidadidentidad;

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

    public static byte[] readFile(String path) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        String data = "";

        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = reader.readLine()) != null) {
            data += line;
        }

        return data.getBytes("ISO-8859-1");
    }

    public static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write(data);
        writer.close();
    }
    
    public static void createFile(String path, String name) throws IOException{
        File file = new File(path+name);
        file.createNewFile();
    }

    public static boolean fileExists(String path) {
        File f = new File(path);
        return (f.exists() && !f.isDirectory());
    }
}
