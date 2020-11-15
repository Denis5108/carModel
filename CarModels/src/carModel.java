import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class carModel {
    public static void write(String data) {
        try {
            FileWriter myWrite = new FileWriter("carFile.txt");
            myWrite.write(data);
            myWrite.close();
            System.out.println("Successfully wrote the file");
        } catch (IOException e) {
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
    public static String carName() {
        Scanner ob = new Scanner(System.in);
        String name = ob.next();
        return name;
    }
    public static void main(String[] args) {
        boolean done = false;
        String car;
        ArrayList<String> cars = new ArrayList<String>();

        while (!done) {
            Scanner in = new Scanner(System.in);
            System.out.println(
                            "1. Buy a Car   \n"       +
                            "2. Sell a Car  \n"       +
                            "3. Check Car(s)\n"       +
                            "4. Save Car(s) \n"       +
                            "5. Quit"
            );

            Integer choice = in.nextInt();
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
                write(car);
            }
            if (choice == 5) {
                done = true;
            }
        }
    }
}
