package ran.ding.notifying.config;

import org.springframework.util.StringUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidate.Validator.class)
public @interface EnumValidate {
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 枚举类
     */
    Class<? extends Enum<?>> enumClass();

    /**
     * 默认提示文字
     */
    String message() default "字段校验错误";

    String validateMethod() default "isEnumEntity";

    /**
     * 是否忽略空值
     */
    boolean ignoreEmpty() default false;

    /**
     * 校验器
     */
    class Validator implements ConstraintValidator<EnumValidate, Object> {

        private EnumValidate annotation;

        @Override
        public void initialize(EnumValidate annotation) {
            this.annotation = annotation;
        }

        @Override
        public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
            Class<? extends Enum<?>> cls = annotation.enumClass();
            if (cls.isEnum() && (Objects.nonNull(value) || !annotation.ignoreEmpty())) {
                try {
                    Method method = cls.getMethod(annotation.validateMethod());
                    boolean invoke = (boolean) method.invoke((String) value);
                    return invoke;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    return false;
                }
            } else {
                return true;
            }
        }
    }


}
