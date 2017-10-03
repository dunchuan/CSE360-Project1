package edu.asu.CSE360._04._03;
import java.util.Random;

/**
 * Question Class will have the questions for the examples, tests, and quizzes of our ITS system
 *
 * Uses random number generation for binary problems.
 *
 * INWK=> Dec to Hex
 * Has a main method for testing purposes.
 *
 *
 * Recitation Project 3
 * Completion time: 1 hours
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

    // This method is used to change the String binary (from binary()) to a decimal number (int)
    public static int binToDecimal(String binary) {
        int dec = Integer.parseUnsignedInt(binary, 2);

        return dec;
    }

    /*      TODO:
    public static int binToHex(String binary) {

        int groups = binary.length()/4;

    }
    */
    public static void main (String[] args) {

        for (int i = 0; i < 10; i++) {
            String bin = binary();
            System.out.println(i + " " +bin);
            System.out.println("Decimal: " + binToDecimal(bin) + "\n");
        }
    }
}
