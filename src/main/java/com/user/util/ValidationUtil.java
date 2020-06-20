package com.user.util;

import com.user.exception.InvalidInputException;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class ValidationUtil {

    private static final String INT_MESSAGE = "Input Integer value cannot be zero or less than zero";
    private static final String STR_MESSAGE = "Input String value cannot be null or empty";

    public static void validateInput(Object o, String message) {
        if(o instanceof Integer)
            validateInteger(o, message);
        else if(o instanceof String)
            validateString(o, message);
    }

    private static void validateInteger(Object o, String message) {
        int input = ((Integer)o).intValue();
        if(null == o)
            throw new InvalidInputException(StringUtils.isEmpty(message) ? INT_MESSAGE : message);
        else if(input <= 0)
            throw new InvalidInputException(StringUtils.isEmpty(message) ? INT_MESSAGE : message);
    }

    private static void validateString(Object o, String message) {
        String input = (String)o;
        if(StringUtils.isEmpty(input))
            throw new InvalidInputException(StringUtils.isEmpty(message) ? STR_MESSAGE : message);
    }
}
