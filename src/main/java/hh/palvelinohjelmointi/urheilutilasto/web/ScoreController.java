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
	private ScoreRepository repository;

	@RequestMapping(value = "/scorelist", method = RequestMethod.GET)
	public String TulosController(Model model) {
		model.addAttribute("scorelist", scoreRepository.findAll());
		return "scorelist";
	}

    // Add SCORE
    @RequestMapping(value = "/add")
    public String addScore(Model model){
    	model.addAttribute("score", new Score());
    	model.addAttribute("scores", repository.findAll());
        return "addscore";
    }     

	// SAVE SCORE
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Score score) {
		scoreRepository.save(score);
		return "redirect:scorelist";
	}

	// DELETE SCORE
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteTulos(@PathVariable("id") Long gameid, Model model) {
		scoreRepository.deleteById(gameid);
		return "redirect:../scorelist";
	}

@RequestMapping(value="/login")
public String login() {	
    return "login";
}	
}

