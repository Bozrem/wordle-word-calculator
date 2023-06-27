package org.example;

public class Game {
    private String guess;
    private String answer;

    public Game(String guess, String answer){

    }

    public static int[] getColors(String guess, String answer){
        int[] colors = new int[5];
        for (int i = 0; i < guess.length(); i++){
            char letter = guess.charAt(i);
            if (answer.charAt(i) == letter){

                int greenUses = 0;
                int greenOccurrences = 0;

                for (int e = 0; e < colors.length; e++){
                    if (colors[e] == 2 && guess.charAt(e) == letter) greenUses++; // get # of yellows with that letter already set
                    if (answer.charAt(e) == letter) greenOccurrences++; // get amount of that letter within answer
                }

                if (greenUses < greenOccurrences) colors[i] = 3;
                else colors[i] = 1;
            }

            /*
            /   if answer contains the guess, search the amount of times that letter has already been used in colors.
            /   if the amount of uses is < the amount of occurrences in answer then set as yellow
             */
            else if (answer.contains("" + letter)){
                int yellowUses = 0;
                int yellowOccurrences = 0;
                for (int e = 0; e < colors.length; e++){
                    if (colors[e] == 2 && guess.charAt(e) == letter) yellowUses++; // get # of yellows with that letter already set
                    if (answer.charAt(e) == letter) yellowOccurrences++; // get amount of that letter within answer
                }
                if (yellowUses < yellowOccurrences) colors[i] = 2;
                else colors[i] = 1;
            } // checks if yellow
            else colors[i] = 1;
        } // sorts through each character of guess to get a color
        return colors;
    } // returns the simulated Wordle colors with the specified guess and answer 1 represents green, 2 yellow, 3 gray


}
