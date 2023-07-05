package org.example;


public class Guess {
    private final Game[] games;

    public Guess(String guess, String[] endWords) {
        games = new Game[endWords.length];
        for (int i = 0; i < games.length; i++) {
            games[i] = new Game(guess, endWords[i], endWords);
        } // initialize the games
    }

    public void runGames() {
        for (Game game : games) {
            game.run();
        }
    }

    public double getPercentRemoved() {
        double sum = 0;
        for (Game game : games) {
            sum += game.getScore();
        }
        return sum / games.length;
    }


}
