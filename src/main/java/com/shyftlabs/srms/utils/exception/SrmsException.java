package com.shyftlabs.srms.utils.exception;

public class SrmsException  extends RuntimeException {

    public SrmsException(final String message) {
        super(message);
    }

    public SrmsException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
