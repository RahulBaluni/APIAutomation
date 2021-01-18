package payload.unsuccessfulloginuserpayload;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder(toBuilder = true)
public class UnsuccessfulLoginUserPayload {
    private String email;
}
