package com.codurance;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameScoreCalculatorShould {

  private BowlingGameScoreCalculator bowlingGameScoreCalculator;

  @Before
  public void initialise() {
    bowlingGameScoreCalculator = new BowlingGameScoreCalculator();
  }

  @Test public void
  calculate_frame_score_for_a_strike_in_the_first_frame() {
    assertThat(getFrameScoreFor("X|"), is(10));
  }

  @Test public void
  calculate_frame_score_for_a_strike_and_two_throws_for_the_first_frame() {
    assertThat(getFrameScoreFor("X|64"), is(10 + 6 + 4));
  }
  
  @Test public void
  calculate_frame_score_for_9_pins_hit_and_a_miss_in_the_first_frame() {
    assertThat(getFrameScoreFor("9-|"), is(9));
  }

  @Test public void
  calculate_frame_score_for_5_pins_hit_and_a_spare_in_the_first_frame() {
    assertThat(getFrameScoreFor("5/|"), is(10));
  }

  private int getFrameScoreFor(String frames) {return bowlingGameScoreCalculator.evaluate(frames, 1);}
}
