package pl.scartout.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.scartout.dao.ItemDao;
import pl.scartout.model.Item;
	 
@Controller
public class ItemController {

	private ItemDao itemDao;
	 
    @Autowired
    public ItemController(ItemDao itemDao) {
        this.itemDao = itemDao;
    }
    
    @GetMapping("/item")
    public String home(Model model) {
    	model.addAttribute("item", new Item());
        return "item";
    }
    
    @PostMapping("/saveitem")
    public String home(@RequestParam String description,
    					@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
    	Item item = new Item(description, date);
    	itemDao.save(item);
        return "redirect:/item";
    }

}