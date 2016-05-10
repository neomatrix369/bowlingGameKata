package com.codurance;

public class DummyFrame extends Frame {

  private static final int NO_SCORE = 0;

  public DummyFrame(String throwsInAFrame) {
    super(throwsInAFrame);
  }

  @Override
  public int getScore(Frame nextFrame) {
    return NO_SCORE;
  }
}
