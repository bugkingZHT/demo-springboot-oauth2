package com.example.client.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/api")
public class ClientController {

    @GetMapping("/home")
    @ResponseBody
    public String home() {
        log.info("-- home --");
        return "home";
    }

    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;

    @GetMapping("/")
    @ResponseBody
    public String main(OAuth2AuthenticationToken token) {
        String result = oAuth2RestTemplate.getForObject("http://localhost:8000/private/hello", String.class);

        Map<String, String> response = new HashMap<>();
        response.put("data", result);

//        log.info(String.valueOf(token));

//        log.info(String.valueOf(token.getPrincipal()));

        return JSON.toJSONString(response);

    }
}
