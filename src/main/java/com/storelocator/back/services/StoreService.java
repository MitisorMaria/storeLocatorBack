package com.storelocator.back.services;

import com.storelocator.back.bl.Store;
import com.storelocator.back.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public ArrayList<Store> getAllStores() {
        return (ArrayList<Store>)storeRepository.findAll();
    }

    public void deleteStore (long storeId) {
        storeRepository.deleteById(storeId);
    }

    public void addStore (Store store) {
        storeRepository.save(store);
    }

    public void updateStore (String name, String address, Float latitude, Float longitude, Long id) {
        storeRepository.updateStoreById(name, address, latitude, longitude, id);
    }
}
