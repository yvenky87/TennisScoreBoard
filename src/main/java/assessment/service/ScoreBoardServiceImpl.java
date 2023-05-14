package assessment.service;

import org.springframework.stereotype.Service;

import assessment.model.Match;
import assessment.model.ScoreBoard;
import assessment.utils.ScoreBoardConstants;
import assessment.utils.ScoreBoardUtils;

@Service
public class ScoreBoardServiceImpl implements ScoreBoardService{

	@Override
	public ScoreBoard servePoints(Match match, String scorer) {
		if(scorer.equals(ScoreBoardConstants.PLAYER1)) {
			match.getPlayer1().setScore(Integer.parseInt(getScore(match.getPlayer1().getScore())));
			match.setMatchStatus(getMatchStatus(match));
		}else {
			match.getPlayer2().setScore(Integer.parseInt(getScore(match.getPlayer2().getScore())));
			match.setMatchStatus(match.getPlayer2().getName()+" is Leading");
			match.setMatchStatus(getMatchStatus(match));
		}
		return ScoreBoardUtils.convertMatchToScore(match, match.getMatchStatus());
	}

	@Override
	public ScoreBoard initiateTheGame(Match match) {
		match.setMatchStatus("Begin");
		return ScoreBoardUtils.convertMatchToScore(match, "Match In Progress");
	}

	@Override
	public ScoreBoard getScore(Match match) {
		// TODO Auto-generated method stub
		return ScoreBoardUtils.convertMatchToScore(match, "Match In Progress");
	}
	
	private String getScore(int value) {
		if(value == 0) {
			return "";
		}
		switch(value) {
		case 0 : return "15";
		case 15 : return "30";
		case 30 : return "40";
		default : return "";
		}
	}
	
	private String getMatchStatus(Match match) {
		int player1Score = match.getPlayer1().getScore();
		int player2Score = match.getPlayer2().getScore();
		if(player1Score == player2Score && player1Score !=40 && player2Score !=40 ) {
			return "Scores are level";
		}
		else if(player1Score == player2Score && player1Score ==40 && player2Score ==40) {
			return "Deuce";
		}
		else if(player2Score > player2Score)
			return match.getPlayer1().getName()+" is Leading";
		else
			return match.getPlayer2().getName()+" is Leading";
	}

}
