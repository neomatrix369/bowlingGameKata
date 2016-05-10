package com.codurance;

import static com.codurance.ThrowType.STRIKE;

public class StrikeFrame extends Frame {

  public StrikeFrame(String throwsInAFrame) {
    super(throwsInAFrame);
  }

  @Override
  public int getScore(Frame nextFrame) {
    return STRIKE.getScore() + nextFrame.getScore();
  }
}
