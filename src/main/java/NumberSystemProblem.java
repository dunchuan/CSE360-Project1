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
 * + toDec(String)           <- used to check step 3
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

public class NumberSystemProblem {



    private String binary;
    private String question = "";
    private int maxSets;

    public void generateBinToDecProblem() {
        newProblem();
        question = "Convert " + binary + " to Decimal";
    }


    public String getQuestion() {
        return question;
    }
    public String getGiven() {
        return binary;
    }



    // this method is used to create a binary number
    public NumberSystemProblem(int maxSets) {
        this.maxSets = maxSets;

        newProblem();
    }


    public void newProblem() {

        Random randomGen = new Random();    //used to generate random number
        int binLength = randomGen.nextInt(100) % (maxSets - 1) + 1;
        StringBuilder sb=new StringBuilder();        // used to build binary number

        for (int i = 0; i < binLength * 4; i++) {
            int bin = randomGen.nextInt(2);
            sb.append(bin);
        }
        binary = sb.toString();
    }


    public String toString() {
        return binary;
    }

    private Vector binToHexGroups() {
        String binaryFormat = binByFour(binary);

        Vector<String> hexGroups = new Vector<>();
        int index = 0;
        while (index < binaryFormat.length()) {
            hexGroups.add(binaryFormat.substring(index, Math.min(index + 4,binaryFormat.length())));
            index += 4;
        }
        return hexGroups;
    }

    // This method is used to change the String binary (from binary()) to a decimal number (int)
    private int toDec() {
        return Integer.parseUnsignedInt(binary, 2);
    }

    // used to pad the hex groups with zeros to fill out the binary groups (groups of 4)
    private String leftPad(String originalString, int length) {
        String paddedString = originalString;
        while (paddedString.length() < length) {
            paddedString = '0' + paddedString;
        }
        return paddedString;
    }

    private String binByFour(String binary){
        if (binary.length()%4 != 0)
        {
            int pad = 4 - binary.length()%4;
            int binLength = binary.length()+pad;
            binary = leftPad(binary,binLength);           // to make binary string divisible by 4
        }

        return binary;
    }


    private String toHex() {
        return Integer.toHexString(this.toDec());
    }

    public static void main (String[] args) {

        for (int i = 0; i < 10; i++) {
            NumberSystemProblem bin = new NumberSystemProblem(4);
            System.out.println("Question: " + (i+1) + " \nBinary: " +bin);
            System.out.println("Decimal: " + bin.toDec());
            System.out.println("Hex: " + bin.toHex() + "\n");

            System.out.println("Hex groups: ");
            for(int j=0;j< bin.binToHexGroups().size();j++) {
                System.out.print(bin.binToHexGroups().get(j).toString() + " \t ");
            }

            System.out.println("\n***************\n");
        }

    }

    public boolean verifyBinToDec(String text, int index) {
        int pow = binary.length() - 1 - index;
        String currentDigit = binary.substring(index, index + 1);
        boolean isOne = currentDigit.equals("1");
        int trueAnswer = isOne ? (int)Math.pow(2, pow) : 0;
        System.out.println(text + " : " + trueAnswer);

        boolean result;
        try {
            result = Integer.parseInt(text) == trueAnswer;
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid Number found: " + text);
            return false;
        }

        return result;

    }
}
