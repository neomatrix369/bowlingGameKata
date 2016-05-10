package com.codurance;

public class PartiallyCompletedFrame extends Frame {

  public PartiallyCompletedFrame(String eachFrameAsString) {
    super(eachFrameAsString);
  }

  @Override
  public int getScore(Frame nextFrame) {
    return getScore();
  }
}
