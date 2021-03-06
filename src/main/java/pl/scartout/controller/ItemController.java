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
import pl.scartout.model.Item;
import pl.scartout.repo.GoalRepo;
import pl.scartout.repo.ItemRepo;
	 
@Controller
public class ItemController {

	private ItemRepo itemRepo;
	private GoalRepo goalRepo;
	 
    @Autowired
    public ItemController(ItemRepo itemRepo, GoalRepo goalRepo) {
        this.itemRepo = itemRepo;
        this.goalRepo = goalRepo;
    }
    
    @RequestMapping("/item")
    public String home(HttpSession httpSession, @RequestParam Long goalId){
    	httpSession.setAttribute("goalId", goalId);
        return "item";
    }
    
    @PostMapping("/summary")
    public String home(){
        return "summary";
    }
    
    @PostMapping("/saveitem")
    public String saveItem(@RequestParam String description,
    					@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
    					HttpSession session){
    	Item item = new Item(description, date);
    	Long goalId = (Long) session.getAttribute("goalId");
    	Goal goal = goalRepo.getById(goalId);
    	item.setGoal(goal);
    	itemRepo.save(item);
        return "redirect:/goals";
    }
    
    @PostMapping("/completeItem")
    public String completeItem(@RequestParam long itemId) {
    	itemRepo.updateItem(itemId);
        return "itemSuccess";
    }
    
    @PostMapping("/deleteItem")
    public String deleteItem(@RequestParam long itemId) {
    	itemRepo.deleteItem(itemId);
        return "redirect:/goals";
    }
    
    @PostMapping(path = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getItems(Model model, @RequestParam long goalId) {
    	List<Item> items = itemRepo.findAllByGoalId(goalId);
    	model.addAttribute("items", items);
        return items;
    }
    
    @RequestMapping(value = "/summary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getItemsSummary(Model model) {
    	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	List<Item> items = itemRepo.itemByUsername(userDetails.getUsername());
        model.addAttribute("items", items);
        return items;
    }
  
}