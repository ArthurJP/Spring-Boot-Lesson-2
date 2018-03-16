package com.jp.lesson2.controller;

import com.jp.lesson2.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XMLRestController {
    @GetMapping(value = "/xml/user"
//           , consumes = MediaType.APPLICATION_XML_VALUE,//这里产生了415问题，暂未解决
//            produces = MediaType.APPLICATION_XML_VALUE
    )
    public User user() {
        User user = new User();
        user.setName( "xml" );
        user.setAge( 30 );
        return user;
    }

}
