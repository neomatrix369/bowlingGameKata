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
            {"--------------------",    0},
            {"1-1----------------1",    3},
            {"9-9-9-9-9-9-9-9-9-9-",   90},
            {"11111111111111111111",   20},
            {"11111111112222222222",   30},
            {"12131415161718191213",   59},
            {"-2-3-4-5-6-7-8-9-2-3",   49},
            {"5/11------------3/11",   26},
            {"5/5/5/5/5/5/5/5/5/5/5", 150},
            {"1/2/3/4/5/6/7/8/9/1/2", 147},
            {"1/2/3/4/5/6/-/8/9/1/-", 138},
            {"XXXXXXXXXXXX",          300},
            {"XXXXXXXXXXX-",          290},
            {"XXXXXXXXXX-X",          280},
            {"XXXXXXXXXX11",          273},
            {"XXXXXXXXXX--",          270},
            {"X12XXXXXXXXXXX",        256},
            {"X12X5/XXXXXXXX",        236},
            {"X12X5/XXXXXX--",        206}
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
