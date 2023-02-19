package com.bishe.promotion.services;


import com.bishe.promotion.entities.Item;
import com.bishe.promotion.repositories.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IItemServiceImpl implements IItemService {


    @Autowired
    IItemRepository iItemRepository;

    @Override
    public Item getItem(int id) {

        return iItemRepository.getReferenceById(id);
    }
}
