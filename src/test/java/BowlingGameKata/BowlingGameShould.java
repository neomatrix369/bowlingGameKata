package BowlingGameKata;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

import org.junit.Test;

public class BowlingGameShould {

  @Test public void
  contain_ten_frames_when_game_completed() {
    int frames = playGame("1|2|3|4|5|6|7|8|9|X");

    assertThat(frames, is(10));
  }

  @Test public void
  contain_less_than_ten_frames_when_game_has_not_finished() {
    int frames = playGame("1|2|3");

    assertThat(frames, is(lessThan(10)));
  }

  @Test public void
  contains_7_frames_when_player_has_played_7_turns() {
    int frames = playGame("1|2|3|4|5|6|7");

    assertThat(frames, is(7));
  }

  private int playGame(String bowlerThrows) {
    final BowlingGame bowlingGame = new BowlingGame(bowlerThrows);
    return bowlingGame.getFrames();
  }
}
