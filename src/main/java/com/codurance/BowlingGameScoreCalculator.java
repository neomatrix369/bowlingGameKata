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
      switch (turn) {
        case MISSED_THROW:
          turnScore = 0;
          break;
        case SPARE_THROW:
          return 10;
        default:
          turnScore = parseInt(turn);
          break;
      }

      score = score + turnScore;
    }

    return score;
  }
}
