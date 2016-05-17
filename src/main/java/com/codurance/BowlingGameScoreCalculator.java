package com.codurance;

import static java.lang.Integer.parseInt;

public class BowlingGameScoreCalculator {

  private static final String MISSED_ROLL = "-";
  private static final String SPARE_ROLL = "/";
  private static final String NO_PINS = "";

  public int evaluate(String rolls) {
    int score = 0;
    for (int index = 0; index < rolls.length(); index++) {
      String roll = rollAt(rolls, index);
      String nextRoll = rollAt(rolls, index + 1);
      score += scoreFor(roll, nextRoll, index);
    }
    return score;
  }

  private String rollAt(String rolls, int index) {
    return index <= rolls.length() - 1
                ? String.valueOf(rolls.charAt(index))
                : "";
  }

  private int scoreFor(String roll, String nextRoll, int index) {
    if (roll.equals(NO_PINS) ||
        roll.equals(MISSED_ROLL) ||
        nextRoll.equals(SPARE_ROLL)) {
      return 0;
    }

    if (roll.equals(SPARE_ROLL)) {
      return 10 + ((index < 19) ? parseToNumber(nextRoll) : 0);
    }

    return parseToNumber(roll);
  }

  private int parseToNumber(String roll) {
    return roll.equals(NO_PINS) ? 0 : parseInt(roll);
  }
}
