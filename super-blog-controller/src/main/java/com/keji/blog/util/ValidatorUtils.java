package com.keji.blog.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.keji.blog.exception.BlogException;


/**
 * hibernate-validator校验工具类
 *
 * @author keji
 * @version $Id: ValidatorUtils.java, v 0.1 2018/3/18 下午2:46 keji Exp $
 */
public class ValidatorUtils {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     *
     * @param object 待校验对象
     * @param groups 待校验的组
     * @throws BlogException 校验不通过，BlogException
     */
    public static void validateEntity(Object object, Class<?>... groups) throws BlogException {

        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);

        if (!constraintViolations.isEmpty()) {
            ConstraintViolation<Object> constraint = (ConstraintViolation<Object>)constraintViolations.iterator()
                    .next();
            throw new BlogException(constraint.getMessage());
        }
    }
}
