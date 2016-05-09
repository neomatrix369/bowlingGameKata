package com.codurance;

import static com.codurance.ThrowType.MISS;
import static java.lang.Integer.parseInt;

public class Frame {
  private final String throwsInAFrame;

  public Frame(String throwsInAFrame) {
    this.throwsInAFrame = throwsInAFrame;
  }

  public boolean firstThrowIsA(ThrowType throwType) {
    return throwType.isSameAs(firstThrow());
  }

  public boolean secondThrowIsA(ThrowType throwType) {
    return throwType.isSameAs(secondThrow());
  }

  public String firstThrow() {
    return throwsInAFrame.substring(0, 1);
  }

  public String secondThrow() {
    return throwsInAFrame.substring(1);
  }

  public int getScore() {
    final String firstThrow = firstThrow();
    final String secondThrow = secondThrow();

    return calculateScore(firstThrow) + calculateScore(secondThrow);
  }

  private int calculateScore(String aThrow) {
    if (MISS.isSameAs(aThrow)) {
      return MISS.getScore();
    }
    return parseInt(aThrow);
  }

  public int getFirstThrowScore() {
    return parseInt(firstThrow());
  }

  @Override
  public String toString() {
    return String.format("%s", throwsInAFrame);
  }
}
