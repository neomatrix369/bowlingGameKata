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

  private BowlingGameScoreCalculator bowlingGameScoreCalculator;

  private String turns;
  private int score;

  public BowlingGameScoreCalculatorShould(String turns, int score) {
    this.turns = turns;
    this.score = score;
  }

  @Parameters( name = "{index}: {0} = {1}" )
  public static Collection<Object[]> data() {
    return asList(
        new Object[][] {
            {"11111111111111111111", 20},
            {"12131415161718191213", 59},
            {"-2-3-4-5-6-7-8-9-2-3", 49},
            {"1/2/3/4/5/6/7/8/9/1/2", 147}
        }
    );
  }

  @Before
  public void initialise() {
    bowlingGameScoreCalculator = new BowlingGameScoreCalculator();
  }

  @Test public void
  calculate_throws_in_each_turn_for_all_the_frames() {
      assertThat(bowlingGameScoreCalculator.evaluate(turns), is(score));
  } 
}
