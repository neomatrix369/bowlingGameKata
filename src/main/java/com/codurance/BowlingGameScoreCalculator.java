package com.codurance;

import static java.lang.Integer.parseInt;

public class BowlingGameScoreCalculator {

  private static final String STRIKE = "X";
  private static final int STRIKE_SCORE = 10;

  private static final String MISS = "-";
  private static final String FRAME_SEPARATOR = "\\|";

  public int evaluate(String frames, int forFrame) {
    int internalForFrame = forFrame - 1;
    String splitFrames[] = frames.split(FRAME_SEPARATOR);

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

    if (eachFrame.equals(STRIKE)) {
      framesScore += evaluateFrameWithStrike(splitFrames, forFrame);
    } else {
      framesScore += evaluateOtherThrowsInFrame(eachFrame);
    }

    return framesScore;
  }

  private int evaluateFrameWithStrike(String[] splitFrames, int forFrame) {
    final int nextFrame = forFrame + 1;
    return STRIKE_SCORE + evaluateFrame(splitFrames, nextFrame);
  }

  private int evaluateOtherThrowsInFrame(String eachFrame) {return evaluateThisThrow(eachFrame.substring(0, 1)) + evaluateThisThrow(eachFrame.substring(1));}

  private int evaluateThisThrow(String aThrow) {
    if (aThrow.equals(MISS)) {
      return 0;
    }
    return parseInt(aThrow);
  }
}
