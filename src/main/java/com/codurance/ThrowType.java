package com.codurance;

public enum ThrowType {
  STRIKE("X", 10),
  SPARE("/", 10),
  MISS("-", 0);

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
}
