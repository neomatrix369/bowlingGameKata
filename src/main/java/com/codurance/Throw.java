package com.codurance;

import static java.lang.Integer.parseInt;

public class Throw {
  private final String throwAsString;

  public Throw(String throwAsString) {
    this.throwAsString = throwAsString;
  }

  public int evaluate() {
    if (throwAsString.isEmpty()) {
      return 0;
    }
    return parseInt(throwAsString);
  }
}
