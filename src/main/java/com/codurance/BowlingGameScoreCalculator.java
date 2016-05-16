package com.codurance;

import static java.lang.Integer.parseInt;

public class BowlingGameScoreCalculator {

  public int evaluate(String turns) {
    String[] turnsSplit = turns.split("");

    int score = 0;
    for (String turn: turnsSplit) {
      if (! turn.equals("-")) {
        score = score + parseInt(turn);
      }
    }

    return score;
  }
}
