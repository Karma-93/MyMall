package com.alone.mymall.validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.beans.ConstructorProperties;

public class FlagValidatorClass implements ConstraintValidator<FlagValidator,Integer> {
    private String[] values;

    @Override
    public void initialize(FlagValidator constraintAnnotation) {
        this.values=constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid=false;
        if (integer==null){
            //当状态为空时使用默认值
            return true;
        }
        for (int i=0;i<values.length;i++){
            if (values[i].equals(String.valueOf(integer))){
                isValid=true;
                break;
            }
        }
        return isValid;
    }
}
