package ran.ding.notifying.common;

public enum CrawlingTypeCodeEnum {
    YILI_GAME(1);

    private int typeCode;
    private CrawlingTypeCodeEnum(int typeCode){
        this.typeCode=typeCode;
    }

    public int getTypeCode() {
        return typeCode;
    }
}
