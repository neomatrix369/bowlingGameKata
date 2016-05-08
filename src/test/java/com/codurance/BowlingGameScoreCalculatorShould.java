package com.codurance;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BowlingGameScoreCalculatorShould {
  @Test public void
  calculate_frame_score_for_a_strike_in_the_first_frame() {
    BowlingGameScoreCalculator bowlingGameScoreCalculator = new BowlingGameScoreCalculator();

    int frameScore = bowlingGameScoreCalculator.evaluate("X|", 1);

    assertThat(frameScore, is(10));
  }

  @Test public void
  calculate_frame_score_for_a_strike_and_two_throws_for_the_first_frame() {
    BowlingGameScoreCalculator bowlingGameScoreCalculator = new BowlingGameScoreCalculator();

    int frameScore = bowlingGameScoreCalculator.evaluate("X|64", 1);

    assertThat(frameScore, is(10 + 6 + 4));
  }
  
  @Test public void
  calculate_frame_score_for_9_pins_hit_and_a_miss_in_the_first_frame() {
    BowlingGameScoreCalculator bowlingGameScoreCalculator = new BowlingGameScoreCalculator();

    int frameScore = bowlingGameScoreCalculator.evaluate("9-|", 1);

    assertThat(frameScore, is(9));
  } 
}
