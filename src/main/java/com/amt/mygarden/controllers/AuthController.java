package com.amt.mygarden.controllers;

import com.amt.mygarden.validation.RegisterForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String registerUser(@ModelAttribute RegisterForm registerForm, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        String uri = loginAPIPath + "/accounts/register";
        String payload = registerForm.toString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(payload, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = null;
        // todo: handle errors return back to register if error
        response = restTemplate.postForEntity(uri, entity, String.class);

        return "redirect:/login?new_account";

    }
}
