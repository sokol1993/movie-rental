package pl.ksokolowski.movierental.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.ksokolowski.movierental.domain.AgeCategory;
import pl.ksokolowski.movierental.service.AgeCategoryService;
import pl.ksokolowski.movierental.validators.AgeCategoryValidator;

@Controller
@SessionAttributes
public class AgeCategoryController {

	@Autowired
	AgeCategoryService ageCategoryService;

	AgeCategoryValidator ageCategoryValidator = new AgeCategoryValidator();
	
	@RequestMapping("/agecategories")
	public String listAges(Map<String, Object> map, HttpServletRequest request) {

		int ageId = ServletRequestUtils.getIntParameter(request, "ageId", -1);

		if (ageId > 0)
			map.put("ageCategory", ageCategoryService.getAgeCategory(ageId));
		else
			map.put("ageCategory", new AgeCategory());

		map.put("ageList", ageCategoryService.listAgeCategory());

		return "ageCategory";
	}

	@RequestMapping(value = "/addAge", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("ageCategory") 
	AgeCategory age, BindingResult result, Map<String, Object> map) {

		ageCategoryValidator.validate(age, result);
		if(result.getErrorCount()==0){
		if (age.getId() == 0)
			ageCategoryService.addAgeCategory(age);
		else
			ageCategoryService.editAgeCategory(age);

		return "redirect:agecategories.html";
		}
		map.put("ageList", ageCategoryService.listAgeCategory());

		return "ageCategory";
	}
}
