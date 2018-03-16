package com.jp.lesson2.controller;

import com.jp.lesson2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class JSONRestController {

    @Bean
    public User currentUser() {
        User user = new User();
        user.setName( "json" );
        user.setAge( 20 );
        return user;
    }

    @Autowired
    @Qualifier("currentUser")
//    使用 @Qualifier 注释和 @Autowired 注释通过指定哪一个真正的 bean 将会被装配来消除混乱
    private User user;

    @GetMapping(value = "/json/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User user() {
        user.add( linkTo( methodOn( JSONRestController.class ).setUserName( user.getName() ) ).withSelfRel() );
        user.add( linkTo( methodOn( JSONRestController.class ).setUserAge( user.getAge() ) ).withSelfRel() );
        return user;
    }

    //    setName
    @GetMapping(value = "/json/user/set/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public User setUserName(@RequestParam String name) {
        user.setName( name );
        return user;
    }

    //    setAge
    @GetMapping(value = "/json/user/set/age", produces = MediaType.APPLICATION_JSON_VALUE)
    public User setUserAge(@RequestParam int age) {
        user.setAge( age );
        return user;
    }
}
