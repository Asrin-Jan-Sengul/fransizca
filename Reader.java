import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public String[] okuyucu(String fileName){
        String[] words = new String[0];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                words = line.split(" ");
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return words;
    }
}
