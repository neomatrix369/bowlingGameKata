package com.codurance;

import static java.lang.Integer.parseInt;

public class BowlingGameScoreCalculator {

  private static final String STRIKE = "X";
  private static final int STRIKE_SCORE = 10;

  private static final String SPARE = "/";
  private static final int SPARE_SCORE = 10;

  private static final String MISS = "-";
  private static final int MISS_SCORE = 0;

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
      framesScore += evaluateOtherThrowsInTheFrame(eachFrame);
    }

    return framesScore;
  }

  private int evaluateFrameWithStrike(String[] splitFrames, int forFrame) {
    final int nextFrame = forFrame + 1;
    return STRIKE_SCORE + evaluateFrame(splitFrames, nextFrame);
  }

  private int evaluateOtherThrowsInTheFrame(String eachFrame) {
    final String firstThrow = eachFrame.substring(0, 1);
    final String secondThrow = eachFrame.substring(1);

    if (secondThrow.equals(SPARE)) {
      return SPARE_SCORE;
    }

    return evaluateThisThrow(firstThrow) + evaluateThisThrow(secondThrow);
  }

  private int evaluateThisThrow(String aThrow) {
    if (aThrow.equals(MISS)) {
      return MISS_SCORE;
    }
    return parseInt(aThrow);
  }
}
