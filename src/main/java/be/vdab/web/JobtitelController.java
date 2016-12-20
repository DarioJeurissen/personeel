package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Jobtitel;
import be.vdab.services.JobtitelService;


@Controller
@RequestMapping("/jobtitels")
public class JobtitelController {
	private static final String JOBTITEL_VIEW = "jobtitels";

	private final JobtitelService jobtitelService;

	JobtitelController(JobtitelService jobtitelService) {
		this.jobtitelService = jobtitelService;
	}

	@GetMapping
	ModelAndView jobtitel() {
		return new ModelAndView(JOBTITEL_VIEW, "jobtitels", jobtitelService.findAll());
	}
	
	@GetMapping("{id}")
	ModelAndView read(@PathVariable String id) {
		ModelAndView modelAndView = new ModelAndView(JOBTITEL_VIEW);
		try{
			Jobtitel jobtitel = jobtitelService.findOne(Long.parseLong(id)).get();
			modelAndView.addObject("jobtitel", jobtitel);
			return modelAndView;
		} catch(Exception ex){
			return new ModelAndView("redirect:/jobtitels");
		}
	}
}