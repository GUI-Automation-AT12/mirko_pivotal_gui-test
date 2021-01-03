package org.fundacionjala.core.throwables;

public class PropertiesReadingException extends Exception {
    /**
     * Default error message.
     */
    private static final String MESSAGE = "Exception: error in configuration parameters.";

    /**
     * Default constructor.
     */
    public PropertiesReadingException() {
        super(MESSAGE);
    }

    /**
     * Constructor, change the default message.
     *
     * @param message to change
     */
    public PropertiesReadingException(final String message) {
        super(message);
    }

    /**
     * Constructs a new exception specified with a detail message.
     *
     * @param throwable new throwable
     */
    public PropertiesReadingException(final Throwable throwable) {
        super(MESSAGE, throwable);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message   specified
     * @param throwable new throwable
     */
    public PropertiesReadingException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
