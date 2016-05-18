package com.codurance;

import static java.lang.Integer.parseInt;

public class BowlingGameScoreCalculator {

  private static final String MISSED_ROLL = "-";
  private static final String SPARE_ROLL = "/";
  private static final String NO_PINS = "";
  private static final String STRIKE_ROLL = "X";

  public int evaluate(String rolls) {
    int score = 0;
    for (int index = 0; index < rolls.length(); index++) {
      String roll = rollAt(rolls, index);
      String nextRoll = rollAt(rolls, index + 1);
      String nextToNextRoll = rollAt(rolls, index + 2);
      score += scoreFor(roll, nextRoll, nextToNextRoll, index);
    }
    return score;
  }

  private String rollAt(String rolls, int index) {
    return index <= rolls.length() - 1
                ? String.valueOf(rolls.charAt(index))
                : "";
  }

  private int scoreFor(String roll, String nextRoll, String nextToNextRoll, int index) {
    if (roll.equals(NO_PINS) ||
        roll.equals(MISSED_ROLL) ||
        nextRoll.equals(SPARE_ROLL)) {
      return 0;
    }

    if (roll.equals(SPARE_ROLL)) {
      return 10 + (isBonusBallFromSpares(index) ? parseToNumber(nextRoll) : 0);
    }

    if (roll.equals(STRIKE_ROLL)) {
      return 10
          + (isBonusBallFromStrikes(index) ? parseToNumber(nextRoll) : 0)
          + (isBonusBallFromStrikes(index) ? parseToNumber(nextToNextRoll) : 0);
    }

    return parseToNumber(roll);
  }

  private boolean isBonusBallFromSpares(int index) {return index <  19;}

  private boolean isBonusBallFromStrikes(int index) {return index < 9;}

  private int parseToNumber(String roll) {
    return roll.equals(NO_PINS) || roll.equals(MISSED_ROLL)
        ? 0
        : roll.equals(STRIKE_ROLL) ? 10 : parseInt(roll);
  }
}
