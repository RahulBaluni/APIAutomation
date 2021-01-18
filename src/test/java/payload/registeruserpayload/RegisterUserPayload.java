package payload.registeruserpayload;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder(toBuilder = true)
public class RegisterUserPayload {

    private String email;
    private String password;
}
