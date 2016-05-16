package com.codurance;

import static java.lang.Integer.parseInt;

public class BowlingGameScoreCalculator {

  private static final String TURNS_SEPARATOR = "";
  private static final String MISSED_THROW = "-";

  public int evaluate(String turns) {
    String[] splitTurns = turns.split(TURNS_SEPARATOR);

    int score = 0;
    for (String turn: splitTurns) {
      score += getScoreForTheTurn(turn);
    }

    return score;
  }

  private int getScoreForTheTurn(String turn) {
    if (turn.equals(MISSED_THROW)) {
        return 0;
    }
    return parseInt(turn);
  }
}
