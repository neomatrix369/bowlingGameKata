package com.codurance;

import static com.codurance.ThrowType.SPARE;
import static com.codurance.ThrowType.STRIKE;

public class Frame {
  private static final int FIRST_THROW = 0;
  private static final int SECOND_THROW = 1;

  private final Throw firstThrow;
  private final Throw secondThrow;

  public Frame(String throwsInAFrame) {
    final String[] splitThrows = throwsInAFrame.split("");

    firstThrow = new Throw(splitThrows[0]);
    if (splitThrows.length > 1) {
      secondThrow = new Throw(splitThrows[1]);
    } else {
      secondThrow = new Throw("");
    }
  }

  public boolean isA(ThrowType throwType) {
    return firstThrow().isSameAs(throwType) || secondThrow().isSameAs(throwType);
  }

  public Throw firstThrow() {
    return firstThrow;
  }

  public Throw secondThrow() {
    return secondThrow;
  }

  public int getScore() {
    return firstThrow.getScore() + secondThrow.getScore();
  }

  public int getFirstThrowScore() {
    return firstThrow.getScore();
  }

  public int calculateStrikeScore(Frame nextFrame) {
    return STRIKE.getScore() + nextFrame.getScore();
  }

  public int calculateSpareScore(Frame nextFrame) {
    return SPARE.getScore() + nextFrame.getFirstThrowScore();
  }

  @Override
  public String toString() {
    return String.format("%s,%s", firstThrow, secondThrow);
  }
}
