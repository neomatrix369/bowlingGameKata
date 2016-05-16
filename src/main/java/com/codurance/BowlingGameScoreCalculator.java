package com.codurance;

import static java.lang.Integer.parseInt;

public class BowlingGameScoreCalculator {

  private static final String MISSED_THROW = "-";
  private static final String SPARE_THROW = "/";
  private static final String STRIKE = "X";

  private static final String SPLIT_DELIMETER = "";

  public int evaluate(String turns) {
    String[] splitTurns = turns.split(SPLIT_DELIMETER);

    int score = 0;
    int turnScore;
    for (String pinsKnocked: splitTurns) {
      switch (pinsKnocked) {
        case MISSED_THROW:
          turnScore = 0;
          break;
        case SPARE_THROW:
        case STRIKE:
          turnScore = 10;
          break;
        default:
          turnScore = parseInt(pinsKnocked);
          break;
      }

      score = score + turnScore;
    }

    return score;
  }
}
