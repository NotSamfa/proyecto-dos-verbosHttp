package com.co.falla.verboHttp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.falla.verboHttp.model.GroceryItem;
import com.co.falla.verboHttp.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private final ItemRepository itemRepository;
	
	private boolean started = false;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void setGroceryItems() {
		if(!this.started) {

            itemRepository.save(new GroceryItem("Whole", "Whole Wheat Biscuit", 5, "snacks")); 		}
            itemRepository.save(new GroceryItem("Dried", "Dried Whole Red Chilli", 2, "spices"));
            itemRepository.save(new GroceryItem("Pearl", "Healthy Pearl Millet", 1, "millets"));
            itemRepository.save(new GroceryItem("Cheese", "Bonny Cheese Crackers Plain", 6, "snacks"));
            
            this.started = true;
	}
	
   public List<GroceryItem> getAll() {
	    setGroceryItems();
	   
        return itemRepository.findAll();
    }

   
   public GroceryItem insert(GroceryItem groceryItem) {
	   setGroceryItems();
	   
       return itemRepository.save(groceryItem);
   }
   

   public GroceryItem update(GroceryItem groceryItem) {
       Optional<GroceryItem> optionalItem = itemRepository.findById(groceryItem.getId());
       
       if (optionalItem.isPresent()) {
           GroceryItem item = optionalItem.get();
           item.setName(groceryItem.getName());
           item.setQuantity(groceryItem.getQuantity());
           item.setCategory(groceryItem.getCategory());
           return itemRepository.save(item);
       }
       
       return null; 
   }

 
    public boolean delete(String id) {
       setGroceryItems();

        Optional<GroceryItem> optionalItem = itemRepository.findById(id);

        if (optionalItem.isPresent()) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
 
 
    public GroceryItem updateData(String id, GroceryItem groceryItem) {
        Optional<GroceryItem> optionalItem = itemRepository.findById(id);
        
        if (optionalItem.isPresent()) {
            GroceryItem item = optionalItem.get();
            if (groceryItem.getName() != null) {
                item.setName(groceryItem.getName());
            }
            if (groceryItem.getCategory() != null) {
                item.setCategory(groceryItem.getCategory());
            }
            if (groceryItem.getQuantity() > 0) {
                item.setQuantity(groceryItem.getQuantity());
            }
            return itemRepository.save(item);
        }
        
        return null; 
    }



    public String optionsUpdate(){ 
        return "OPTIONS: It insert a new grosery item, if the grosery item doesn't exist, it will create automatically"; 
    } 
	
	
	
}	
