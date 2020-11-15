import java.io.FileWriter;
import java.io.IOException;

public class writeFile {
    public static String fileWrite(String data) {
        return data;
    }
    public static void main(String[] args) {
        try {
            FileWriter myWrite = new FileWriter("carFile.txt");
            myWrite.write("Hello World");
            myWrite.close();
            System.out.println("Successfully wrote the file.");
        } catch (IOException e) {
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
}
