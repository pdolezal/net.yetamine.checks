package net.yetamine.checks;

import java.util.function.Supplier;

/**
 * A utility class for checking state conditions.
 */
public final class StateCondition {

    /**
     * Checks whether a state condition is satisfied.
     *
     * @param condition
     *            the condition to check
     *
     * @throws IllegalStateException
     *             if the condition is not satisfied
     */
    public static void check(boolean condition) {
        if (condition) {
            return;
        }

        throw new IllegalStateException();
    }

    /**
     * Checks whether a state condition is satisfied.
     *
     * @param condition
     *            the condition to check
     * @param message
     *            the message of the exception thrown when the check fails
     *
     * @throws IllegalStateException
     *             if the condition is not satisfied
     */
    public static void check(boolean condition, String message) {
        if (condition) {
            return;
        }

        throw new IllegalStateException(message);
    }

    /**
     * Checks whether a state condition is satisfied.
     *
     * @param condition
     *            the condition to check
     * @param messageSupplier
     *            the supplier of the message for the exception that is thrown
     *            when the check fails. It must not be {@code null}.
     *
     * @throws IllegalStateException
     *             if the condition is not satisfied
     */
    public static void check(boolean condition, Supplier<String> messageSupplier) {
        if (condition) {
            assert (messageSupplier != null) : "Message supplier must not be null.";
            return;
        }

        throw new IllegalStateException(messageSupplier.get());
    }

    private StateCondition() {
        throw new AssertionError();
    }
}
