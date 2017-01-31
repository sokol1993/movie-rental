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

import pl.ksokolowski.movierental.domain.Genre;
import pl.ksokolowski.movierental.domain.ProducitonYear;
import pl.ksokolowski.movierental.service.GenreService;
import pl.ksokolowski.movierental.service.ProducitonYearService;
import pl.ksokolowski.movierental.validators.ProducitonYearValidator;

@Controller
@SessionAttributes
public class ProducitonYearController {
	@Autowired
	ProducitonYearService producitonYearService;

	ProducitonYearValidator yearValidator = new ProducitonYearValidator();

	@RequestMapping("/years")
	public String listYears(Map<String, Object> map, HttpServletRequest request) {

		int yearsId = ServletRequestUtils.getIntParameter(request, "yearId", -1);

		if (yearsId > 0)
			map.put("producitonYear", producitonYearService.getYear(yearsId));
		else
			map.put("producitonYear", new ProducitonYear());

		map.put("producitonYearList", producitonYearService.listYear());

		return "producitonYear";
	}

	@RequestMapping(value = "/addYear", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("producitonYear") ProducitonYear year, BindingResult result,
			Map<String, Object> map) {
		yearValidator.validate(year, result);
		if (result.getErrorCount() == 0) {
			if (year.getId() == 0)
				producitonYearService.addYear(year);
			else
				producitonYearService.editYear(year);

			System.out.println("Rok: " + year.getYear());

			return "redirect:years.html";
		}
		map.put("producitonYearList", producitonYearService.listYear());

		return "producitonYear";
	}
}
