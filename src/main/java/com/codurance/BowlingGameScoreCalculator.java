package com.codurance;

import static java.lang.Integer.parseInt;

public class BowlingGameScoreCalculator {

  private static final String TURNS_SEPARATOR = "";

  private static final String MISSED_THROW = "-";
  private static final String SPARE_THROW = "/";
  private static final String NO_THROW = "";

  public int evaluate(String turns) {
    String[] splitTurns = turns.split(TURNS_SEPARATOR);

    int score = 0;
    int index = 0;
    while (index < turns.length()) {
      String turn = splitTurns[index];
      String nextTurn = "";
      if (index < turns.length() - 1) {
        nextTurn = splitTurns[index + 1];
        if (turn.equals(SPARE_THROW) &&
            index == 19) {
          nextTurn = "";
        }
      }

      score += getScoreForTheThrow(turn, nextTurn);
      index++;
    }

    return score;
  }

  private int getScoreForTheThrow(String thisThrow, String nextThrow) {
    if (thisThrow.equals(NO_THROW) ||
        thisThrow.equals(MISSED_THROW) ||
        nextThrow.equals(SPARE_THROW)) {
      return 0;
    }

    if (thisThrow.equals(SPARE_THROW)) {
      return 10 + parseToNumber(nextThrow);
    }

    return parseToNumber(thisThrow);
  }

  private int parseToNumber(String nextTurn) {
    if (nextTurn.equals(NO_THROW)) {
      return 0;
    }

    return parseInt(nextTurn);
  }
}
