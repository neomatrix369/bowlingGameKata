package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class Frames {
  private static final String FRAME_SEPARATOR = "\\|";

  private final List<Frame> listOfFrames = new ArrayList<>();

  public Frames(String framesAsString) {
    String[] splitFrames = framesAsString.split(FRAME_SEPARATOR);

    for (String eachFrameAsString: splitFrames) {
      listOfFrames.add(Frame.create(eachFrameAsString));
    }
  }

  public int calculateScore() {
    int frameIndex = 0;
    int frameScore = 0;
    for (Frame frame: listOfFrames) {
      Frame thisFrame = getFrameFor(frameIndex);
      Frame nextFrame = getFrameFor(frameIndex + 1);

      frameScore += thisFrame.calculateScoreWith(nextFrame);
      frameIndex++;
    }

    return frameScore;
  }

  private Frame getFrameFor(int frameIndex) {
    if (frameIndex >= listOfFrames.size()) {
      return Frame.createDummyFrame();
    }
    return listOfFrames.get(frameIndex);
  }

  @Override
  public String toString() {
    return String.format("Frames:{%s}", listOfFrames);
  }
}
