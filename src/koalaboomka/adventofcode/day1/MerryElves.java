package koalaboomka.adventofcode.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MerryElves {

    public static void main(String[] args) {
        ArrayList<Integer> massesOfSpaceShipModules = readMassesFromFile();
        ArrayList<Integer> fuelsForSpaceShipModules = new ArrayList<>();
        ArrayList<Integer> fuelsForFuel = new ArrayList<>();

        // Writes fuel values in a results array
        for (int mass : massesOfSpaceShipModules) {
                fuelsForSpaceShipModules.add(calculateFuel(mass));
        }

        // Calculates additional fuel for the fuel
        for (int fuel : fuelsForSpaceShipModules) {
            int newFuel =  fuel;
            int totalFuel = 0;
            while ( newFuel >= 0) {
                newFuel = calculateFuel(newFuel);

                // If a calculated new fuel below zero, ignore this result
                if (newFuel < 0){
                    break;
                }

                totalFuel += newFuel;
            }
            fuelsForFuel.add(totalFuel);
        }

        // Writes masses and fuel values in the log
        for (int i = 0; i < massesOfSpaceShipModules.size(); i++) {
            System.out.println("Mass " + massesOfSpaceShipModules.get(i) + " takes " + fuelsForSpaceShipModules.get(i) + " fuel.");
        }

        // Calculates total amount of fuel spent on the space ship launch
        int total = 0;
        for (int i=0; i < fuelsForSpaceShipModules.size(); i++) {
            total = total + fuelsForSpaceShipModules.get(i) + fuelsForFuel.get(i);
        }
        System.out.println("Total fuel amount is: " + total);
    }

    // Calculates needed fuel to fly a module
    private static int calculateFuel(int mass) {
        return  Math.floorDiv(mass, 3) - 2;
    }

    // Accepts a data from a file, parses String to int and returns this data as an array
    private static ArrayList<Integer> readMassesFromFile() {
        ArrayList<Integer> masses = new ArrayList<>();
        try {
            File myFile = new File("/Users/Dasha/IdeaProjects/AdventOfCode/src/koalaboomka/adventofcode/day1/masses.txt");
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
