package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Guess {
    private final String word;
    private final String[] endWords;
    private final ArrayList<String> availableWords;

    public Guess(String guess, String[] endWords){
        word = guess;
        this.endWords = endWords;
        availableWords = (ArrayList<String>) Arrays.asList(endWords);
    } // constructor

    /*
    /   This is more of a brute force method to getting data to ensure that it's accurate. I have it running the guess
    /   with each possible result, and then based on the colors returned from the guess, it sorts through the available
    /   words to see which ones are still possible answers
     */

    public void eliminate(){
        for (int i = 0; i < availableWords.size(); i++){
            int[] colors = Game.getColors(word, availableWords.get(i));




        } // sorts through each possible answer
    }





    private double getPercentRemoved(){
        return 100 * ((double)(endWords.length - availableWords.size())/endWords.length);
    }


}
