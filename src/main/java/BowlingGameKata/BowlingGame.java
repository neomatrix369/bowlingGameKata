package BowlingGameKata;

public class BowlingGame {
  private final String bowlerThrows;

  public BowlingGame(String bowlerThrows) {
    this.bowlerThrows = bowlerThrows;
  }

  public int getFrames() {
    return bowlerThrows.split("\\|").length;
  }
}
