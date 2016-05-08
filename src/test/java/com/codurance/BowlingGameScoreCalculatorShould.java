package com.codurance;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BowlingGameScoreCalculatorShould {
  @Test public void
  calculate_frame_score_for_a_strike() {
    BowlingGameScoreCalculator bowlingGameScoreCalculator = new BowlingGameScoreCalculator();

    int frameScore = bowlingGameScoreCalculator.evaluate("X|");

    assertThat(frameScore, is(10));
  } 

}
