package com.libertymutual.goforcode.invoicify.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.invoicify.models.User;
import com.libertymutual.goforcode.invoicify.repositories.UserRepository;

@Controller
@RequestMapping("/")
public class HomeController {

	
	private UserRepository userRepo;
	private PasswordEncoder encoder;
	
	public HomeController(UserRepository userRepo, PasswordEncoder encoder) {
		this.userRepo = userRepo;
		this.encoder = encoder;
	}
	
	@GetMapping("")
	public String unsecured() {
		return "home/default";
	}

	@GetMapping("/signup")
	public String signup() {
		return "home/signup";
	}
	
	@PostMapping("/signup")
	public ModelAndView handleSignUp(User user) {
		// This is really dumb; NEEDS REFACTORING
		String password = user.getPassword();
		String encryptedPassword = encoder.encode(password);
		user.setPassword(encryptedPassword);
		
		ModelAndView mv = new ModelAndView();
		try {
			userRepo.save(user);
			mv.setViewName("redirect:/login");
		} catch (DataIntegrityViolationException dive) {
			mv.setViewName("home/signup");
			mv.addObject("errorMessage", "Cannot signup with that username");
		}
		return mv;
	}
}
