package payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Payload {
    private Body body;
    private String filename;
    private List<String> headers;
    private String mimeType;
    private String partId;
    private List<String> parts;


}
