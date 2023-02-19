package com.bishe.promotion.repositories;



import com.bishe.promotion.entities.Address;
import com.bishe.promotion.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAddressRepository extends JpaRepository<Address,Integer> {

}
