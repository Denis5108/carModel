import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class carModel {
    public static ArrayList<String> read() {
        ArrayList<String> data = new ArrayList<>();
        try {
            File file = new File("carFile.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                data.add(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return data;
    }
    public static void write(String data) {
        try {
            FileWriter myWrite = new FileWriter("carFile.txt");
            if (data.contains("all")) {
                myWrite.close();
                System.out.println("Error: '" + data + "' was not recognized");
                return;
            }
            myWrite.write(data);
            myWrite.close();
            System.out.println("Successfully wrote the file");
        } catch (IOException e) {
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        boolean done = false;
        String car;
        ArrayList<String> cars;
        cars = read();

        while (!done) {
            Scanner in = new Scanner(System.in);
            System.out.println(
                    """
                            1. Buy a Car   \s
                            2. Sell a Car  \s
                            3. Check Car(s)\s
                            4. Save Car(s) \s
                            5. Quit"""
            );

            int choice = in.nextInt();
            if (choice == 1) {
                // buy a car
                System.out.println("Please enter a car type: ");
                car = in.next();
                cars.add(car);
            }
            if (choice == 2) {
                // sell a car
                for (String i : cars) {
                    System.out.println(i);
                }
                System.out.println("What car do you want to sell: ");
                car = in.next();
                cars.remove(car);
            }
            if (choice == 3) {
                System.out.println("All Cars");
                for (String i : cars) {
                    System.out.println(i);
                }
            }
            if (choice == 4) {
                System.out.println("Please type in a car name, type (all) for all cars: ");
                car = in.next();
                if (car.equals("all"))
                {
                    for (String i : cars) {
                        write(i);
                    }
                } else {
                    if (cars.contains(car))
                    {
                        write(car);
                    } else {
                        System.out.println("Error: Spelling error");
                    }
                }
            }
            if (choice == 5) {
                done = true;
            }
        }
    }
}
