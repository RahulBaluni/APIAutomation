package payload;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder(toBuilder = true)
public class UpdateUserPutPayload {

    private String name;
    private String job;
}
