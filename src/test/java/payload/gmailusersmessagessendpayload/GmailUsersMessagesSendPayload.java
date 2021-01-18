package payload.gmailusersmessagessendpayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class GmailUsersMessagesSendPayload {
    private String historyId;
    private String id;
    private String internalDate;
    private List<String> labelIds;
    private Payload payload;
    private String raw;
    private Integer sizeEstimate;
    private String snippet;
    private String threadId;
}