package org.example;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static String[] readEndWords() throws IOException {
        Path path = Path.of("endWords.txt").toAbsolutePath();
        List<String> endWordLines = Files.readAllLines(path, Charset.defaultCharset());
        return endWordLines.toArray(new String[0]);
    } // translates endWords.txt into an array


    public static void main(String[] args) throws IOException {

        String[] endWords = readEndWords();
        Scanner scan = new Scanner(System.in);
        System.out.println("*****************************************\n* Welcome to the Wordle Stat simulator! *");
        System.out.println("\nThis program works by running your guess with every answer that Wordle has to offer.");
        System.out.println("It then takes the colors you would have generated from the guess to rule out the answers that don't work");
        System.out.println("and creates a score for what percent of the answers it eliminated in that game, and returns the average for all games!");
        while (true) {
            System.out.println("\nEnter the word to score. Must contain 5 alphabetical letters");

            String str = scan.nextLine().toLowerCase();
            boolean flag = false;
            for (int i = 0; i < str.length(); i++) {
                if (!"abcdefghijklmnopqrstuvwxyz".contains(String.valueOf(str.charAt(i)))) {
                    System.out.println("Invalid characters!");
                    flag = true;
                }
            }
            double percent;
            if (str.length() != 5 || flag) System.out.println(str + " is not a valid entry!");
            else {
                Guess guess = new Guess(str, endWords);
                guess.runGames();
                percent = guess.getPercentRemoved();
                System.out.println((Math.round(percent * 100.0)) / 100.0);
            }
            System.out.println("Would you like to try again? [Y/N]");
            String prompt = scan.nextLine().toLowerCase();
            if (prompt.equals("n")) {
                break;
            }
        }
        System.out.println("*****************************************\nThank you for playing!\nGame created by Bozrem\n*****************************************");

    }
}