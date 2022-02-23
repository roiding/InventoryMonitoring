package ran.ding.notifying.entity;

import lombok.Data;
import ran.ding.notifying.common.CrawlingTypeCodeEnum;
import ran.ding.notifying.common.SubscribeTypeEnum;
import ran.ding.notifying.config.EnumValidate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;


@Data
public class SubscribeItem {
    @EnumValidate(enumClass= SubscribeTypeEnum.class,message = "订阅类型不支持")
    private String subscribeType;
    @NotBlank(message = "请检查地址输入值")
    private String address;
    @EnumValidate(enumClass= CrawlingTypeCodeEnum.class,message = "订阅平台不支持")
    private String platform;
    @DecimalMin(value = "1",message = "所选订阅产品不支持")
    private int itemId;


}
