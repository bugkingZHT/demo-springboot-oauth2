package com.example.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().anyRequest()
                .permitAll();

        //.antMatchers("/secret/**")
    }

//
//    @Bean
//    public ClientRegistrationRepository clientRepository() {
//        ClientRegistration c = clientRegistration();
//        return new InMemoryClientRegistrationRepository(c);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.oauth2Login();
//        http.authorizeRequests()
//                .anyRequest().authenticated();
//    }
//
//    private ClientRegistration clientRegistration() {
//        return ClientRegistration.withRegistrationId("demo")
//                .clientId("client2")
//                .clientSecret("secret2")
//                .scope("read")
//                .tokenUri("http://localhost:9000/oauth/token")
//                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//                .redirectUriTemplate("{baseUrl}/")
//                .build();
//    }
}