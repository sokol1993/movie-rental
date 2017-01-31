package pl.ksokolowski.movierental.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import pl.ksokolowski.movierental.domain.User;
import pl.ksokolowski.movierental.service.UserService;
import pl.ksokolowski.movierental.validators.UserValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	 @RequestMapping(value = "/")
	    protected View home() {

		 return new RedirectView("users.html");
	    }
	
	
	 @RequestMapping(value = "/welcome")
	    protected View welcome() {

	        Set<String> roles = AuthorityUtils
	                .authorityListToSet(SecurityContextHolder.getContext()
	                        .getAuthentication().getAuthorities());
	        if (roles.contains("ROLE_ADMIN")) {
	            return new RedirectView("admin.html");
	        }
	        return new RedirectView("rents.html");
	    }
	
}
