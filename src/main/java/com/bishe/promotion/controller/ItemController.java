package com.bishe.promotion.controller;

import com.bishe.promotion.entities.Item;
import com.bishe.promotion.entities.User;
import com.bishe.promotion.repositories.IItemRepository;
import com.bishe.promotion.services.IItemService;
import com.bishe.promotion.vo.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Controller
public class ItemController {
    @Autowired
    IItemService iItemService;


    @RequestMapping(value = "item/{itemId}", method = RequestMethod.GET)
    public ResponseEntity<ItemVo> getItem(@PathVariable Integer itemId) {
        DateTimeFormatter dfDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Item item = iItemService.getItem(itemId);
        ItemVo itemVo = new ItemVo();
        itemVo.setId(item.getId());
        itemVo.setDescription(item.getDescription());
        itemVo.setBeginDate(item.getBeginDate().format(dfDateTime));
        itemVo.setEndTime(item.getEndTime().format(dfDateTime));
        itemVo.setPrice(item.getPrice());
        itemVo.setImgUrl(item.getImgUrl());
        if (Objects.nonNull(itemVo)) {

        }
        return ResponseEntity.ok(itemVo);
    }






}
