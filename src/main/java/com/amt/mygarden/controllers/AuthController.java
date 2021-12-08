package com.amt.mygarden.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class AuthController {

    @GetMapping(path = "/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping(path = "/login")
    public @ResponseBody
    String authenticateUSer() {
        String uri = "http://172.17.0.1:8082/auth/login";
        // todo: add real credentials for test
        String username = "xxx";
        String password = "xxx";
        String request = "{\"username\":\""+username+"\", \"password\":\""+password+"\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(request, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(uri, entity, String.class);

        return response.toString();
    }
}
