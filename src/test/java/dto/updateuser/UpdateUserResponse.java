package dto.updateuser;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResponse {
    private String name;
    private String job;
    private String updatedAt;
}
