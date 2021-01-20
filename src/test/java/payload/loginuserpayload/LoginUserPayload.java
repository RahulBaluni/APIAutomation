package payload.loginuserpayload;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder(toBuilder = true)
public class LoginUserPayload {
    private String email;
    private String password;
}
