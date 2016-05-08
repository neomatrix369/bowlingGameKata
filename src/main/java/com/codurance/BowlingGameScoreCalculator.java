package com.codurance;

import static java.lang.Integer.parseInt;

public class BowlingGameScoreCalculator {

  private static final String STRIKE = "X";
  private static final int STRIKE_SCORE = 10;

  private static final String SPARE = "/";
  private static final int SPARE_SCORE = 10;

  private static final String MISS = "-";
  private static final int MISS_SCORE = 0;

  private static final int NO_SCORE = 0;

  private static final String FRAME_SEPARATOR = "\\|";
  private static final String EMPTY_STRING_REPLACEMENT = "0";

  private String[] splitFrames;

  public int evaluate(String framesWithThrows, int forFrame) {
    splitFrames = framesWithThrows.split(FRAME_SEPARATOR);

    return evaluateScore(forFrame - 1);
  }

  private int evaluateScore(int forFrame) {
    if (forFrame >= splitFrames.length) {
      return NO_SCORE;
    }

    return calculateScore(forFrame);
  }

  private int calculateScore(int forFrame) {
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

  private int calculateForOtherThrows(int forFrame) {
    final String firstThrow = firstThrowFrom(forFrame);
    final String secondThrow = secondThrowFrom(forFrame);

    return evaluateThisThrow(firstThrow) + evaluateThisThrow(secondThrow);
  }

  private String getFrame(int frame) {
    if (frame >= splitFrames.length) {
      return EMPTY_STRING_REPLACEMENT;
    }
    return splitFrames[frame];
  }

  private int calculateForStrike(int forTheFrame) {
    final int forTheNextFrame = forTheFrame + 1;
    return STRIKE_SCORE + evaluateScore(forTheNextFrame);
  }

  private int calculateForSpare(int forFrame) {
    final int theNextFrame = forFrame + 1;
    String firstThrow = firstThrowFrom(theNextFrame);
    return SPARE_SCORE + parseInt(firstThrow);
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
}
