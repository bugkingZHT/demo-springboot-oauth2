package com.example.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import java.util.Arrays;

@Configuration
public class OAuth2ClientConfig {
//
//    @Value("${security.oauth2.client.accessTokenUri}")
//    private String accessTokenUri;
//
//    @Value("${security.oauth2.client.clientId}")
//    private String clientId;
//
//    @Value("${security.oauth2.client.clientSecret}")
//    private String clientSecret;

    @Bean
    public OAuth2RestTemplate oAuth2RestTemplate() {
        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setAccessTokenUri("http://localhost:9000/oauth/token");
        resourceDetails.setClientId("client2");
        resourceDetails.setClientSecret("secret2");
        resourceDetails.setGrantType("client_credentials");
        resourceDetails.setScope(Arrays.asList("read", "write"));
        return new OAuth2RestTemplate(resourceDetails);
    }

}
