package edu.asu.CSE360._04._03;
import java.lang.reflect.Array;
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

    public static Vector binFormula(Vector hexGroups){
        Vector binFormula = new Vector();
        int size = hexGroups.size();
        String binDigits;

        for (int i = 0 ; i<size; i++){          //Vector element iteration
            for (int j =0; j<4; j++) {          // iterate through individual elements
               binDigits = hexGroups.get(i).toString();
               binFormula.add(binDigits.charAt(j));
               //System.out.println("size: "+hexGroups.size());
               //int power = (4-i)*(hexGroups.size()-i);
               //binFormula.add(power);

            }
        }

        return binFormula;
    }
    // This method is used to change the String binary (from binary()) to a decimal number (int)
    public static int binToDec(String binary) {

        return Integer.parseUnsignedInt(binary, 2);
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

        return Integer.toString(decimal,16).toUpperCase();
    }

    // creates random decimal number by calling getRandomNumberInRange
    // this method is used by generateRandomHex to create a random hex number
    public static int generateRandomDec() {

        return getRandomNumberInRange(20, 255);                      //increase top range for increased difficulty
    }

    // calls generateRandomDec to create random decimal number and converts it to hex
    public static String generateRandomHex(int decimal){

        return Integer.toHexString(decimal).toUpperCase();
    }

    public static int recursionCount(int dec) {
        int count = 0;                              // to count recursions
        while (dec>0) {
            dec = dec/2;
            count++;
        }

        return count;
    }

    public static String decToBin(int decimal) {
        String result = ((decimal % 2 == 0) ? "0" : "1");

        if (decimal == 0 || decimal == 1) {
            return result;
        }

        return decToBin(decimal/2) + result;
    }

    public static String hexConvert(String hex) {

        String strArray[] = hex.split("");

        for(int i = 0; i<strArray.length; i++) {
            switch (strArray[i]){
                case "A":
                    strArray[i] = "10";
                    break;
                case "B":
                    strArray[i] = "11";
                    break;
                case "C":
                    strArray[i] = "12";
                    break;
                case "D":
                    strArray[i] = "13";
                    break;
                case "E":
                    strArray[i] = "14";
                    break;
                case "F":
                    strArray[i] = "15";
                    break;
                default:
                    strArray[i] = strArray[i];
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            sb.append(strArray[i]);
        }

        return sb.toString();
    }

    public static String[] hexFormula(String hex) {

        String[] formula = new String[hex.length()*2];

        /*
        for (int i = 0 ; i<hex.length(); i++){              // traverse hex string
            for (int j = 0; j<formula.length; j+=2){        // traverse formula array
                formula[j]= Character.toString(hex.charAt(i));
                formula[j+1] = Integer.toString(hex.length()-(i+1));

            }

        }
        */
        //     static for a 2 digit hex code

        formula[0] = Character.toString(hex.charAt(0));
        formula[2] = Character.toString(hex.charAt(1));

        formula[1] = Integer.toString(hex.length()-1);
        formula[3] = Integer.toString(hex.length()-2);


        return formula;
    }

    public static void main (String[] args) {

        for (int i = 0; i < 10; i++) {

            // Bin -> Hex testing complete
            String bin = binary();
            System.out.println("Question # " + (i+1) + " \nBinary: " +bin);
            System.out.println("Step 1 (Hex groups): ");
            for(int j=0;j<binToHexGroups(bin).size();j++) {
                System.out.print(binToHexGroups(bin).get(j).toString() + " \t ");
            }

            Vector formula;
            formula = binFormula(binToHexGroups(bin));
            System.out.print("\nStep 2 (Binary Formula): ");
            System.out.println(formula.toString());


            System.out.println("Step 3 (Decimal): " + binToDec(bin));
            System.out.println("Step 4 (Hex): " + decToHex(binToDec(bin)));

            System.out.println("\n");

            // Hex -> Bin testing

            // Random # Generation
            int dec = generateRandomDec();
            String hex = generateRandomHex(dec);

            System.out.println("**Now Hex to Bin** ");
            System.out.println("Hex: " + hex);
            System.out.println("Step 1 (Convert hex): " + hexConvert(hex));
            System.out.println("Step 2 (Provide Formula): " + Arrays.toString(hexFormula(hex)));
            System.out.println("Step 3 (Decimal): " + dec);
            System.out.println("step 4 (Number of Divisions): " + recursionCount(dec));
            System.out.println("Step 5 (Binary): " + decToBin(dec));

            System.out.println("\n***************\n");
        }

    }
}
