package pl.scartout.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import pl.scartout.model.Item;
import pl.scartout.repo.ItemRepo;
	 
@Controller
public class ItemController {

	private ItemRepo itemRepo;
	 
    @Autowired
    public ItemController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }
    
    @GetMapping("/item")
    public String home() {
        return "item";
    }
    
    @PostMapping("/saveitem")
    public String saveItem(@RequestParam String description,
    					@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
    	Item item = new Item(description, date);
    	itemRepo.save(item);
        return "redirect:/item";
    }

}