package pl.ksokolowski.movierental.controllers;

import java.util.List;
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
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.ksokolowski.movierental.domain.Genre;
import pl.ksokolowski.movierental.domain.Movie;
import pl.ksokolowski.movierental.domain.Rent;
import pl.ksokolowski.movierental.service.AgeCategoryService;
import pl.ksokolowski.movierental.service.CountryOfProductionService;
import pl.ksokolowski.movierental.service.DirectorService;
import pl.ksokolowski.movierental.service.GenreService;
import pl.ksokolowski.movierental.service.MovieService;
import pl.ksokolowski.movierental.service.ProducitonYearService;
import pl.ksokolowski.movierental.service.RentService;
import pl.ksokolowski.movierental.validators.MovieValidator;

@Controller
@SessionAttributes
public class MovieController {
	@Autowired
	MovieService movieService;

	@Autowired
	GenreService genreService;

	@Autowired
	AgeCategoryService ageCategoryService;

	@Autowired
	CountryOfProductionService countryOfProductionService;

	@Autowired
	DirectorService directorService;

	@Autowired
	ProducitonYearService producitonYearService;

	@Autowired
	RentService rentService;

	MovieValidator movieValidator = new MovieValidator();

	@RequestMapping("/movies")
	public String listMovies(Map<String, Object> map, HttpServletRequest request) {

		int movieId = ServletRequestUtils.getIntParameter(request, "movieId", -1);

		if (movieId > 0) {
			Movie movie = movieService.getMovie(movieId);
			movie.setGenre(genreService.getGenre(movieService.getMovie(movieId).getGenre().getId()));
			movie.setAgeCategory(
					ageCategoryService.getAgeCategory(movieService.getMovie(movieId).getAgeCategory().getId()));
			movie.setCountryOfProduction(countryOfProductionService
					.getCountry(movieService.getMovie(movieId).getCountryOfProduction().getId()));
			movie.setDirector(directorService.getDirector(movieService.getMovie(movieId).getDirector().getId()));
			movie.setProducitonYear(
					producitonYearService.getYear(movieService.getMovie(movieId).getProducitonYear().getId()));
			map.put("selectedGenre", movieService.getMovie(movieId).getGenre().getId());
			map.put("selectedAgeCategory", movieService.getMovie(movieId).getAgeCategory().getId());
			map.put("selectedCountryOfProduction", movieService.getMovie(movieId).getCountryOfProduction().getId());
			map.put("selectedDirector", movieService.getMovie(movieId).getDirector().getId());
			map.put("selectedProducitonYear", movieService.getMovie(movieId).getProducitonYear().getId());
			map.put("movie", movie);
		} else
			map.put("movie", new Movie());

		map.put("genresList", genreService.listGenre());
		map.put("ageCategoryList", ageCategoryService.listAgeCategory());
		map.put("countryOfProductionList", countryOfProductionService.listCountry());
		map.put("directorList", directorService.listDirector());
		map.put("producitonYearList", producitonYearService.listYear());
		map.put("movieList", movieService.listMovie());

		return "movie";
	}

	@RequestMapping(value = "/addMovie", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("movie") Movie movie, BindingResult result, Map<String, Object> map) {

		movieValidator.validate(movie, result);
		if (result.getErrorCount() == 0) {
			if (movie.getId() == 0)
				movieService.addMovie(movie);
			else
				movieService.editMovie(movie);

			return "redirect:movies.html";
		}
		map.put("genresList", genreService.listGenre());
		map.put("ageCategoryList", ageCategoryService.listAgeCategory());
		map.put("countryOfProductionList", countryOfProductionService.listCountry());
		map.put("directorList", directorService.listDirector());
		map.put("producitonYearList", producitonYearService.listYear());
		map.put("movieList", movieService.listMovie());

		return "movie";
	}

	@RequestMapping("/delete/movies/{movieId}")
	public String deleteMovie(@PathVariable("movieId") Integer movieId) {
		List<Rent> rentlist = rentService.listRent();
		for (Rent rent : rentlist) {
			if (rent.getIdMovie() == movieId) {
				return "redirect:/movies.html";
			}
		}
		movieService.removeMovie(movieId);

		return "redirect:/movies.html";
	}
}
