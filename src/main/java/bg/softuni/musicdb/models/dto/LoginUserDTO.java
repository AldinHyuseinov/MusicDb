package bg.softuni.musicdb.models.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoginUserDTO {
    @Size(min = 3, max = 20, message = "Length must be between 3 and 20 characters.")
    private String username;

    @Size(min = 5, max = 20, message = "Length must be between 5 and 20 characters.")
    private String password;
}
