import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MerryElves {

    public static void main(String[] args) {
        ArrayList<Integer> masses = readMassesFromFile();
        ArrayList<Integer> results = new ArrayList<>();

        for (int mass : masses) {
            results.add(calculateFuel(mass));
        }
        for (int i = 0; i < masses.size(); i++) {
            System.out.println("Mass " + masses.get(i) + " takes " + results.get(i) + " fuel.");
        }

        int total = 0;
        for (int fuel : results) {
            total = total + fuel;
        }
        System.out.println("Total fuel amount is: " + total);
    }

    private static int calculateFuel(int mass) {
        return Math.floorDiv(mass, 3)-2;
    }

    private static ArrayList<Integer> readMassesFromFile() {
        ArrayList<Integer> masses = new ArrayList<>();
        try {
            File myFile = new File("/Users/Dasha/IdeaProjects/AdvertOfCode/resources/masses.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int parseStringToInt = Integer.parseInt(data);
                masses.add(parseStringToInt);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
            e.printStackTrace();
        }
        return masses;
    }
}
