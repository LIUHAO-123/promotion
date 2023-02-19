package com.bishe.promotion.services;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import com.bishe.promotion.entities.User;
import com.bishe.promotion.repositories.IUserRepository;
import com.bishe.promotion.utils.Md5;
import com.bishe.promotion.utils.UserSession;
import org.apache.tomcat.util.security.MD5Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  IUserRepository userRepository;


  Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  @Override
  public User getUserById(Integer userId) {
    Optional<User> user = userRepository.findById(userId);
    if (user.isPresent()) {
      logger.debug("query user by", "%s", userId);
      User u = user.get();
      logger.debug("user mobile ", "%s", u.getMobile());
      return u;
    }
    return null;
  }

  @Override
  public String gerUserByMobile(String mobile, String password) {
    Optional<User> user = userRepository.findByMobile(mobile);
     password=Md5.getMD5String(password);
     //int userId =0;
    String token;

    if(user.isPresent()){
      User u = user.get();

      if(u.getPassword().equals(password)){
         token = token(mobile, u.getId());
        UserSession.USER_SESSION.put(token, u.getId());//获取老用户id,存到UserSession的USER_SESSION的Map里面

        return token;

      }
      return "error";

    }
    User newUser = new User();
    newUser.setMobile(mobile);
    newUser.setNickName(mobile);
    newUser.setGender("0");
    newUser.setInsertDate(LocalDate.now());
    newUser.setPassword(password);
    userRepository.save(newUser);//往数据库里增加数据
    token = token(mobile, newUser.getId());
    UserSession.USER_SESSION.put(token, newUser.getId());//获取新用户id
    return  token(mobile, newUser.getId());
  }

  private String token(String mobile,Integer userId ) {
    String tokenStr = mobile + ":" + userId;
    //return MD5Encoder.encode(tokenStr.getBytes());
    return Md5.getMD5String(tokenStr);


  }





}
