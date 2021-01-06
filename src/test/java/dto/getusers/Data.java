package dto.getusers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {

    private Long id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
