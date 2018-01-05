package pl.scartout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.scartout.model.User;
import pl.scartout.repo.UserRepo;
	 
@Controller
public class UserController {

	private UserRepo userRepo;
	 
    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    
    @GetMapping("/register")
    public String home(Model model) {
    	model.addAttribute("user", new User());
        return "register";
    }
    
	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute User user) {
		userRepo.save(user);
	return "redirect:/";
	}
}