import java.io.File;
import java.io.IOException;

public class createFile {
    public static void main(String[] args) {
        try {
            File myFile = new File("carFile.txt");
            if (myFile.createNewFile()) {
                System.out.println("File '" + myFile.getName() + "' ");
            } else {
                System.out.println("File already created.");
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
