package ran.ding.notifying.entity;

import lombok.Data;

@Data
public class EmailSubscriber {
    private int id;
    private String mailAddress;
    private int hasMailed;
    private int notifyId;
}
