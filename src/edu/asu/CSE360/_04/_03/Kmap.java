package edu.asu.CSE360._04._03;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Kmap {

    private String equation;
    private String simpleSOP;
    private String simplePOS;
    private Integer[][] field;

    public Kmap() {
        equation = "default";
        simpleSOP = "simple SOP default";
        simplePOS = "simple POS default";
        field = null;
    }

    // FOR JUST POS OR SOP QUESTIONS
    public Kmap(String equation, Integer[][] field, String simpleEq) {

        this.equation = equation;
        this.field = field;
        this.simpleSOP = simpleEq;


    }

    // INCASE ASKED FOR BOTH SOP AND POS IN ONE QUESTION
    public Kmap(String equation, Integer[][] field, String simpleSOP, String simplePOS) {

        this.equation = equation;
        this.field = field;
        this.simpleSOP = simpleSOP;
        this.simplePOS = simplePOS;

    }



    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public String getSimpleSOP() {
        return simpleSOP;
    }

    public void setSimpleSOP(String simpleSOP) {
        this.simpleSOP = simpleSOP;
    }

    public String getSimplePOS() {
        return simplePOS;
    }

    public void setSimplePOS(String simplePOS) {
        this.simplePOS = simplePOS;
    }

    public Integer[][] getField() {
        return field;
    }

    public void setField(Integer[][] field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "Kmap{" +
                "equation='" + equation + '\'' +
                ", simple SOP ='" + simpleSOP + '\'' +
                ", simple POS ='" + simplePOS + '\'' +
                '}';
    }

    public void printMap() {
         System.out.println(Arrays.deepToString(field));
    }


    public static void main(String[] args) {
                        //  equation, array, simple SOP equation, simple POS eq
        Integer[][] arr1 = {{0,1},{0,1}};
        Kmap q1 = new Kmap("Z = f(A,B) = AB' + AB", arr1 ,"A");

        //question 2
        Integer[][] arr2 = {{1,1},{1,0}};
        Kmap q2 = new Kmap("Z = f(A,B) = A'B' + AB' + A'B",arr2,"A' + B'", "(A' + B'");

        //question 3
        Integer[][] arr3 = {{1,0,1,0},{1,0,1,0},{1,1,1,0},{1,0,1,0}};
        Kmap q3 = new Kmap("f(A,B,C,D) = (A + B + C + D')(A + B + C' + D)(A + B' + C + D')(A + B' + C' + D)(A' + B' + C' + D)(A' + B + C + D')(A' + B + C' + D)",
                arr3,"(B+C+D')(A+C+D')(C'+D)");

        //question 4
        Integer[][] arr4 = {{0,0,0,0},{0,0,1,1}};
        Kmap q4 = new Kmap("AC(B' + C)",arr4,"AC");

    }
}
