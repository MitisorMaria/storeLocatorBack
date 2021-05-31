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

    @GetMapping(value="stores/{id}")
    public Store getStoreById(@PathVariable("id") long storeId) {
        return storeService.getStoreById(storeId);
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
        Store oldStore = storeService.getStoreById(storeId);
        String newName = store.getName().equals("") ? oldStore.getName() : store.getName();
        String newAddress = store.getAddress().equals("") ? oldStore.getAddress() : store.getAddress();
        float newLatitude = store.getLatitude() == 0 ? oldStore.getLatitude() : store.getLatitude();
        float newLongitude = store.getLongitude() == 0 ? oldStore.getLongitude() : store.getLongitude();
        storeService.updateStore(newName, newAddress, newLatitude, newLongitude,
                storeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
