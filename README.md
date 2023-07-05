# wordle-word-calculator

### Summary
Uses the available answers and usable guesses to score a starting Wordle guess word. The returned score is the average percentage of answers eliminated when using the entered word as a first guess

### Method
The algorithm works by averaging results from simulated wordle games using the inputted guess. Within each simulated game, the situation is rated by generating colors for the guessed letters, and eliminating the answers that cannot work under the color conditions.

### Possible future features:
- Database of all first guesses
- Code readability improvements
- Full game ratings
  - Enter all the guesses it took as well as the answer to rate how well you did
