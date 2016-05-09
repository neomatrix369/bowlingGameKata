package com.codurance;

import static com.codurance.ThrowType.SPARE;
import static com.codurance.ThrowType.STRIKE;

import java.util.ArrayList;
import java.util.List;

public class Frames {
  private static final String FRAME_SEPARATOR = "\\|";
  private static final int NO_SCORE = 0;

  private static final String EMPTY_STRING_REPLACEMENT = "00";

  private final List<Frame> list;

  public Frames(String frames) {
    String[] splitFrames = frames.split(FRAME_SEPARATOR);

    list = new ArrayList<>();
    for (String eachFrameAsString: splitFrames) {
      list.add(new Frame(eachFrameAsString));
    }
  }

  public int calculateScore(int frameIndex) {
    if (frameIndex >= list.size()) {
      return NO_SCORE;
    }

    Frame thisFrame = getFrame(frameIndex);
    if (thisFrame.isA(STRIKE)) {
      return calculateForStrike(frameIndex);
    } else if (thisFrame.isA(SPARE)) {
      return calculateForSpare(frameIndex);
    } else {
      return thisFrame.getScore();
    }
  }

  private int calculateForSpare(int forTheFrame) {
    Frame theNextFrame = getFrame(forTheFrame + 1);
    return SPARE.getScore() + theNextFrame.getFirstThrowScore();
  }

  private int calculateForStrike(int forTheFrame) {
    Frame theNextFrame = getFrame(forTheFrame + 1);
    return STRIKE.getScore() + theNextFrame.getScore();
  }

  private Frame getFrame(int frameIndex) {
    if (frameIndex >= list.size()) {
      return new Frame(EMPTY_STRING_REPLACEMENT);
    }
    return list.get(frameIndex);
  }

  @Override
  public String toString() {
    return String.format("Frames{%s}", list);
  }
}
