package hh.palvelinohjelmointi.urheilutilasto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hh.palvelinohjelmointi.urheilutilasto.domain.Score;
import hh.palvelinohjelmointi.urheilutilasto.domain.ScoreRepository;

@Controller
public class ScoreController {

	@Autowired
	private ScoreRepository scoreRepository;
	@Autowired
	private ScoreRepository drepository;
	
	//private static List<Score> scores = new ArrayList<Score>();

	@RequestMapping(value = "/scorelist", method = RequestMethod.GET)
	public String scoreController(Model model) {
		model.addAttribute("score", scoreRepository.findAll());
		//model.addAttribute(scores);
		
		return "scorelist";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String playerNames(Model model) {
		model.addAttribute("score", new Score());
		return "welcome";
	}

    // Add SCORE
    @RequestMapping(value = "/add")
    public String addScore(Model model){
    	model.addAttribute("score", new Score());
    	// model.addAttribute("scores", repository.findAll());
        return "addscore";
    }     

	// SAVE SCORE
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Score score) {
		scoreRepository.save(score);
		
	//	List<Score> scores = ScoreList.getScores();
	//	scoreRepository.save(scores);
		return "redirect:scorelist";
		//return "addscore";
	}
	
	// SAVE PLAYER NAMES
	@RequestMapping(value = "/savePlayer", method = RequestMethod.POST)
	public String savePlayer(Score score) {
		scoreRepository.save(score);
		//return "redirect:scorelist";
		return "addscore";
	}

	// DELETE SCORE
	@RequestMapping(value = "/delete/{gameid}", method = RequestMethod.GET)
	public String deleteTulos(@PathVariable("gameid") Long gameid, Model model) {
		scoreRepository.deleteById(gameid);
		return "redirect:../scorelist";
	}
	
	// EDIT SCORE
	@RequestMapping(value = "/edit/{gameid}", method = RequestMethod.GET)
	public String editBook(@PathVariable("gameid") Long gameId, Model model) {
		model.addAttribute("score", scoreRepository.findById(gameId));
		model.addAttribute("scores", drepository.findAll());
		return "editscore";
	}
@RequestMapping(value="/login")
public String login() {	
    return "login";
}	
}

