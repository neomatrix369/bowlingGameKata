package com.codurance;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BowlingGameScoreCalculatorShould {

  private BowlingGameScoreCalculator bowlingGameScoreCalculator;

  private String turns;
  private int expectedScore;

  public BowlingGameScoreCalculatorShould(String turns, int expectedScore) {
    this.turns = turns;
    this.expectedScore = expectedScore;
  }

  @Parameters( name = "{index}: {0} = {1}" )
  public static Collection<Object[]> data() {
    return asList(
        new Object[][] {
            {"1-", 1},
            {"-1", 1},
            {"11", 2},
            {"21", 3},
        }
    );
  }

  @Before
  public void initialise() {
    bowlingGameScoreCalculator = new BowlingGameScoreCalculator();
  }

  @Test public void
  calculate_the_score_of_throws_in_a_frames() {
      assertThat(bowlingGameScoreCalculator.evaluate(turns), is(expectedScore));
  } 
}
