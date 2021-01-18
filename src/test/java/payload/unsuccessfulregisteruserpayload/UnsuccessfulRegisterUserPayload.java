package payload.unsuccessfulregisteruserpayload;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder(toBuilder = true)
public class UnsuccessfulRegisterUserPayload {
    private String email;
}
