package dto.registeruser;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserResponse {

    private int id;
    private String token;
}
