package com.codurance;

import static com.codurance.ThrowType.getScoreFor;

public class Throw {
  private final String throwOutcome;

  public Throw(String throwOutcome) {
    this.throwOutcome = throwOutcome;
  }

  public int getScore() {
    return getScoreFor(throwOutcome);
  }

  @Override
  public String toString() {
    return String.format("%s", throwOutcome);
  }
}
