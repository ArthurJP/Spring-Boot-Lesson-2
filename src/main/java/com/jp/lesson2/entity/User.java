package com.jp.lesson2.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.hateoas.ResourceSupport;

@ApiModel("用户实体")
public class User extends ResourceSupport {
    @ApiModelProperty(value = "用户名称",notes = "注意")
    private String name;
    @ApiModelProperty(value = "用户年龄",notes = "注意")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
