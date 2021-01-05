package payload;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
public class CreateUserPayload {

    private String name;
    private String job;

}
