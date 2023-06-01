package com.example.lap3.validator;

import com.example.lap3.entity.PhongBan;
import com.example.lap3.validator.annotation.ValidMaPhongBan;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPhongBanIMaPhongBan implements ConstraintValidator<ValidMaPhongBan, PhongBan>{
    @Override
    public boolean isValid (PhongBan phongBan, ConstraintValidatorContext context){
        return phongBan != null && phongBan.getMa_Phong() != null;
    }
}
