import java.io.*;
import java.util.Random;        // creates random number
import java.util.*;             // for vector

/**
 * Question Class will have the questions for the examples, tests, and quizzes of our ITS system
 *
 * Uses random number generation for binary problems.
 *
 *     Methods for Numerical Systems
 * + binary()
 * + binaryToHexGroups(String)  <- used to check step 1
 *
 * + binToDec(String)           <- used to check step 3
 * + decToHex(int)              <- used to check step 4
 *
 * + getRandomNumberInRange(int, int)   <- used by binary to create a random binary number of random (2-8) length
 * + leftPad(String, int, char)         <- add zeroes to the MSB of binary # to create groups of four digits
 * Has a main method for testing purposes.
 *
 *
 * Recitation Project 3
 * Completion time: 3 hours
 *
 * @author Jason Zellers * @version 1.0
 */

public class Question {

    // used to get a random number in a certain range
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    // this method is used to create a binary number
    public static String binary () {

        Random randomGen = new Random();    //used to generate random number
        int binLength = getRandomNumberInRange(2,8); // binary number with length between 2-8
        StringBuilder sb=new StringBuilder();        // used to build binary number

        for (int i = 0; i < binLength; i++) {
            int bin = getRandomNumberInRange(0,1);
            sb.append(bin);
        }

        return sb.toString();
    }

    public static Vector binToHexGroups(String binary) {
        String binaryFormat = binByFour(binary);
        //System.out.println("Formatted: " +binaryFormat);

        Vector hexGroups = new Vector();
        int index = 0;
        while (index < binaryFormat.length()) {
            hexGroups.add(binaryFormat.substring(index, Math.min(index + 4,binaryFormat.length())));
            index += 4;
        }

        return hexGroups;
    }

    // This method is used to change the String binary (from binary()) to a decimal number (int)
    public static int binToDec(String binary) {
        int dec = Integer.parseUnsignedInt(binary, 2);

        return dec;
    }

    // used to pad the hex groups with zeros to fill out the binary groups (groups of 4)
    public static String leftPad(String originalString, int length, char padCharacter) {
        String paddedString = originalString;
        while (paddedString.length() < length) {
            paddedString = padCharacter + paddedString;
        }
        return paddedString;
    }

    public static String binByFour(String binary){
        if (binary.length()%4 != 0)
        {
            int pad = 4- binary.length()%4;
            int binLength = binary.length()+pad;
            binary = leftPad(binary,binLength,  '0');           // to make binary string divisible by 4
        }

        return binary;
    }


    public static String decToHex(int decimal) {
        String hexStr = Integer.toString(decimal,16);

        return hexStr;
    }

    public static void main (String[] args) {

        for (int i = 0; i < 10; i++) {
            String bin = binary();
            System.out.println("Question: " + (i+1) + " \nBinary: " +bin);
            System.out.println("Decimal: " + binToDec(bin));
            System.out.println("Hex: " + decToHex(binToDec(bin)) + "\n");


            System.out.println("Hex groups: ");
            for(int j=0;j<binToHexGroups(bin).size();j++) {
                System.out.print(binToHexGroups(bin).get(j).toString() + " \t ");
            }

            System.out.println("\n***************\n");



    }

    }
}
