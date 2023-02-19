package com.bishe.promotion.services;

import com.bishe.promotion.entities.User;

public interface IUserService {

  User getUserById(Integer userId);
  String gerUserByMobile(String mobile,String password);



}
