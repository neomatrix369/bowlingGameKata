package com.codurance;

import static java.lang.Integer.parseInt;

public class BowlingGameScoreCalculator {

  public int evaluate(String frames, int forFrame) {
    int internalForFrame = forFrame - 1;
    String splitFrames[] = frames.split("\\|");

    return evaluateFrame(splitFrames, internalForFrame);
  }

  private int evaluateFrame(String[] splitFrames, int forFrame) {
    if (forFrame >= splitFrames.length) {
      return 0;
    }

    return calculateFrameScore(splitFrames, forFrame);
  }

  private int calculateFrameScore(String[] splitFrames, int forFrame) {
    int framesScore = 0;
    String eachFrame = splitFrames[forFrame];

    if (eachFrame.equals("X")) {
      framesScore += 10 + evaluateFrame(splitFrames, forFrame + 1);
    } else {
      framesScore += evaluateTheThrow(eachFrame.substring(0, 1)) + evaluateTheThrow(eachFrame.substring(1));
    }

    return framesScore;
  }

  private int evaluateTheThrow(String aThrow) {
    if (aThrow.equals("-")) {
      return 0;
    }
    return parseInt(aThrow);
  }
}
