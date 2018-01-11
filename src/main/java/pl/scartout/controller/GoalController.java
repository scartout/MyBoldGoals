package pl.scartout.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.scartout.model.Goal;
import pl.scartout.model.User;
import pl.scartout.repo.GoalRepo;
import pl.scartout.repo.ItemRepo;
import pl.scartout.repo.UserRepo;

@Controller
public class GoalController {
	
	private GoalRepo goalRepo;
	private ItemRepo itemRepo;
	private UserRepo userRepo;
	 
    @Autowired
    public GoalController(GoalRepo goalRepo, ItemRepo itemRepo, UserRepo userRepo) {
        this.goalRepo = goalRepo;
        this.itemRepo = itemRepo;
        this.userRepo = userRepo;
    }
    
    @GetMapping("/goal")
    public String home(Model model) {
    	model.addAttribute("goalModel", new Goal());
        return "goal";
    }
    
    @PostMapping("/saveGoal")
    public String savegoal(@RequestParam String description,
    					@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateStart,
    					@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEnd ){
    	Goal goal = new Goal(description, dateStart, dateEnd);
    	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = userRepo.findByUsername(userDetails.getUsername());
    	goal.setUser(user);
    	goalRepo.save(goal);
        return "redirect:/goals";
    }
    
    @PostMapping("/deleteGoal")
    public String deleteGoal(@RequestParam long goalId) {
    	Goal managedGoal = goalRepo.getById(goalId);
        managedGoal.getItems().clear();
        itemRepo.deleteItems(goalId);
    	goalRepo.deleteGoal(goalId);
        return "redirect:/goals";
    }
    
    @GetMapping(path = "/goals", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Goal> goalItems(Model model, HttpSession session) {
    	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Long userId = userRepo.idByUsername(userDetails.getUsername());
    	List<Goal> goals = goalRepo.findAllByUserId(userId);
    	model.addAttribute("goals", goals);
        return goals;
    }

}