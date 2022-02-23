package ran.ding.notifying.common;

public enum SubscribeTypeEnum {

    MAIL("email"),
    Server_JIANG("ServerChan");

    private String subscribeType;

    private SubscribeTypeEnum(String subscribeType){
        this.subscribeType=subscribeType;
    }

    public String getSubscribeType() {
        return subscribeType;
    }

    public boolean isEnumEntity(String value){
        SubscribeTypeEnum[] enumConstants = SubscribeTypeEnum.class.getEnumConstants();
        for (SubscribeTypeEnum enumConstant : enumConstants) {
            if(enumConstant.subscribeType.equals(value)){
                return true;
            }
        }
        return false;
    }
}
