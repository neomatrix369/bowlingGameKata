package com.codurance;

public class BowlingGameScoreCalculator {

  public int evaluate(Frames framesWithThrows, int forFrame) {
    return framesWithThrows.calculateScore(forFrame);
  }
}
