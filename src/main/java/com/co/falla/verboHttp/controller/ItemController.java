package com.co.falla.verboHttp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.co.falla.verboHttp.model.GroceryItem;
import com.co.falla.verboHttp.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/getAll")
	public ResponseEntity<List<GroceryItem>> getAll() {
		List<GroceryItem> items = itemService.getAll();
		return ResponseEntity.ok(items);
	}


	@PostMapping("/insert")
	public ResponseEntity<GroceryItem> insert(@RequestBody GroceryItem groceryItem) {
		GroceryItem savedItem = itemService.insert(groceryItem);

		return ResponseEntity.ok(savedItem);
	}
	
	@PutMapping("/update")
	public ResponseEntity<GroceryItem> update(@RequestBody GroceryItem groceryItem) {
		GroceryItem updatedItem = itemService.update(groceryItem);

		return ResponseEntity.ok(updatedItem);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> updateData(@PathVariable String id) {
		boolean deleted = itemService.delete(id);

		if (deleted) {
			return ResponseEntity.ok("Item eliminado exitosamente");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item no encontrado");
		}

	}
	
	@PatchMapping("/updateData/{id}")
	public ResponseEntity<GroceryItem>  updateData(@PathVariable String id, @RequestBody GroceryItem groceryItem) {
		GroceryItem updatedItem = itemService.updateData(id, groceryItem);

		if (updatedItem != null) {
			return ResponseEntity.ok(updatedItem);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.HEAD)
	public ResponseEntity<?> handleHeadRequest() { 

        HttpHeaders headers = new HttpHeaders(); 

        headers.setContentType(MediaType.APPLICATION_JSON); 

        return new ResponseEntity<>(headers, HttpStatus.OK); 
	}

}
