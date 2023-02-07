package bg.softuni.musicdb.models.dto;

import bg.softuni.musicdb.util.validation.FieldMatch;
import bg.softuni.musicdb.util.validation.UniqueEmail;
import bg.softuni.musicdb.util.validation.UniqueName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@FieldMatch(first = "password", second = "confirmPassword", message = "Passwords must match.")
public class RegisterUserDTO {
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters.")
    @UniqueName
    private String username;

    @Size(min = 3, max = 20, message = "Full name length must be between 3 and 20 characters.")
    private String fullName;

    @Email(regexp = ".+@.+", message = "Must be valid email.")
    @UniqueEmail
    private String email;

    @Size(min = 5, max = 20, message = "Password length must be between 5 and 20 characters.")
    private String password;

    @Size(min = 5, max = 20, message = "Password length must be between 5 and 20 characters.")
    private String confirmPassword;
}
