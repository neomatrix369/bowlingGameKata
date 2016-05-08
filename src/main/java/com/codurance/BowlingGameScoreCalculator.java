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

  public int evaluate(String framesWithThrows, int forFrame) {
    int internalForFrame = forFrame - 1;
    String splitFrames[] =  framesWithThrows.split(FRAME_SEPARATOR);

    return getFrameScore(splitFrames, internalForFrame);
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
    } else if (eachFrame.substring(1).equals(SPARE)) {
      framesScore += evaluateFrameWithSpare(splitFrames, forFrame);
    } else {
      framesScore += evaluateOtherThrowsInTheFrame(eachFrame);
    }

    return framesScore;
  }

  private int evaluateFrameWithStrike(String[] splitFrames, int forFrame) {
    final int nextFrame = forFrame + 1;
    return STRIKE_SCORE + getFrameScore(splitFrames, nextFrame);
  }

  private int getFrameScore(String[] splitFrames, int nextFrame) {return evaluateFrame(splitFrames, nextFrame);}

  private int evaluateFrameWithSpare(String[] splitFrames, int forFrame) {
    final int nextFrame = forFrame + 1;
    String firstThrow = firstThrowFrom(splitFrames, nextFrame);
    return SPARE_SCORE + parseInt(firstThrow);
  }

  private String firstThrowFrom(String[] splitFrames, int frame) {
    if (frame >= splitFrames.length) {
      return "0";
    }

    String thisFrame = splitFrames[frame];
    return thisFrame.substring(0, 1);
  }

  private int evaluateOtherThrowsInTheFrame(String eachFrame) {
    final String firstThrow = eachFrame.substring(0, 1);
    final String secondThrow = eachFrame.substring(1);

    return evaluateThisThrow(firstThrow) + evaluateThisThrow(secondThrow);
  }

  private int evaluateThisThrow(String aThrow) {
    if (aThrow.equals(MISS)) {
      return MISS_SCORE;
    }
    return parseInt(aThrow);
  }
}
