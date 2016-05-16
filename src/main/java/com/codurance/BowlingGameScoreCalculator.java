package com.codurance;

import static java.lang.Integer.parseInt;

public class BowlingGameScoreCalculator {

  public int evaluate(String turns) {
    String[] turnsSplit = turns.split("");

    int score = 0;
    int turnScore;
    for (String turn: turnsSplit) {
      if (turn.equals("-")) {
        turnScore = 0;
      } else if (turn.equals("/")) {
        return 10;
      } else {
        turnScore = parseInt(turn);
      }

      score = score + turnScore;
    }

    return score;
  }
}
