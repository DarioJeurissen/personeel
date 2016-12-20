package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Werknemer;
import be.vdab.services.WerknemerService;


@Controller
@RequestMapping("/hierarchie")
public class WerknemerController {
	private static final String WERKNEMER_VIEW = "hierarchie";

	private final WerknemerService werknemerService;

	WerknemerController(WerknemerService werknemerService) {
		this.werknemerService = werknemerService;
	}

	
	@GetMapping
	ModelAndView hierarchie() {
		return new ModelAndView(WERKNEMER_VIEW, "werknemer", werknemerService.findByChef(null).orElse(null));
	}
	
	@GetMapping("{id}")
	ModelAndView read(@PathVariable String id) {
		ModelAndView modelAndView = new ModelAndView(WERKNEMER_VIEW);
		try{
			Werknemer werknemer = (werknemerService.findOne(Long.parseLong(id))).get();
			modelAndView.addObject(werknemer);
			return modelAndView;
		}
		catch(Exception ex){
			return new ModelAndView("redirect:/hierarchie");
		}
	}
}