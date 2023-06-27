package org.example;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static String[] readEndWords() throws IOException {
        Path endWordPath = FileSystems.getDefault().getPath("src", "endWords.txt");
        List<String> endWordLines = Files.readAllLines(endWordPath, Charset.defaultCharset());
        return endWordLines.toArray(new String[0]);
    } // translates endWords.txt into an array


    public static void main(String[] args) throws IOException {

        String[] endWords = readEndWords();
        Scanner scan = new Scanner(System.in);
        System.out.println("*****************************************\n* Welcome to the Wordle Stat simulator! *");
        System.out.println("\nThis program works by running your guess with every answer that Wordle has to offer.");
        System.out.println("It then takes the colors you would have generated from the guess to rule out the answers that don't work");
        System.out.println("It creates a score for what percent of the answers it eliminated in that game, and returns the average for all games!");

        System.out.println("\nEnter the word to score. Must contain 5 alphabetical letters");

        String str = scan.nextLine().toLowerCase();
        boolean flag = false;
        for (int i = 0; i < str.length(); i++){
            if (!"abcdefghijklmnopqrstuvwxyz".contains(str.charAt(i) + "")) {
                System.out.println("char error");
                flag = true;
                break;
            }
        }
        double percent = 0;
        if (str.length() != 5 || flag) System.out.println("Not a valid entry!");
        else {
            Guess guess = new Guess(str, endWords);
            guess.runGames();
            percent = guess.getPercentRemoved();
        }
        System.out.println(percent);

    }
}