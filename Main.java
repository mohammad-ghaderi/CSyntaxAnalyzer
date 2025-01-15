import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String filePath = "input.txt"; 

        String fileContent = "";

        // Using BufferedReader with StringBuilder
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder buffer = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                buffer.append(line).append("\n");
            }

            fileContent = buffer.toString();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        Stack<Token> tokens = Lexical.run(fileContent);
        
        
    }
}