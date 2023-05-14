package assessment.utils;

import assessment.model.Match;
import assessment.model.ScoreBoard;

public class ScoreBoardUtils {
	public static ScoreBoard convertMatchToScore(Match match, String status) {
		ScoreBoard score = new ScoreBoard();
		score.setPlayerScore1(match.getPlayer1().getScore());
		score.setPlayerScore2(match.getPlayer2().getScore());
		score.setResult(status);
		return score;
	}
}
