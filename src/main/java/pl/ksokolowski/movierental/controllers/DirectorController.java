package pl.ksokolowski.movierental.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.ksokolowski.movierental.domain.CountryOfProduction;
import pl.ksokolowski.movierental.domain.Director;
import pl.ksokolowski.movierental.service.CountryOfProductionService;
import pl.ksokolowski.movierental.service.DirectorService;
import pl.ksokolowski.movierental.validators.DirectorValidator;

@Controller
@SessionAttributes
public class DirectorController {

	@Autowired
	DirectorService directorService;

	DirectorValidator directorValidator = new DirectorValidator();

	@RequestMapping("/directors")
	public String listDirectors(Map<String, Object> map, HttpServletRequest request) {

		int directorsId = ServletRequestUtils.getIntParameter(request, "directorId", -1);

		if (directorsId > 0)
			map.put("director", directorService.getDirector(directorsId));
		else
			map.put("director", new Director());

		map.put("directorList", directorService.listDirector());

		return "director";
	}

	@RequestMapping(value = "/addDirector", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("director") Director director, BindingResult result,
			Map<String, Object> map) {

		directorValidator.validate(director, result);
		if (result.getErrorCount() == 0) {
			if (director.getId() == 0)
				directorService.addDirector(director);
			else
				directorService.editDirector(director);

			System.out.println("Rezyser: " + director.getFirstName() + " " + director.getLastName());

			return "redirect:directors.html";
		}
		map.put("directorList", directorService.listDirector());

		return "director";
	}
}
