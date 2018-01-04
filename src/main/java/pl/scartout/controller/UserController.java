package pl.scartout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.scartout.dao.UserDao;
import pl.scartout.model.User;
	 
@Controller
public class UserController {

	private UserDao userDao;
	 
    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }
    
    @GetMapping("/register")
    public String home(Model model) {
    	model.addAttribute("user", new User());
        return "register";
    }
    
	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute User user) {
		userDao.save(user);
	return "redirect:/";
	}
}