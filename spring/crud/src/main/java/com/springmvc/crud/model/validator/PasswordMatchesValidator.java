package com.springmvc.crud.model.validator;

import com.springmvc.crud.model.dto.RegisterEmployeeDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        RegisterEmployeeDTO employee = (RegisterEmployeeDTO) obj;
        return employee.getPassword().equals(employee.getMatchingPassword());
    }
}
