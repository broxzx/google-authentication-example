package ua.project.googleauthentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users", schema = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "secret_key", unique = true)
    private String secretKey;

    @Column(name = "validation_code")
    private int validationCode;

    @ElementCollection
    @CollectionTable(name = "scratch_codes", joinColumns =
        @JoinColumn(name = "user_id"))
    @Column(name = "scratch_code")
    private List<Integer> scratchCodes;
}
