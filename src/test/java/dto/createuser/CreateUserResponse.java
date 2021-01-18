package dto.createuser;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {
    private String name;
    private String job;
    private String id;
    private String createdAt;
}
