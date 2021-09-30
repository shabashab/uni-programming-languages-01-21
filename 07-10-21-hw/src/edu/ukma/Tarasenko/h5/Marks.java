package edu.ukma.Tarasenko.h5;

import java.util.Scanner;

public class Marks {

    public static String getMarkDescription(int mark) throws Exception {
        if(mark < 0 || mark > 100) {
            throw new Exception("Invalid mark");
        }

        if(mark < 30) return "Very Bad";
        if(mark < 60) return "Bad";
        if(mark < 66) return "Weakly";
        if(mark < 71) return "Satisfactory";
        if(mark < 81) return "Good";
        if(mark < 91) return "Very good";
        return "Excellent";
    }

    public static void main(String[] args) {
        System.out.print("Enter your mark: ");
        Scanner scanner = new Scanner(System.in);
        int mark = scanner.nextInt();
        try {
            System.out.println(getMarkDescription(mark));
        } catch (Exception e) {
            System.out.println("Invalid mark");
        }
    }
}
