package firmadigital;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyManager {

    private static final String NOMBRE_CLAVE_PUBLICA = "clave_publica",
            NOMBRE_CLAVE_PRIVADA = "clave_privada",
            EXTENSION_CLAVE = ".key";

    
    public static KeyPair generarClaves() throws NoSuchAlgorithmException {

        KeyPairGenerator generador = KeyPairGenerator.getInstance("DSA");
        generador.initialize(512);   // Admite 512, 768 ó 1024
        KeyPair claves = generador.generateKeyPair();

        return claves;
    }

    public static void guardarClaves(KeyPair claves, String path) throws Exception {
        FileOutputStream fos = new FileOutputStream(generateKeyPath(path, NOMBRE_CLAVE_PUBLICA, EXTENSION_CLAVE));
        fos.write(claves.getPublic().getEncoded());
        fos.close();
        fos = new FileOutputStream(generateKeyPath(path, NOMBRE_CLAVE_PRIVADA, EXTENSION_CLAVE));
        fos.write(claves.getPrivate().getEncoded());
        fos.close();
    }

    
    public static PublicKey getClavePublica(String path) throws Exception {
        File ficheroClavePublica = new File(path);
        byte[] bytesClavePublica = Files.readAllBytes(ficheroClavePublica.toPath());
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(bytesClavePublica);
        PublicKey clavePublica = keyFactory.generatePublic(publicKeySpec);

        return clavePublica;
    }

    
    public static PrivateKey getClavePrivada(String path) throws Exception {
        File ficheroClavePrivada = new File(path);
        byte[] bytesClavePrivada = Files.readAllBytes(ficheroClavePrivada.toPath());
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(bytesClavePrivada);
        PrivateKey clavePrivada = keyFactory.generatePrivate(privateKeySpec);

        return clavePrivada;
    }

    private static String generateKeyPath(String path, String name, String extension){
        int number = 1;
        String keyPath;
        do {
            keyPath = path+name+number+extension;
        } while(FileService.fileExists(keyPath));
        return keyPath;
    }
}
