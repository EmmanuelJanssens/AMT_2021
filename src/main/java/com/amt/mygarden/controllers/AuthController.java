package com.amt.mygarden.controllers;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class AuthController {
    @Value("${login-api.path}")
    String loginAPIPath;

    @GetMapping(path = "/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping(path = "/login")
    public @ResponseBody
    String authenticateUSer(@RequestParam String username, @RequestParam String password) {
        String uri = loginAPIPath + "/auth/login";
        String request = "{\"username\":\""+username+"\", \"password\":\""+password+"\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(request, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(uri, entity, String.class);

        return response.toString();
    }
}
