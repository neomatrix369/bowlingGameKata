package com.codurance;

import static java.lang.Integer.parseInt;

public class Frames {
  private static final String FRAME_SEPARATOR = "\\|";
  private static final int NO_SCORE = 0;

  private static final String STRIKE = "X";
  private static final int STRIKE_SCORE = 10;

  private static final String SPARE = "/";
  private static final int SPARE_SCORE = 10;

  private static final String MISS = "-";
  private static final int MISS_SCORE = 0;

  private static final String EMPTY_STRING_REPLACEMENT = "0";

  private final String[] frames;

  public Frames(String frames) {
    this.frames = frames.split(FRAME_SEPARATOR);
  }

  public int calculateScore(int forFrame) {
    if (forFrame >= frames.length) {
      return NO_SCORE;
    }

    int framesScore = 0;
    String thisFrame = getFrame(forFrame);

    if (thisFrame.equals(STRIKE)) {
      framesScore += calculateForStrike(forFrame);
    } else if (thisFrame.substring(1).equals(SPARE)) {
      framesScore += calculateForSpare(forFrame);
    } else {
      framesScore += calculateForOtherThrows(forFrame);
    }

    return framesScore;
  }

  private int calculateForOtherThrows(int forTheFrame) {
    final String firstThrow = firstThrowFrom(forTheFrame);
    final String secondThrow = secondThrowFrom(forTheFrame);

    return evaluateThisThrow(firstThrow) + evaluateThisThrow(secondThrow);
  }

  private int calculateForSpare(int forTheFrame) {
    final int theNextFrame = forTheFrame + 1;
    String firstThrow = firstThrowFrom(theNextFrame);
    return SPARE_SCORE + parseInt(firstThrow);
  }

  private int calculateForStrike(int forTheFrame) {
    final int forTheNextFrame = forTheFrame + 1;
    return STRIKE_SCORE + calculateScore(forTheNextFrame);
  }

  private String firstThrowFrom(int frame) {
    String thisFrame = getFrame(frame);
    return thisFrame.substring(0, 1);
  }

  private String secondThrowFrom(int frame) {
    String thisFrame = getFrame(frame);
    return thisFrame.substring(1);
  }

  private int evaluateThisThrow(String aThrow) {
    if (aThrow.equals(MISS)) {
      return MISS_SCORE;
    }
    return parseInt(aThrow);
  }

  private String getFrame(int frameIndex) {
    if (frameIndex >= frames.length) {
      return EMPTY_STRING_REPLACEMENT;
    }
    return frames[frameIndex];
  }
}
