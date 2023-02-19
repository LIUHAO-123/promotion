package com.bishe.promotion.repositories;

import com.bishe.promotion.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepository extends JpaRepository<Item,Integer> {


}
