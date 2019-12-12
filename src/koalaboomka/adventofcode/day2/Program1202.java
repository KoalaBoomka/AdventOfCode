package koalaboomka.adventofcode.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Program1202 {

    public static void main(String[] args) throws IOException {

        intcodeProgram(intcodeToArray());
    }

    private static Integer intcodeProgram(Integer[] input) throws IOException {
        Integer[] opcodes = intcodeToArray();

        int instructionPointer = 0;
        int opcode = opcodes[instructionPointer];
        while (opcode != 99) {
            Integer parameter1 = opcodes[opcodes[instructionPointer + 1]];
            Integer parameter2 = opcodes[opcodes[instructionPointer + 2]];
            Integer parameter3 = opcodes[instructionPointer + 3];
            if (opcode == 1) {
                opcodes[parameter3] = parameter1 + parameter2;
            } else if (opcode == 2) {
                opcodes[parameter3] = parameter1 * parameter2;
            } else {
                System.out.println("Unknown opcode is received, please check your input");
            }
            instructionPointer += 4;
            opcode = opcodes[instructionPointer];
        }
        System.out.println("The value of a 0 element in the opcodes array equals: " + opcodes[0]);
        return opcodes[0];
    }

    // Reads data separated by comma from a file and writes it in an array
     private static Integer[] intcodeToArray() throws IOException {
         String lines = Files
                 .readString(Paths
                         .get("/Users/Dasha/IdeaProjects/AdventOfCode/src/koalaboomka/adventofcode/day2/intcode.txt"));
         return Arrays
                 .stream(lines.split(","))
                 .map(String::trim)
                 .mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
     }

    }
