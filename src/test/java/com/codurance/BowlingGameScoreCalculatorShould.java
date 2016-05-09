package com.codurance;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BowlingGameScoreCalculatorShould {

  private final String inputFrames;
  private final int expectedFrameScore;

  private BowlingGameScoreCalculator bowlingGameScoreCalculator;

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return asList(
        new Object[][] {
            {"X|",    10},
            {"X|64",  10 + 6 + 4},
            {"9-|",   9},
            {"5/|",   10},
            {"5/|23", 12}
        }
    );
  }

  @Before
  public void initialise() {
    bowlingGameScoreCalculator = new BowlingGameScoreCalculator();
  }

  public BowlingGameScoreCalculatorShould(String inputFrames, int expectedFrameScore) {
    this.inputFrames = inputFrames;
    this.expectedFrameScore = expectedFrameScore;
  }

  @Test
  public void
  calculate_frame_score_from_the_input_frames() {
    assertThat(getFrameScoreFor(inputFrames), is(expectedFrameScore));
  }

  private int getFrameScoreFor(String frames) {return bowlingGameScoreCalculator.evaluate(frames, 1);}
}
