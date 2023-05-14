package assessment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import assessment.model.Match;
import assessment.model.Player;
import assessment.model.ScoreBoard;

public class ScoreBoardServiceImplTest {
	Match match;
	
	ScoreBoard scoreBoard;
	
	@Mock
	ScoreBoardService service;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		match = new Match();
		Player player1= new Player();
		player1.setName("Fetherer");
		player1.setCountry("Switzerland");
		player1.setScore(15);
		Player player2= new Player();
		player2.setName("Nadal");
		player2.setCountry("Sweden");
		player2.setScore(0);
		match.setPlayer1(player1);
		match.setPlayer2(player2);
		
		scoreBoard = new ScoreBoard();
		scoreBoard.setPlayerScore1(match.getPlayer1().getScore());
		scoreBoard.setPlayerScore2(match.getPlayer2().getScore());
		scoreBoard.setResult("Both are equal");
	}
	
	@Test
	public void testServePoints() {
		when(service.servePoints(match, "PLAYER1")).thenReturn(scoreBoard);
		assertEquals(scoreBoard.getPlayerScore1(), 15);
		assertEquals(scoreBoard.getPlayerScore2(), 0);
	}
}
