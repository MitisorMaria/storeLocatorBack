package com.storelocator.back.controllers;

import com.storelocator.back.bl.Store;
import com.storelocator.back.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
