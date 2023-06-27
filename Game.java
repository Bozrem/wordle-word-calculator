package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    private final String guess;
    private final String answer;
    private final ArrayList<String> availableWords = new ArrayList<>();
    private final int originalLength;

    public Game(String guess, String answer, String[] answerDataset) {
        this.guess = guess;
        this.answer = answer;
        availableWords.addAll(Arrays.asList(answerDataset));
        originalLength = answerDataset.length;
    }

    public static int[] getColors(String guess, String answer) {
        int[] colors = new int[5];
        for (int i = 0; i < guess.length(); i++) {
            char letter = guess.charAt(i);
            if (answer.charAt(i) == letter) {

                int greenUses = 0;
                int greenOccurrences = 0;

                for (int e = 0; e < colors.length; e++) {
                    if (colors[e] == 2 && guess.charAt(e) == letter)
                        greenUses++; // get # of yellows with that letter already set
                    if (answer.charAt(e) == letter) greenOccurrences++; // get amount of that letter within answer
                }

                if (greenUses < greenOccurrences) colors[i] = 3;
                else colors[i] = 1;
            }

            /*
            /   if answer contains the guess, search the amount of times that letter has already been used in colors.
            /   if the amount of uses is < the amount of occurrences in answer then set as yellow
             */
            else if (answer.contains("" + letter)) {
                int yellowUses = 0;
                int yellowOccurrences = 0;
                for (int e = 0; e < colors.length; e++) {
                    if (colors[e] == 2 && guess.charAt(e) == letter)
                        yellowUses++; // get # of yellows with that letter already set
                    if (answer.charAt(e) == letter) yellowOccurrences++; // get amount of that letter within answer
                }
                if (yellowUses < yellowOccurrences) colors[i] = 2;
                else colors[i] = 1;
            } // checks if yellow
            else colors[i] = 1;
        } // sorts through each character of guess to get a color
        return colors;
    } // returns the simulated Wordle colors with the specified guess and answer 1 represents green, 2 yellow, 3 gray

    public boolean checkColors(int[] originalColors, String guess, String testAnswer) {
        return Arrays.equals(getColors(guess, testAnswer), originalColors);
    } // if it generates the same colors as the real one then it must be still possible and cannot be ruled out

    public void run() {
        int[] colors = getColors(guess, answer);
        for (int i = 0; i < availableWords.size(); i++) {
            if (!checkColors(colors, guess, availableWords.get(i))) {
                availableWords.remove(i);
                i--;
            } // sorts out the words that are impossible out of the dataset
        }
    } // simulates colors, then sorts through each available answer to see if its plausible

    public double getScore() {
        return 100 * (1 - (double) availableWords.size() / originalLength); // returns the percentage removed in the game
    }


}
