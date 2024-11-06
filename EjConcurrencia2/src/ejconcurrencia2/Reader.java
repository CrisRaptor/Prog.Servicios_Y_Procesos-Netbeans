package ejconcurrencia2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author CrisGC
 */
public class Reader extends Thread {

    private String file;
    private static int totalLines = 0, totalWords = 0, totalChars = 0;

    public Reader(String file) {
        this.file = file;
    }

    @Override
    public void run() {
        int lines = countLines(), words = countWords(), chars = countCharacters();
        System.out.println(file + "\nLineas: " + lines + "\nPalabras: " + words + "\nLetras: " + chars);
        addTotals(totalLines, lines);
        addTotals(totalWords, words);
        addTotals(totalChars, chars);
    }
    
    private synchronized void addTotals(int total, int value){
        total += value;
    }

    public static int getTotalLines() {
        return totalLines;
    }

    public static int getTotalWords() {
        return totalWords;
    }

    public static int getTotalChars() {
        return totalChars;
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
        String[] words;
        String line;
        boolean isNull;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            line = in.readLine();
            isNull = (line == null);

            while (!isNull) {
                words = line.trim().split("\\s+");
                wordCount += words.length;
                line = in.readLine();
                isNull = (line == null);
            }
        } catch (IOException ex) {
            System.out.println("Error: File not found - " + ex.getMessage());
        }

        return wordCount;
    }

    private int countCharacters() {
        int charCount = 0;
        String[] words;
        String line;
        boolean isNull;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            line = in.readLine();
            isNull = (line == null);
            while (!isNull) {
                words = line.trim().split("\\s+");
                for (String word : words) {
                    charCount += word.toCharArray().length;
                }
                line = in.readLine();
                isNull = (line == null);
            }
        } catch (IOException ex) {
            System.out.println("Error: File not found - " + ex.getMessage());
        }

        return charCount;
    }
}
