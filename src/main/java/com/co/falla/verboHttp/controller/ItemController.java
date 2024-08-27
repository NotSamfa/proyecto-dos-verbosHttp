package com.co.falla.verboHttp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.co.falla.verboHttp.model.GroceryItem;
import com.co.falla.verboHttp.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/getAll")
	public List<GroceryItem> getAll() {
        return itemService.getAll();
	}


	@PostMapping("/insert")
	public GroceryItem insert(@RequestBody GroceryItem groceryItem) {

        return itemService.insert(groceryItem);
	}
	
	@PutMapping("/update")
	public GroceryItem update(@RequestBody GroceryItem groceryItem) {

        return itemService.update(groceryItem);
	}
	
	@DeleteMapping("/delete/{id}")
	public String updateData(@PathVariable String id) {
		boolean deleted = itemService.delete(id);

		if (deleted) {
			return "Item eliminado exitosamente";
		} else {
			return "Item no encontrado";
		}

	}
	
	@PatchMapping("/updateData/{id}")
	public GroceryItem  updateData(@PathVariable String id, @RequestBody GroceryItem groceryItem) {
		GroceryItem updatedItem = itemService.updateData(id, groceryItem);

		if (updatedItem != null) {
			return updatedItem;
		} else {
			return null;
		}

	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.HEAD)
	public ResponseEntity<?> handleHeadRequest() { 

        HttpHeaders headers = new HttpHeaders(); 

        headers.setContentType(MediaType.APPLICATION_JSON); 

        return new ResponseEntity<>(headers, HttpStatus.OK); 
	}

}
