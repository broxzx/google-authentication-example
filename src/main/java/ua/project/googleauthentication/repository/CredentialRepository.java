package ua.project.googleauthentication.repository;

import com.warrenstrange.googleauth.ICredentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ua.project.googleauthentication.entity.UserEntity;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CredentialRepository implements ICredentialRepository {

    private final UserRepository userRepository;

    @Override
    public String getSecretKey(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(
                        () -> new RuntimeException("user not found exception")
                ).getSecretKey();
    }

    @Override
    public void saveUserCredentials(String username, String secretKey, int validationCode, List<Integer> scratchCodes) {
        userRepository.save(UserEntity.builder()
                .username(username)
                .secretKey(secretKey)
                .validationCode(validationCode)
                .scratchCodes(scratchCodes)
                .build());
    }
}
