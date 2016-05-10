package com.codurance;

import static java.lang.Integer.parseInt;

public enum ThrowType {
  STRIKE("X", 10),
  SPARE("/", 10),
  MISS("-", 0),
  NO_THROW("", 0);

  private String symbol;
  private int score;

  ThrowType(String symbol, int score) {
    this.symbol = symbol;
    this.score = score;
  }

  public int getScore() {
    return score;
  }

  public boolean isSameAs(String symbol) {
    return this.symbol.equals(symbol);
  }

  public static int getScoreFor(String throwOutcome) {
    for (ThrowType throwType: values()) {
      if (throwType.isSameAs(throwOutcome)) {
        return throwType.getScore();
      }
    }
    return parseInt(throwOutcome);
  }
}
