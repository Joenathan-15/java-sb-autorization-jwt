package fun.joenathan.securityEx.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {
    @NotBlank
    @Email
    @Size(max = 255)
    private String email;
    @NotBlank
    @Size(min = 8,max = 255)
    private  String password;
}
