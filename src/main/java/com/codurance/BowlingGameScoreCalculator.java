package com.codurance;

import static java.lang.Integer.parseInt;

public class BowlingGameScoreCalculator {

  private static final String MISSED_THROW = "-";
  private static final String SPARE_THROW = "/";
  private static final String SPLIT_DELIMETER = "";

  public int evaluate(String turns) {
    String[] turnsSplit = turns.split(SPLIT_DELIMETER);

    int score = 0;
    int turnScore;
    for (String turn: turnsSplit) {
      if (turn.equals(MISSED_THROW)) {
        turnScore = 0;
      } else if (turn.equals(SPARE_THROW)) {
        return 10;
      } else {
        turnScore = parseInt(turn);
      }

      score = score + turnScore;
    }

    return score;
  }
}
