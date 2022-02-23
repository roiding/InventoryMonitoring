package ran.ding.notifying.entity;

import lombok.Data;

@Data
public class EmailSubscriber {
    private int id;
    private String mailAddress;
    private String hasMailed;
    private int notifyId;
}
