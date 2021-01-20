package payload.gmailusersmessagessendpayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Body {
    private String attachmentId;
    private String data;
    private Integer size;
}