package fun.joenathan.securityEx.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    @NotBlank
    @Email
    @Size(max = 255)
    private String email;
    @NotBlank
    @Size(max = 255)
    private String username;
    @NotBlank
    @Size(max = 255,min = 8)
    private String password;
}
