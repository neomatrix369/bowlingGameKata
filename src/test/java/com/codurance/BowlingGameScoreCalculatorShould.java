package com.codurance;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BowlingGameScoreCalculatorShould {

  private final Frames inputFrames;
  private final int expectedFrameScore;

  private BowlingGameScoreCalculator bowlingGameScoreCalculator;

  @Parameters( name = "{index}: {0} = {1}" )
  public static Collection<Object[]> data() {
    return asList(
        new Object[][] {
            { new Frames("X|"),   10         },
            { new Frames("X|64"), 10 + 6 + 4 },
            { new Frames("9-|"),   9         },
            { new Frames("-6|"),   6         },
            { new Frames("5/|"),   5 + 5     },
            { new Frames("5/|23"), 5 + 5 + 2 }
        }
    );
  }

  @Before
  public void initialise() {
    bowlingGameScoreCalculator = new BowlingGameScoreCalculator();
  }

  public BowlingGameScoreCalculatorShould(Frames inputFrames, int expectedFrameScore) {
    this.inputFrames = inputFrames;
    this.expectedFrameScore = expectedFrameScore;
  }

  @Test
  public void
  calculate_frame_score_from_the_input_frames() {
    assertThat(bowlingGameScoreCalculator.evaluate(inputFrames, 1), is(expectedFrameScore));
  }
}
