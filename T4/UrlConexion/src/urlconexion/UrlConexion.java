package urlconexion;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConexion {
    
    public static void main(String[] args) throws MalformedURLException, IOException{
        URL url = new URL("https://iesbelen.org");
        URLConnection conexionUrl = url.openConnection();
        InputStream is = conexionUrl.getInputStream();
        int c;
        
        while ((c = is.read())!= -1) {
            System.out.print((char)c);
        }
    }
}
