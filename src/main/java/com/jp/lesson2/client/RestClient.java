package com.jp.lesson2.client;

import com.jp.lesson2.entity.User;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestClient {

    public static void main(String[] args) {
        /**
         * 默认实现
         */
        RestTemplate restTemplate = new RestTemplate();
        String context = restTemplate.getForObject( "http://localhost:8080/json/user", String.class );
        System.out.println(context);

        User user = restTemplate.getForObject( "http://localhost:8080/json/user", User.class );
        System.out.println(user);

        User user2 = restTemplate.getForObject( "http://localhost:8080/xml/user", User.class );
        System.out.println(user2);

        /**
         * 引入httpClient后的实现
         */
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient httpClient = httpClientBuilder.build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory( httpClient );
        RestTemplate restTemplate1 = new RestTemplate( factory );
        User user1 = restTemplate1.getForObject( "http://localhost:8080/json/user", User.class );
        System.out.println( "user1 = " + user1 );


    }

}
