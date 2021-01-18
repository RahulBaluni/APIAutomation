package payload.updateuserpayload;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder(toBuilder = true)
public class UpdateUserPayload {
    private String name;
    private String job;
}
