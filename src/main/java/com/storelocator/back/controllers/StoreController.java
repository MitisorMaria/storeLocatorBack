package com.storelocator.back.controllers;

import com.storelocator.back.bl.Store;
import com.storelocator.back.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping(value="stores")
    public ArrayList<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @DeleteMapping(value="stores/{id}")
    public void deleteStore(@PathVariable("id") long storeId) {
        storeService.deleteStore(storeId);
    }

    @PostMapping(value = "stores")
    public ResponseEntity<?> addStore(@RequestBody Store store) {
        storeService.addStore(store);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "stores/{id}")
    public ResponseEntity<?> updateStoreById(@PathVariable("id") long storeId, @RequestBody Store store) {
        storeService.updateStore(store.getName(), store.getAddress(), store.getLatitude(), store.getLongitude(),
                storeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
