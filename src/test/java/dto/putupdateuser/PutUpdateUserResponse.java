package dto.putupdateuser;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class PutUpdateUserResponse {
    private String name;
    private String job;
    private String updatedAt;
}
