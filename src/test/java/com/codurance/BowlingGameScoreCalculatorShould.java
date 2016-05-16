package com.codurance;

import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BowlingGameScoreCalculatorShould {

  private BowlingGameScoreCalculator bowlingGameScoreCalculator;

  @Parameters( name = "{index}: {0} = {1}" )
  public static Collection<Object[]> data() {
    return asList(
        new Object[][] {
        }
    );
  }

  @Before
  public void initialise() {
    bowlingGameScoreCalculator = new BowlingGameScoreCalculator();
  }

}
