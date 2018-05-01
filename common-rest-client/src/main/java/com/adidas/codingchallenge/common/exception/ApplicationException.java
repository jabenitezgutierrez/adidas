package com.adidas.codingchallenge.common.exception;

/**
 * Custom exceptions class
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
public class ApplicationException extends RuntimeException {

    /**
     * Constructs an ApplicationException with no
     * detail message.
     */
    public ApplicationException() {
        super();
    }

    /**
     * Constructs an ApplicationException with the
     * specified detail message.
     *
     * @param detailMessage The detail message.
     */
    public ApplicationException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new exception with the specified detail message and
     * cause.
     *
     * @param message the detail message.
     * @param cause the cause.
     */
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified cause and a detail
     * message
     *
     * @param cause The cause
     */
    public ApplicationException(Throwable cause) {
        super(cause);
    }
}
