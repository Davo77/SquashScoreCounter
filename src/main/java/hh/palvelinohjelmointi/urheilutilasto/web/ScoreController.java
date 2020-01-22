package hh.palvelinohjelmointi.urheilutilasto.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import hh.palvelinohjelmointi.urheilutilasto.domain.ResourceNotFoundException;
import hh.palvelinohjelmointi.urheilutilasto.domain.Score;
import hh.palvelinohjelmointi.urheilutilasto.domain.ScoreRepository;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;

@RestController
@RequestMapping("/api/v1")
public class ScoreController {
    @Autowired
    private ScoreRepository scoreRepository;

 //   @Configuration
    public class ResourceConfig implements WebMvcConfigurer {

        @Override
        public void addResourceHandlers(final ResourceHandlerRegistry registry) {
            registry.addResourceHandler("../static/images/**").addResourceLocations("file:images//");
        }

        @Override
        public void configurePathMatch(PathMatchConfigurer pmc) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void configureContentNegotiation(ContentNegotiationConfigurer cnc) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void configureAsyncSupport(AsyncSupportConfigurer asc) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer dshc) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addFormatters(FormatterRegistry fr) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addInterceptors(InterceptorRegistry ir) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addCorsMappings(CorsRegistry cr) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addViewControllers(ViewControllerRegistry vcr) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void configureViewResolvers(ViewResolverRegistry vrr) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void configureMessageConverters(List<HttpMessageConverter<?>> list) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void extendMessageConverters(List<HttpMessageConverter<?>> list) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Validator getValidator() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public MessageCodesResolver getMessageCodesResolver() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
	
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
/*    
    @PostMapping("/score")
    public Score createScore(@Valid @RequestBody Score score) {
        return scoreRepository.save(score);
    }

    @PutMapping("/score/{id}")
    public ResponseEntity<Score> updateScore(@PathVariable(value = "id") Long Id,
         @Valid @RequestBody Score scoreDetails) throws ResourceNotFoundException {
        Score score = scoreRepository.findById(Id)
        //.orElseThrow(() -> new ResourceNotFoundException("Score not found for this id :: " + Id));

        score.setPlayer1name(scoreDetails.getPlayer1name());
        score.setPlayer2name(scoreDetails.getPlayer2name());
        final Score updatedScore = scoreRepository.save(score);
        return ResponseEntity.ok(updatedScore);
    }
*/
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
		return "redirect:scorelist";
    }

	// SAVE PLAYER NAMES
	@RequestMapping(value = "/savePlayer", method = RequestMethod.POST)
	public String savePlayer(Score score) {
		scoreRepository.save(score);
		//return "redirect:scorelist";
		return "addscore";
	}

    @DeleteMapping("/score/{id}")
    public Map<String, Boolean> deleteScore(@PathVariable(value = "id") Long Id)
         throws ResourceNotFoundException {
        Score score = scoreRepository.findById(Id)
       .orElseThrow(() -> new ResourceNotFoundException("Score not found for this id :: " + Id));

        scoreRepository.delete(score);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}