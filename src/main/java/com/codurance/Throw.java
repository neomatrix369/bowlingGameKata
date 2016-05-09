package com.codurance;

import static com.codurance.ThrowType.MISS;
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

  public boolean isSameAs(ThrowType throwType) {
    return throwType.isSameAs(throwOutcome);
  }
}
