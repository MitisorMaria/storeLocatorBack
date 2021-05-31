package com.storelocator.back.repositories;

import com.storelocator.back.bl.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    @Modifying
    @Transactional
    @Query("update Store s set s.name = ?1, s.address = ?2, s.latitude = ?3, s.longitude = ?4 where s.id = ?5")
    void updateStoreById(String name, String address, Float latitude, Float longitude, Long id);
}
