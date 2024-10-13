package com.joe.abdelaziz.ffs_task.utils.validators.bookTypeValidator;

import java.util.Arrays;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValidator implements ConstraintValidator<ValidEnum, Enum<?>> {

  private Class<? extends Enum<?>> enumClass;

  @Override
  public void initialize(ValidEnum constraintAnnotation) {
    this.enumClass = constraintAnnotation.enumClass();
  }

  @Override
  public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {

    return Arrays.stream(enumClass.getEnumConstants()).anyMatch(e -> e.equals(value));
  }

}
