package assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import assessment.model.Match;
import assessment.model.ScoreBoard;
import assessment.service.ScoreBoardService;

@RestController
@RequestMapping("/score")
public class ScoreBoardController {
	
	private static Match match = new Match();
	
	@Autowired
	private ScoreBoardService boardService;
	
	private void init(Match matchInit) {
		match.setPlayer1(matchInit.getPlayer1());
		match.setPlayer2(matchInit.getPlayer2());
	}
	
	@PostMapping("/serve/{scorer}")
	public ResponseEntity<ScoreBoard> servePoints(@PathVariable String scorer) {
		ScoreBoard score =boardService.servePoints(match, scorer);
		return new ResponseEntity<>(score, HttpStatus.OK);
	}
	
	@PostMapping("/initiate")
	public ResponseEntity<ScoreBoard> initiateMatch(@RequestBody Match match) {
		init(match);
		ScoreBoard score = boardService.initiateTheGame(match);
		return new ResponseEntity<>(score, HttpStatus.OK);
	}
	
	@GetMapping("/getscore")
	public ResponseEntity<ScoreBoard> getScoreBoard(){
		ScoreBoard score = boardService.getScore(match);
		return new ResponseEntity<>(score, HttpStatus.OK);
	}
}
