package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class Frame {
  private static final int FIRST_THROW = 0;
  private static final int SECOND_THROW = 1;

  private final List<Throw> throwsList = new ArrayList<>();

  public Frame(String throwsList) {
    final String[] splitThrows = throwsList.split("");

    for (String eachThrow: splitThrows) {
      this.throwsList.add(new Throw(eachThrow));
    }
  }

  public boolean isA(ThrowType throwType) {
    return firstThrow().isSameAs(throwType) || secondThrow().isSameAs(throwType);
  }

  public Throw firstThrow() {
    return throwsList.get(FIRST_THROW);
  }

  public Throw secondThrow() {
    return throwsList.get(SECOND_THROW);
  }

  public int getScore() {
    return firstThrow().getScore() + secondThrow().getScore();
  }

  public int getFirstThrowScore() {
    return firstThrow().getScore();
  }

  @Override
  public String toString() {
    return String.format("%s", throwsList);
  }
}
