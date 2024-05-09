package ua.project.googleauthentication.config;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.project.googleauthentication.repository.CredentialRepository;

@Configuration
@RequiredArgsConstructor
public class CustomGoogleAuthenticatorConfig {

    private final CredentialRepository credentialRepository;

    @Bean
    public GoogleAuthenticator googleAuthenticator() {
        GoogleAuthenticator googleAuthenticator = new GoogleAuthenticator();
        googleAuthenticator.setCredentialRepository(credentialRepository);

        return googleAuthenticator;
    }


}
