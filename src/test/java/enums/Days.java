package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by ngoyal on 16/01/21.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum Days {

    SUNDAY, MONDAY, TUESDAY, WEDNESDAY;

    private String day;
}
