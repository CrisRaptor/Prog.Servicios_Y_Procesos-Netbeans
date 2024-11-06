package ejconcurrencia2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author CrisGC
 */
public class Reader extends Thread {

    String file;

    public Reader(String file) {
        this.file = file;
    }

    @Override
    public void run() {
        System.out.println(file + "\nLineas: " + countLines());
        System.out.println(file + "\nPalabras: " + countWords());
        System.out.println(file + "\nLetras: " + countCharacters());
    }

    private int countLines() {
        int lineCount = 0;
        String line;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            line = in.readLine();
            while (line != null) {
                lineCount++;
                line = in.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error: File not found - " + ex.getMessage());
        }

        return lineCount;
    }

    private int countWords() {
        int wordCount = 0;
        String[] words = null;
        String line;
        boolean isNull;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            line = in.readLine();
            isNull = (line == null);
            if (!isNull) {
                words = line.trim().split("\\s+");
            }
            while (!isNull) {
                wordCount += words.length;
                line = in.readLine();
                isNull = (line == null);
                if (!isNull) {
                    words = line.trim().split("\\s+");
                }
            }
        } catch (IOException ex) {
            System.out.println("Error: File not found - " + ex.getMessage());
        }

        return wordCount;
    }

    private int countCharacters() {
        int charCount = 0;
        String[] words = null;
        String line;
        boolean isNull;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            line = in.readLine();
            isNull = (line == null);
            if (!isNull) {
                words = line.trim().split("\\s+");
            }
            while (!isNull) {
                for (String word : words) {
                    charCount += word.toCharArray().length;
                }
                line = in.readLine();
                isNull = (line == null);
                if (!isNull) {
                    words = line.trim().split("\\s+");
                }
            }
        } catch (IOException ex) {
            System.out.println("Error: File not found - " + ex.getMessage());
        }

        return charCount;
    }
}
