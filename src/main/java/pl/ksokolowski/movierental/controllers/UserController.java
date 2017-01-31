package pl.ksokolowski.movierental.controllers;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import pl.ksokolowski.movierental.dao.UserDAO;
import pl.ksokolowski.movierental.domain.User;
import pl.ksokolowski.movierental.domain.UserRole;
import pl.ksokolowski.movierental.service.UserService;
import pl.ksokolowski.movierental.validators.UserValidator;

@Controller
@SessionAttributes
public class UserController {

	@Autowired
	UserService userService;

	UserValidator userValidator = new UserValidator();

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request,
			Map<String, Object> map) {

		userValidator.validate(user, result);
		if (result.getErrorCount() == 0) {
			if (!userService.userExist(user)) {
				if (user.getId() == 0)
					userService.addUser(user);
				else if (user.getId() != 0)
					userService.editUser(user);
				return "redirect:users.html";
			}
		}
		map.put("userList", userService.listUser());
		return "user";
	}

	@RequestMapping("/user")
	public String listUser(Map<String, Object> map, HttpServletRequest request) {

			map.put("user", new User());

		return "user";
	}
	
	@RequestMapping("/useredit")
	public String editUser(Map<String, Object> map, HttpServletRequest request) {
		int userId = ServletRequestUtils.getIntParameter(request, "userId", -1);

		if (userId > 0)
			map.put("user", userService.getUser(userId));
		else
			map.put("user", new User());

		return "user";
	}
	
	
	@RequestMapping(value = "/users")
    protected View welcome() {

        Set<String> roles = AuthorityUtils
                .authorityListToSet(SecurityContextHolder.getContext()
                        .getAuthentication().getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
            return new RedirectView("admin.html");
        }
        return new RedirectView("user.html");
    }

/*
	@RequestMapping("/userRole")
	public ModelAndView showUserRole() {

		return new ModelAndView("userRole", "userRole", new UserRole());
	}

	@RequestMapping(value = "/addUserRole", method = RequestMethod.POST)
	public String addUserRole(@ModelAttribute("userRole") UserRole userRole, BindingResult result,
			HttpServletRequest request, Map<String, Object> map) {

		userService.addUserRole(userRole);

		return "redirect:users.html";
	}
	*/
}
