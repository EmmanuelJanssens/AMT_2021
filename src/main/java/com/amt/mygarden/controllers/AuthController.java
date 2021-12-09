package com.amt.mygarden.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AuthController {
    @Value("${login-api.path}")
    String loginAPIPath;

    @GetMapping(path = "/login")
    public String getLogin(HttpServletRequest request) {
        if (request.getSession().getAttribute("username") != null) {
            // todo: send 403 error instead of redirect
            return "redirect:/";
        }
        return "login";
    }

    @PostMapping(path = "/logout")
    public String logoutUser(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }

    @PostMapping(path = "/login")
    public String authenticateUSer(@RequestParam String username, @RequestParam String password, HttpServletRequest request, Model model) throws JsonProcessingException {
        String uri = loginAPIPath + "/auth/login";
        String payload = "{\"username\":\""+username+"\", \"password\":\""+password+"\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(payload, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(uri, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            String body = response.getBody();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(body);
            JsonNode account = root.path("account");

            // save into session
            HttpSession session = request.getSession();
            session.setAttribute("userid", account.get("id"));
            session.setAttribute("username", account.get("username"));
            session.setAttribute("role", account.get("role"));
            session.setAttribute("token", root.get("token"));
            return "redirect:/";
        }
        else if (response.getStatusCode() == HttpStatus.FORBIDDEN) {
            model.addAttribute("error", "The credentials are incorrect");
        }else {
            model.addAttribute("error", "Unknow error please try again in a while");
        }

        return "login";
    }
}
