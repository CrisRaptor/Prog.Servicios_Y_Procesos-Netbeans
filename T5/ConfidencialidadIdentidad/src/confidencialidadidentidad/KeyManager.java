package confidencialidadidentidad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyManager {

    private static final String NOMBRE_CLAVE_PUBLICA = "clave_publica",
            NOMBRE_CLAVE_PRIVADA = "clave_privada",
            EXTENSION_CLAVE = ".key";

    /**
     * Genera un par de claves
     * @return claves generadas
     */
    public static KeyPair generarClaves() throws NoSuchAlgorithmException {

        KeyPairGenerator generador = KeyPairGenerator.getInstance("DSA");
        generador.initialize(512);   // Admite 512, 768 ó 1024
        KeyPair claves = generador.generateKeyPair();

        return claves;
    }

    /**
     * Almacena un key pair en 2 ficheros con formato (clave_publica/clave_privada)+[id]+.key en el [path] indicado.
     * @param claves claves generadas
     * @param path directorio donde se almacenan los ficheros
     * @return un id representado por el numero al final del nombre del fichero
     */
    public static int guardarClaves(KeyPair claves, String path) throws FileNotFoundException, IOException {
        int id = generateNumberPath(path, NOMBRE_CLAVE_PUBLICA, EXTENSION_CLAVE);
        System.out.println(path + NOMBRE_CLAVE_PUBLICA + id + EXTENSION_CLAVE);
        FileOutputStream fos = new FileOutputStream(path + NOMBRE_CLAVE_PUBLICA + id + EXTENSION_CLAVE);
        fos.write(claves.getPublic().getEncoded());
        fos.close();
        fos = new FileOutputStream(path + NOMBRE_CLAVE_PRIVADA + id + EXTENSION_CLAVE);
        fos.write(claves.getPrivate().getEncoded());
        fos.close();
        return id;
    }

    /**
     * Recupera una clave como objeto PublicKey
     * @param path ruta del fichero
     * @return PublicKey del fichero especificado
     */
    public static PublicKey getClavePublica(String path) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        File ficheroClavePublica = new File(path);
        byte[] bytesClavePublica = Files.readAllBytes(ficheroClavePublica.toPath());
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(bytesClavePublica);
        PublicKey clavePublica = keyFactory.generatePublic(publicKeySpec);

        return clavePublica;
    }

    /**
     * Recupera una clave como objeto PrivateKey
     * @param path ruta del fichero
     * @return PrivateKey del fichero especificado
     */
    public static PrivateKey getClavePrivada(String path) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        File ficheroClavePrivada = new File(path);
        byte[] bytesClavePrivada = Files.readAllBytes(ficheroClavePrivada.toPath());
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(bytesClavePrivada);
        PrivateKey clavePrivada = keyFactory.generatePrivate(privateKeySpec);

        return clavePrivada;
    }

    /**
     * Genera un id no existente en el [path] para crear archivos de claves
     * @param path directorio donde comprobar
     * @param name nombre que poseera el fichero
     * @param extension extension que poseera el fichero
     * @return un id valido que no exista para los ficheros con el nombre [name] y la [extension]
     */
    private static int generateNumberPath(String path, String name, String extension) {
        int number = 0;
        String keyPath;
        do {
            number++;
            keyPath = path + name + number + extension;
        } while (FileService.fileExists(keyPath));
        return number;
    }
}
