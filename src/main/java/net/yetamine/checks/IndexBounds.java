package net.yetamine.checks;

import java.util.function.Supplier;

/**
 * A utility class for checking index bounds.
 */
public final class IndexBounds {

    /**
     * Checks an index whether it satisfies a condition.
     *
     * @param <T>
     *            the type of the result
     * @param result
     *            the index to check and returned
     * @param condition
     *            the condition to check
     *
     * @return the index to check
     *
     * @throws IndexOutOfBoundsException
     *             if the condition is not satisfied
     */
    public static <T> T check(T result, boolean condition) {
        if (condition) {
            return result;
        }

        throw new IndexOutOfBoundsException();
    }

    /**
     * Checks an index whether it satisfies a condition.
     *
     * @param <T>
     *            the type of the result
     * @param result
     *            the index to check and returned
     * @param condition
     *            the condition to check
     * @param message
     *            the message of the exception thrown when the check fails
     *
     * @return the index to check
     *
     * @throws IndexOutOfBoundsException
     *             if the condition is not satisfied
     */
    public static <T> T check(T result, boolean condition, String message) {
        if (condition) {
            return result;
        }

        throw new IndexOutOfBoundsException(message);
    }

    /**
     * Checks an index whether it satisfies a condition.
     *
     * @param <T>
     *            the type of the result
     * @param result
     *            the index to check and returned
     * @param condition
     *            the condition to check
     * @param messageSupplier
     *            the supplier of the message for the exception that is thrown
     *            when the check fails. It must not be {@code null}.
     *
     * @return the index to check
     *
     * @throws IndexOutOfBoundsException
     *             if the condition is not satisfied
     */
    public static <T> T check(T result, boolean condition, Supplier<String> messageSupplier) {
        assert (messageSupplier != null) : "Message supplier must not be null.";
        if (condition) {
            return result;
        }

        throw new IndexOutOfBoundsException(messageSupplier.get());
    }

    /**
     * Checks an index whether it satisfies a condition.
     *
     * @param result
     *            the index to check and returned
     * @param condition
     *            the condition to check
     *
     * @return the index to check
     *
     * @throws IndexOutOfBoundsException
     *             if the condition is not satisfied
     */
    public static int check(int result, boolean condition) {
        if (condition) {
            return result;
        }

        throw new IndexOutOfBoundsException();
    }

    /**
     * Checks an index whether it satisfies a condition.
     *
     * @param result
     *            the index to check and returned
     * @param condition
     *            the condition to check
     * @param message
     *            the message of the exception thrown when the check fails
     *
     * @return the index to check
     *
     * @throws IndexOutOfBoundsException
     *             if the condition is not satisfied
     */
    public static int check(int result, boolean condition, String message) {
        if (condition) {
            return result;
        }

        throw new IndexOutOfBoundsException(message);
    }

    /**
     * Checks an index whether it satisfies a condition.
     *
     * @param result
     *            the index to check and returned
     * @param condition
     *            the condition to check
     * @param messageSupplier
     *            the supplier of the message for the exception that is thrown
     *            when the check fails. It must not be {@code null}.
     *
     * @return the index to check
     *
     * @throws IndexOutOfBoundsException
     *             if the condition is not satisfied
     */
    public static int check(int result, boolean condition, Supplier<String> messageSupplier) {
        assert (messageSupplier != null) : "Message supplier must not be null.";
        if (condition) {
            return result;
        }

        throw new IndexOutOfBoundsException(messageSupplier.get());
    }

    /**
     * Checks an index whether it satisfies a condition.
     *
     * @param result
     *            the index to check and returned
     * @param condition
     *            the condition to check
     *
     * @return the index to check
     *
     * @throws IndexOutOfBoundsException
     *             if the condition is not satisfied
     */
    public static long check(long result, boolean condition) {
        if (condition) {
            return result;
        }

        throw new IndexOutOfBoundsException();
    }

    /**
     * Checks an index whether it satisfies a condition.
     *
     * @param result
     *            the index to check and returned
     * @param condition
     *            the condition to check
     * @param message
     *            the message of the exception thrown when the check fails
     *
     * @return the index to check
     *
     * @throws IndexOutOfBoundsException
     *             if the condition is not satisfied
     */
    public static long check(long result, boolean condition, String message) {
        if (condition) {
            return result;
        }

        throw new IndexOutOfBoundsException(message);
    }

    /**
     * Checks an index whether it satisfies a condition.
     *
     * @param result
     *            the index to check and returned
     * @param condition
     *            the condition to check
     * @param messageSupplier
     *            the supplier of the message for the exception that is thrown
     *            when the check fails. It must not be {@code null}.
     *
     * @return the index to check
     *
     * @throws IndexOutOfBoundsException
     *             if the condition is not satisfied
     */
    public static long check(long result, boolean condition, Supplier<String> messageSupplier) {
        assert (messageSupplier != null) : "Message supplier must not be null.";
        if (condition) {
            return result;
        }

        throw new IndexOutOfBoundsException(messageSupplier.get());
    }

    private IndexBounds() {
        throw new AssertionError();
    }
}
