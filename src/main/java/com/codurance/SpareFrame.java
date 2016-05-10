package com.codurance;

import static com.codurance.ThrowType.SPARE;

public class SpareFrame extends Frame {

  public SpareFrame(String eachFrameAsString) {
    super(eachFrameAsString);
  }

  @Override
  public int getScore(Frame nextFrame) {
    return SPARE.getScore() + nextFrame.getFirstThrow();
  }
}
