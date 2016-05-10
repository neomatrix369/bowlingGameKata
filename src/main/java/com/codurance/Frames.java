package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class Frames {
  private static final String FRAME_SEPARATOR = "\\|";
  private static final int NO_SCORE = 0;

  private static final String EMPTY_STRING_REPLACEMENT = "00";

  private final List<Frame> list = new ArrayList<>();

  public Frames(String framesAsString) {
    String[] splitFrames = framesAsString.split(FRAME_SEPARATOR);

    for (String eachFrameAsString: splitFrames) {
      list.add(Frame.create(eachFrameAsString));
    }
  }

  public int calculateScore(int frameIndex) {
    frameIndex--;
    if (frameIndex >= list.size()) {
      return NO_SCORE;
    }

    Frame thisFrame = getFrame(frameIndex);
    Frame nextFrame = getFrame(frameIndex + 1);

    return thisFrame.calculateScoreWith(nextFrame);
  }

  private Frame getFrame(int frameIndex) {
    if (frameIndex >= list.size()) {
      return new PartiallyCompletedFrame(EMPTY_STRING_REPLACEMENT);
    }
    return list.get(frameIndex);
  }

  @Override
  public String toString() {
    return String.format("Frames:{%s}", list);
  }
}
