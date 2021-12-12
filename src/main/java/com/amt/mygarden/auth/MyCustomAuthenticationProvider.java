package com.amt.mygarden.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyCustomAuthenticationProvider implements AuthenticationProvider {
    @Value("${login-api.path}")
    String loginAPIPath;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication result = null;
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        String uri = loginAPIPath + "/auth/login";
        String payload = "{\"username\":\""+username+"\", \"password\":\""+password+"\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(payload, headers);

        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(uri, entity, String.class);
            String body = response.getBody();
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode root = objectMapper.readTree(body);
            JsonNode account = root.path("account");

            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_" + account.get("role").asText().toUpperCase()));
            result = new UsernamePasswordAuthenticationToken(
                    username,
                    root.get("token").asText(),
                    grantedAuths
            );

            return result;
        } catch (HttpStatusCodeException | JsonProcessingException ex) {
            throw new BadCredentialsException("Invalid credentials");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.equals(aClass);
    }
}
