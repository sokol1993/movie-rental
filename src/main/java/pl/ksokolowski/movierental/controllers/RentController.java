package pl.ksokolowski.movierental.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import pl.ksokolowski.movierental.domain.Movie;
import pl.ksokolowski.movierental.domain.MyRentsDetails;
import pl.ksokolowski.movierental.domain.ProducitonYear;
import pl.ksokolowski.movierental.domain.Rent;
import pl.ksokolowski.movierental.domain.User;
import pl.ksokolowski.movierental.service.MovieService;
import pl.ksokolowski.movierental.service.RentService;
import pl.ksokolowski.movierental.service.UserService;
import pl.ksokolowski.movierental.validators.RentValidator;

@Controller
@SessionAttributes
public class RentController {

	@Autowired
	RentService rentService;

	@Autowired
	UserService userService;

	@Autowired
	MovieService movieService;

	RentValidator rentValidator = new RentValidator();

	@RequestMapping("/rent")
	public String listMovies(Map<String, Object> map, HttpServletRequest request) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		User user = userService.getUserByLogin(userName);
		List<User> list = new ArrayList<User>();
		list.add(user);
		map.put("userList", list);
		map.put("movieList", movieService.listMovie());
		map.put("rentList", rentService.listRent());
		List<Rent> listRent = rentService.listRent();
		List<MyRentsDetails> listFilms = new ArrayList<MyRentsDetails>();
		for (Rent rent : listRent) {
			if (rent.getIdUser() == user.getId()) {
				MyRentsDetails myRent = new MyRentsDetails();
				myRent.setFilmTitle(movieService.getMovie(rent.getIdMovie()).getTitle());
				myRent.setDateReturn(rent.getReturnDate());
				listFilms.add(myRent);
			}
		}
		map.put("filmsList", listFilms);
		return "rent";
	}

	@RequestMapping("/rentguest")
	public String listMoviess(Map<String, Object> map, HttpServletRequest request) {

		map.put("movieList", movieService.listMovie());
		return "guest";
	}

	@RequestMapping(value = "/rents")
	protected View welcome() {

		Set<String> roles = AuthorityUtils
				.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		if (roles.contains("ROLE_USER")) {
			return new RedirectView("rent.html");
		}
		return new RedirectView("rentguest.html");
	}

	@RequestMapping(value = "/addRent", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("rent") Rent rent, BindingResult result, Map<String, Object> map) {

		rentValidator.validate(rent, result);
		if (result.getErrorCount() == 0) {
			if (rent.getId() == 0) {
				rentService.addRent(rent);
				Movie movie = movieService.getMovie(rent.getIdMovie());
				movie.setAvailable("NIE");
				movieService.editMovie(movie);
			} else
				rentService.editRent(rent);

			return "redirect:rents.html";
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		User user = userService.getUserByLogin(userName);
		List<User> list = new ArrayList<User>();
		list.add(user);
		map.put("userList", list);
		map.put("movieList", movieService.listMovie());
		map.put("rentList", rentService.listRent());
		List<Rent> listRent = rentService.listRent();
		List<MyRentsDetails> listFilms = new ArrayList<MyRentsDetails>();
		for (Rent rent1 : listRent) {
			if (rent1.getIdUser() == user.getId()) {
				MyRentsDetails myRent = new MyRentsDetails();
				myRent.setFilmTitle(movieService.getMovie(rent1.getIdMovie()).getTitle());
				myRent.setDateReturn(rent1.getReturnDate());
				listFilms.add(myRent);
			}
		}
		map.put("filmsList", listFilms);
		return "rent";
	}
}
