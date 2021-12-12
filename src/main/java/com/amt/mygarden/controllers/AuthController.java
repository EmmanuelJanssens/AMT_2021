package com.amt.mygarden.controllers;

import com.amt.mygarden.validation.RegisterForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AuthController {
    @Value("${login-api.path}")
    String loginAPIPath;

    @GetMapping(path = "/login")
    public String getLogin(Model model,
                           @RequestParam Optional<String> error,
                           @RequestParam Optional<String> logout,
                           @RequestParam Optional<String> new_account
    ) {
        if (error.isPresent()) model.addAttribute("error", error);
        if (logout.isPresent()) model.addAttribute("logout", logout);
        if (new_account.isPresent()) model.addAttribute("new_account", new_account);

        return "login";
    }

    @GetMapping(path = "/register")
    public ModelAndView showRegister() {
        return new ModelAndView("register", "registerForm", new RegisterForm());
    }

    @PostMapping(path = "/register")
    public String registerUser(@ModelAttribute RegisterForm registerForm, BindingResult result, Model model) throws JsonProcessingException {
        if (result.hasErrors()) {
            return "register";
        }

        String uri = loginAPIPath + "/accounts/register";
        String payload = registerForm.toString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(payload, headers);

        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.postForEntity(uri, entity, String.class);
            return "redirect:/login?new_account";
        } catch (HttpStatusCodeException ex) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(ex.getResponseBodyAsString());
            ArrayList<String> errors = new ArrayList<>();
            if (root.hasNonNull("error")) {
                errors.add(root.path("error").asText());
            }
            if (root.hasNonNull("errors")) {
                JsonNode jsonErrors = root.path("errors");
                for (JsonNode error: jsonErrors) {
                    errors.add(error.get("property").asText() + " : " + error.get("message").asText());
                }
            }
            model.addAttribute("errors", errors);
        }
        return "register";
    }
}
