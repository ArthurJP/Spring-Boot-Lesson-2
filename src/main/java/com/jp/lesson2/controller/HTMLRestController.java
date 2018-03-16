package com.jp.lesson2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Api(description = "标题测试")
@RestController
public class HTMLRestController {

    @ApiOperation(value = "页面返回",notes = "需要注意这是个测试")
    @GetMapping("/html")
    @ResponseBody
    public String html() {
        return "<html><body><h1>this is a test</h1></body></html>";
    }

    @ApiOperation("信息返回")
    @ApiImplicitParam(name = "msg", value = "传递信息", required = true, dataType = "String")
    @GetMapping({"/html/{msg}"})
    public String htmlPathVariable(@PathVariable String msg) {
        return "PathVariable:" + msg;
    }

    @GetMapping({"/html/param"})
    @ApiOperation("多参数展示")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "p", value = "参数", required = false, dataType = "String"),
            @ApiImplicitParam(name = "age", value = "年龄", required = false, dataType = "Integer")
    })
    public String htmlParam(@RequestParam(value = "p", required = false, defaultValue = "Empty") String param,
                            HttpServletRequest request,
                            @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        String param2 = request.getParameter( "param2" );
        return "RequestParam:" + param + "\nHttpServletRequest:" + param2 + "\nage:" + age;
    }

    @GetMapping("/html/header")
    @ApiOperation( "头信息" )
    @ApiImplicitParam(name="Accept",value = "接收信息",required = true,dataType ="String" )
    public String htmlHeader(@RequestHeader(value = "Accept") String accept) {
        return "Accept:" + accept;
    }

    @GetMapping("/html/response/entity")
    @ApiOperation( "实体传出" )
    public ResponseEntity<String> htmlResponseEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put( "myHeader", Collections.singletonList( "MyHeaderValue" ) );
        ResponseEntity<String> responseEntity = new ResponseEntity<>( "ResponseEntity", httpHeaders, HttpStatus.OK );
        return responseEntity;
    }
}
