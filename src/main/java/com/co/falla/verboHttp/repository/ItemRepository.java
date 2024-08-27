package com.co.falla.verboHttp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.co.falla.verboHttp.model.GroceryItem;

@Repository
public interface ItemRepository extends MongoRepository<GroceryItem, String> {

}
