package pl.scartout.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import pl.scartout.model.Goal;
import pl.scartout.repo.GoalRepo;
	 
@Controller
public class GoalController {

	private GoalRepo goalRepo;
	 
    @Autowired
    public GoalController(GoalRepo goalRepo) {
        this.goalRepo = goalRepo;
    }
    
    @GetMapping("/goal")
    public String home() {
        return "goal";
    }
    
    @PostMapping("/savegoal")
    public String savegoal(@RequestParam String description,
    					@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateStart,
    					@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEnd) {
    	Goal goal = new Goal(description, dateStart, dateEnd);
    	goalRepo.save(goal);
        return "redirect:/item";
    }

}