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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.ksokolowski.movierental.domain.AgeCategory;
import pl.ksokolowski.movierental.domain.CountryOfProduction;
import pl.ksokolowski.movierental.service.AgeCategoryService;
import pl.ksokolowski.movierental.service.CountryOfProductionService;
import pl.ksokolowski.movierental.validators.CountryOfProductionValidator;

@Controller
@SessionAttributes
public class CountryOfProductionController {
	@Autowired
	CountryOfProductionService countryOfProductionService;

	CountryOfProductionValidator countryOfProductionValidator = new CountryOfProductionValidator();

	@RequestMapping("/countries")
	public String listCountries(Map<String, Object> map, HttpServletRequest request) {

		int countryId = ServletRequestUtils.getIntParameter(request, "countryId", -1);

		if (countryId > 0)
			map.put("countryOfProduction", countryOfProductionService.getCountry(countryId));
		else
			map.put("countryOfProduction", new CountryOfProduction());

		map.put("countryOfProductionList", countryOfProductionService.listCountry());

		return "countryOfProduction";
	}

	@RequestMapping(value = "/addCountry", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("countryOfProduction") CountryOfProduction country, BindingResult result,
			Map<String, Object> map) {

		countryOfProductionValidator.validate(country, result);
		if (result.getErrorCount() == 0) {
			if (country.getId() == 0)
				countryOfProductionService.addCountry(country);
			else
				countryOfProductionService.editCountry(country);

			return "redirect:countries.html";
		}
		map.put("countryOfProductionList", countryOfProductionService.listCountry());

		return "countryOfProduction";
	}
}
