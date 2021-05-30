package com.storelocator.back.controllers;

import com.storelocator.back.bl.Store;
import com.storelocator.back.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping(value="stores")
    public ArrayList<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @DeleteMapping(value="stores")
    public void deleteStore(@RequestParam long storeId) {
        storeService.deleteStore(storeId);
    }

    @PostMapping(value = "stores")
    public ResponseEntity<?> addStore(@RequestBody Store store) {
        storeService.addStore(store);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
