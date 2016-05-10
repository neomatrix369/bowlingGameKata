package com.codurance;

import static com.codurance.ThrowType.SPARE;
import static com.codurance.ThrowType.STRIKE;

public abstract class Frame {
  protected final Throw firstThrow;
  protected final Throw secondThrow;

  public Frame(String throwsInAFrame) {
    final String[] splitThrows = throwsInAFrame.split("");

    firstThrow = new Throw(splitThrows[0]);
    if (splitThrows.length > 1) {
      secondThrow = new Throw(splitThrows[1]);
    } else {
      secondThrow = new Throw("");
    }
  }

  public abstract int getScore(Frame nextFrame);

  protected int getScore() {
    return getFirstThrow() + getSecondThrow();
  }

  @Override
  public String toString() {
    return String.format("%s,%s", firstThrow, secondThrow);
  }

  public static Frame create(String eachFrameAsString) {
    if (STRIKE.isSameAs(eachFrameAsString)) {
      return new StrikeFrame(eachFrameAsString);
    } else if (SPARE.isSameAs(eachFrameAsString.substring(1))) {
      return new SpareFrame(eachFrameAsString);
    }
    return new PartiallyCompletedFrame(eachFrameAsString);
  }

  public int calculateScoreWith(Frame nextFrame) {
    return getScore(nextFrame);
  }

  public int getFirstThrow() {
    return firstThrow.getScore();
  }

  public int getSecondThrow() {
    return secondThrow.getScore();
  }
}
