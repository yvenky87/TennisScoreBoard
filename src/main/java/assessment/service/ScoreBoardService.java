package assessment.service;

import assessment.model.Match;
import assessment.model.ScoreBoard;

public interface ScoreBoardService {
	ScoreBoard servePoints(Match match, String scorer);
	
	ScoreBoard initiateTheGame(Match match);
	
	ScoreBoard getScore(Match match);
}
