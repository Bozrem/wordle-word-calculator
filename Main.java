package org.example;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;


public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        printIntro();
        boolean gameLoop = true;
        while (gameLoop) {
            System.out.println("\nEnter the word to score. Must contain 5 alphabetical letters");
            String guess = getGuess();
            System.out.println(getScore(guess));
            gameLoop = continuePlaying();
        }
        printOutro();
    }

    public static String[] readEndWords() throws IOException {
        Path path = Path.of("endWords.txt").toAbsolutePath();
        List<String> endWordLines = Files.readAllLines(path, Charset.defaultCharset());
        return endWordLines.toArray(new String[0]);
    }

    private static void printIntro() {
        System.out.println("*****************************************\n* Welcome to the Wordle Stat simulator! *");
        System.out.println("\nThis program works by running your guess with every answer that Wordle has to offer.");
        System.out.println("It then takes the colors you would have generated from the guess to rule out the answers that don't work");
        System.out.println("and creates a score for what percent of the answers it eliminated in that game, and returns the average for all games!");
    }

    private static String getGuess() {
        String str = "";
        boolean guessLoop = true;
        while (guessLoop) {
            str = scan.nextLine().toLowerCase();
            guessLoop = !isValidGuess(str);
        }
        return str;
    }

    private static boolean isValidGuess(String guess) {
        if (isValidGuessLength(guess) && isValidGuessCharacters(guess)) {
            return true;
        }
        System.out.println("Invalid Entry! Please try again");
        return false;
    }

    private static boolean isValidGuessCharacters(String guess) {
        for (int i = 0; i < guess.length(); i++) {
            if (!"abcdefghijklmnopqrstuvwxyz".contains(String.valueOf(guess.charAt(i)))) {
                System.out.println("Invalid characters!");
                return false;
            }
        }
        return true;
    }

    private static boolean isValidGuessLength(String guess) {
        return guess.length() == 5;
    }

    private static double getScore(String guess) throws IOException {
        String[] endWords = readEndWords();
        Guess gameGuess = new Guess(guess, endWords);
        gameGuess.runGames();
        return Math.round(gameGuess.getPercentRemoved() * 100.0) / 100.0;
    }

    private static boolean continuePlaying() {
        System.out.println("Would you like to try again? [Y/N]");
        String prompt = scan.nextLine().toLowerCase();
        return prompt.equals("y");
    }

    private static void printOutro() {
        System.out.println("*****************************************");
        System.out.println("Thank you for playing!\nSoftware created by Bozrem");
        System.out.println("*****************************************");
    }


}