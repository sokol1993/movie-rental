package pl.ksokolowski.movierental.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import pl.ksokolowski.movierental.domain.AdminRentsDetails;
import pl.ksokolowski.movierental.domain.Movie;
import pl.ksokolowski.movierental.domain.MyRentsDetails;
import pl.ksokolowski.movierental.domain.Rent;
import pl.ksokolowski.movierental.domain.User;
import pl.ksokolowski.movierental.domain.UserRole;
import pl.ksokolowski.movierental.service.MovieService;
import pl.ksokolowski.movierental.service.RentService;
import pl.ksokolowski.movierental.service.UserService;

@Controller
@SessionAttributes
public class AdminController {

@Autowired
UserService userService;

@Autowired
MovieService movieService;

@Autowired
RentService rentService;
	
	@RequestMapping("/admin") 
	public String listAdmin(Map<String, Object> map, HttpServletRequest request) {
	   
	    map.put("userList", userService.listUser());
	    map.put("movieList", movieService.listMovie());
	    map.put("rentList", rentService.listRent());
	    List<Rent> listRent = rentService.listRent();
	    List<AdminRentsDetails > listFilms = new ArrayList<AdminRentsDetails >();
	    for(Rent rent : listRent){

	    		AdminRentsDetails myRent = new AdminRentsDetails ();
	    		myRent.setFilmTitle(movieService.getMovie(rent.getIdMovie()).getTitle());
	    		myRent.setDateReturn(rent.getReturnDate());
	    		myRent.setRentId(rent.getId());
	    		myRent.setFirstName(userService.getUser(rent.getIdUser()).getFirstName());
	    		myRent.setLastName(userService.getUser(rent.getIdUser()).getLastName());
	    		listFilms.add(myRent);
	    	
	    }
	    map.put("filmsList", listFilms);
		return "admin";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
 
		return model;
	}
	
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public ModelAndView accessDenied404() 
	{
 
		ModelAndView model = new ModelAndView();
		model.setViewName("404");
 
		return model; 
 
	}
	
	@RequestMapping("/delete/users/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {
		
		List<Rent> rentlist = rentService.listRent();
		for (Rent rent : rentlist) {
			if (rent.getIdUser() == userId) {
				return "redirect:/admin.html";
			}
		}
		
		userService.removeUser(userId);
		return "redirect:/admin.html";
	}
	
	@RequestMapping("/delete/admin/{rentId}")
	public String deleteRent(@PathVariable("rentId") Integer rentId) {
		Rent rent = rentService.getRent(rentId);
		Movie movie = movieService.getMovie(rent.getIdMovie());
		movie.setAvailable("TAK");
		movieService.editMovie(movie);
		rentService.removeRent(rentId);

		return "redirect:/admin.html";
	}
}
