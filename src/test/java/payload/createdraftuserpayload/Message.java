package payload.createdraftuserpayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String historyId;
    private String id;
    private String internalDate;
    private List<String> labelIds;
    private Payload payload;
    private String raw;
    private String snippet;
    private String threadId;
    private Integer sizeEstimate;
}
