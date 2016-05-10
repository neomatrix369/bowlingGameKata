package com.codurance;

import static com.codurance.ThrowType.*;
import static java.lang.Integer.parseInt;

public class Throw {
  private final String throwOutcome;

  public Throw(String throwOutcome) {
    this.throwOutcome = throwOutcome;
  }

  public int getScore() {
    if (MISS.isSameAs(throwOutcome)) {
      return MISS.getScore();
    }

    return parseInt(throwOutcome);
  }

  @Override
  public String toString() {
    return String.format("%s", throwOutcome);
  }
}
