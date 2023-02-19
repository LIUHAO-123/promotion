package com.bishe.promotion.controller;

import com.bishe.promotion.entities.Address;
import com.bishe.promotion.services.IAddressService;
import com.bishe.promotion.utils.UserSession;
import com.bishe.promotion.vo.AddressVo;
import com.bishe.promotion.vo.UserResponse;
import org.apache.el.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
public class AddressController {
    //@Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过@Autowired的使用来消除set ，get方法。
    @Autowired
    IAddressService addressService;//可以直送从里面调用数据和方法
    //把Address中的数据赋值转换给Address
    @PostMapping("address")//获取URL中路径的参数值
    public ResponseEntity<UserResponse> save(@RequestBody AddressVo addressVo,String token){
        String regex = "[1][34578][0-9]{9}";
        UserResponse userResponse = new UserResponse("提交成功",null);
        if((!addressVo.getMobile().matches(regex))){
            userResponse.setMsg("提交失败");
            //INTERNAL_SERVER_ERROR
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userResponse);

        }

        Address address = new Address();
        address.setProvince(addressVo.getProvince());
        address.setCity(addressVo.getCity());
        address.setDetail(addressVo.getDetail());
        address.setDistrict(addressVo.getDistrict());
        address.setConsigneeName(addressVo.getConsigneeName());
        address.setMobile(addressVo.getMobile());
        address.setUserId(UserSession.USER_SESSION.get(token));

        Integer id = addressService.save(address);


        if(id<=0){
            userResponse.setMsg("提交失败");
            //INTERNAL_SERVER_ERROR
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userResponse);

        }

        return ResponseEntity.ok(userResponse);
    }








}


























