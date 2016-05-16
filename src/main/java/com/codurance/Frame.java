package com.codurance;

public class Frame {
  private static final String NOTHING = "";

  private Throw firstThrow;
  private Throw secondThrow = new Throw(NOTHING);

  public Frame(String throwsInAFrame) {
    firstThrow = new Throw(throwsInAFrame.substring(0, 1));
    if (throwsInAFrame.length() > 0) {
      secondThrow = new Throw(throwsInAFrame.substring(1));
    }
  }

  public int evaluate() {
    return firstThrow.evaluate() + secondThrow.evaluate();
  }
}
