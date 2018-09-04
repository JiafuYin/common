package com.common.ignore.aspect;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.dao.DuplicateKeyException;

public class IgnoreExceptionAspect {
    private static int errorCode = 1062;

    public IgnoreExceptionAspect() {
    }

    public final Object ignoreExceptionAround(ProceedingJoinPoint point) throws Throwable, MySQLIntegrityConstraintViolationException {
        Object result = null;

        try {
            result = point.proceed();
            return result;
        } catch (DuplicateKeyException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }
}
