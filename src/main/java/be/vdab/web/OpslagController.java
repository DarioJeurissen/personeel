package be.vdab.web;

import javax.persistence.OptimisticLockException;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Werknemer;
import be.vdab.services.WerknemerService;
import be.vdab.valueobjects.OpslagForm;

@Controller
@RequestMapping("/opslag")
public class OpslagController {
	private static final String OPSLAG_VIEW = "opslag";
	private static final String REDIRECT_URL_NA_WIJZIGEN = "redirect:/";

	private final WerknemerService werknemerService;

	OpslagController(WerknemerService werknemerService) {
		this.werknemerService = werknemerService;
	}

	@GetMapping
	ModelAndView init(){
		return new ModelAndView("redirect:/"); 
	}
	
	@GetMapping("{id}")
	ModelAndView read(@PathVariable String id) {
		ModelAndView modelAndView = new ModelAndView(OPSLAG_VIEW);
		try{
			modelAndView.addObject("opslagForm", new OpslagForm());
			Werknemer werknemer = (werknemerService.findOne(Long.parseLong(id))).get();
			modelAndView.addObject(werknemer);
			return modelAndView;
		}
		catch(Exception ex){
			return new ModelAndView("redirect:/");
		}
	}

	@PostMapping("{id}")
	ModelAndView opslag(@PathVariable String id, @Valid OpslagForm opslagForm, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("/opslag");
		if (! bindingResult.hasErrors()) {
			Werknemer werknemer = werknemerService.findOne(Long.parseLong(id)).get();
			werknemer.addSalaris(opslagForm.getBonus());
			try{
				werknemerService.save(werknemer);
				return new ModelAndView(REDIRECT_URL_NA_WIJZIGEN);
			}
			catch(OptimisticLockException ex){
				modelAndView.addObject("error", "Database was locked. Try again.");
			}
		}
		else{
			modelAndView.addObject("error", "Salaris moet groter dan 1 zijn.");
		}
		modelAndView.addObject("werknemer", werknemerService.findOne(Long.parseLong(id)).get());
		return modelAndView;
	}

	@InitBinder("opslagForm")
	void initBinderPostcodeReeks(DataBinder dataBinder) {
		dataBinder.setRequiredFields("bonus");
	}
}