package org.fundacionjala.core.throwables;

public class EnvironmentReadingException extends Exception {
    /**
     * Default error message.
     */
    private static final String MESSAGE = "Exception: error in configuration parameters.";

    /**
     * Default constructor.
     */
    public EnvironmentReadingException() {
        super(MESSAGE);
    }

    /**
     * Constructor, change the default message.
     *
     * @param message to change
     */
    public EnvironmentReadingException(final String message) {
        super(message);
    }

    /**
     * Constructs a new exception specified with a detail message.
     *
     * @param throwable new throwable
     */
    public EnvironmentReadingException(final Throwable throwable) {
        super(MESSAGE, throwable);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message   specified
     * @param throwable new throwable
     */
    public EnvironmentReadingException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
