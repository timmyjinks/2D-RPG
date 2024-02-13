package org.example.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyIO {
    BufferedReader bread = new BufferedReader(new InputStreamReader(System.in));

    public String stringInput(String prompt) {
        String strOutput = "";
        boolean bloop = true;

        if (!prompt.isEmpty()) {
            System.out.println(prompt);
        }
        try {
            while (bloop) {
                strOutput = bread.readLine();
                bloop = strOutput.isEmpty();
            }
        } catch (IOException e) {
            System.out.println("Invalid Input");
        }
        return strOutput;
    }

    public int intInput(String prompt) {
        int intOutput = 0;
        boolean bloop = true;

        try {
            while (bloop) {
                intOutput = Integer.parseInt(stringInput(prompt));
                bloop = false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Must be a number");
        }
        return intOutput;
    }

    public char charInput(String prompt) {
        char charOutput = 0;
        boolean bloop = true;

//        if (!prompt.isEmpty()) {
//            System.out.println(prompt);
//        }
        try {
            while (bloop) {
                charOutput = stringInput(prompt).toLowerCase().charAt(0);
                bloop = false;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Can't be empty");
        }
        return charOutput;
    }
}
