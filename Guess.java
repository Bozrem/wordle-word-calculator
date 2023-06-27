package org.example;

/*
/ Guess is what will be used in main, and runs a bunch of Game instances
 */

public class Guess {
    private final Game[] games;

    public Guess(String guess, String[] endWords) {
        games = new Game[endWords.length];
        for (int i = 0; i < games.length; i++) {
            games[i] = new Game(guess, endWords[i], endWords);
        } // initialize the games
    } // constructor

    /*
    /   This is more of a brute force method to getting data to ensure that it's accurate. I have it running the guess
    /   with each possible result, and then based on the colors returned from the guess, it sorts through the available
    /   words to see which ones are still possible answers
     */

    public void runGames() {
        for (Game g : games) {
            g.run();
        }
    }

    public double getPercentRemoved() {
        double sum = 0;
        for (Game g : games) {
            sum += g.getScore();
        }
        return sum / games.length;
    }


}
