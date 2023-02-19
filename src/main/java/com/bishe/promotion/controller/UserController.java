package com.bishe.promotion.controller;

import com.bishe.promotion.entities.User;
import com.bishe.promotion.services.IUserService;
import com.bishe.promotion.utils.UserSession;
import com.bishe.promotion.vo.UserResponse;
import com.bishe.promotion.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class UserController {
    //@Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过@Autowired的使用来消除set ，get方法。

    @Qualifier("userServiceImpl")
    @Autowired
    IUserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "users/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserInfo(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        if (Objects.nonNull(user)) {
            logger.debug("mobile", "user name:%s", user.getMobile());
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("users")//获取URL中路径的参数值
    //加@RequestBody可以支持Content-Type为json格式的提交，不加@RequestBody就只支持form-date的数据提交
    public ResponseEntity<Map> login(@RequestBody  UserVo userVo) {
        // @RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)；

        UserResponse userResponse  = new UserResponse("密码错误",null);;
        Map<String,UserResponse> map = new HashMap<>();
        map.put("data",userResponse);
        if(Objects.isNull(userVo.getPassword())){
            userResponse.setMsg("密码为空");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);

        }else if(userVo.getPassword().length()<=6){
            userResponse.setMsg("密码长度必须大于6位");
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);


        }
        String token = userService.gerUserByMobile(userVo.getMobile(), userVo.getPassword());

        //System.out.println(token.length());


        if("error".equals(token)){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);//HttpStatus.BAD_REQUEST状态码表示请求失败
        }else{
            userResponse.setMsg("登录成功");
            userResponse.setToken(token);

            return  ResponseEntity.ok(map);
        }
    }


}


























