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

import pl.ksokolowski.movierental.domain.Director;
import pl.ksokolowski.movierental.domain.Genre;
import pl.ksokolowski.movierental.service.DirectorService;
import pl.ksokolowski.movierental.service.GenreService;
import pl.ksokolowski.movierental.validators.GenreValidator;

@Controller
@SessionAttributes
public class GenreController {

	@Autowired
	GenreService genreService;

	GenreValidator genreValidator = new GenreValidator();

	@RequestMapping("/genres")
	public String listGenres(Map<String, Object> map, HttpServletRequest request) {

		int genreId = ServletRequestUtils.getIntParameter(request, "genreNameId", -1);

		if (genreId > 0)
			map.put("genre", genreService.getGenre(genreId));
		else
			map.put("genre", new Genre());

		map.put("genreList", genreService.listGenre());

		return "genre";
	}

	@RequestMapping(value = "/addGenre", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("genre") Genre genre, BindingResult result, Map<String, Object> map) {
		genreValidator.validate(genre, result);
		if (result.getErrorCount() == 0) {
			if (genre.getId() == 0)
				genreService.addGenre(genre);
			else
				genreService.editGenre(genre);

			return "redirect:genres.html";
		}
		map.put("genreList", genreService.listGenre());

		return "genre";
	}

}
