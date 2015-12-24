package net.yetamine.checks;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * A utility class for checking general conditions.
 */
public final class Constraint {

    /**
     * Checks whether a condition is satisfied.
     *
     * @param <X>
     *            the type of the exception to throw
     * @param condition
     *            the condition result
     * @param exceptionSupplier
     *            the supplier of the exception which is thrown when the
     *            condition is not met. It must not be {@code null}.
     *
     * @throws X
     *             if the condition result is {@code false}
     */
    public static <X extends Throwable> // @formatter:break
    void check(boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
        assert (exceptionSupplier != null) : "Exception supplier must not be null.";
        if (condition) {
            return;
        }

        throw exceptionSupplier.get();
    }

    /**
     * Checks whether a condition for an object is satisfied.
     *
     * @param <T>
     *            the type of the result
     * @param <X>
     *            the type of the exception to throw
     * @param result
     *            the result of this method
     * @param condition
     *            the condition predicate. It must not be {@code null}.
     * @param exceptionSupplier
     *            the supplier of the exception which is thrown when the
     *            condition is not met. It must not be {@code null}.
     *
     * @return the provided result
     *
     * @throws X
     *             if the condition result is {@code false}
     */
    public static <T, X extends Throwable> // @formatter:break
    T check(T result, Predicate<? super T> condition, Supplier<? extends X> exceptionSupplier) throws X {
        assert (exceptionSupplier != null) : "Exception supplier must not be null.";
        if (condition.test(result)) {
            return result;
        }

        throw exceptionSupplier.get();
    }

    /**
     * Checks whether a condition for an object is satisfied.
     *
     * @param <T>
     *            the type of the result
     * @param <X>
     *            the type of the exception to throw
     * @param result
     *            the result of this method
     * @param condition
     *            the condition result
     * @param exceptionSupplier
     *            the supplier of the exception which is thrown when the
     *            condition is not met. It must not be {@code null}.
     *
     * @return the provided result
     *
     * @throws X
     *             if the condition result is {@code false}
     */
    public static <T, X extends Throwable> // @formatter:break
    T check(T result, boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
        assert (exceptionSupplier != null) : "Exception supplier must not be null.";
        if (condition) {
            return result;
        }

        throw exceptionSupplier.get();
    }

    /**
     * Checks whether a condition for a value is satisfied.
     *
     * @param <X>
     *            the type of the exception to throw
     * @param result
     *            the result of this method
     * @param condition
     *            the condition result
     * @param exceptionSupplier
     *            the supplier of the exception which is thrown when the
     *            condition is not met. It must not be {@code null}.
     *
     * @return the provided result
     *
     * @throws X
     *             if the condition result is {@code false}
     */
    public static <X extends Throwable> // @formatter:break
    char check(char result, boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
        assert (exceptionSupplier != null) : "Exception supplier must not be null.";
        if (condition) {
            return result;
        }

        throw exceptionSupplier.get();
    }

    /**
     * Checks whether a condition for a value is satisfied.
     *
     * @param <X>
     *            the type of the exception to throw
     * @param result
     *            the result of this method
     * @param condition
     *            the condition result
     * @param exceptionSupplier
     *            the supplier of the exception which is thrown when the
     *            condition is not met. It must not be {@code null}.
     *
     * @return the provided result
     *
     * @throws X
     *             if the condition result is {@code false}
     */
    public static <X extends Throwable> // @formatter:break
    byte check(byte result, boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
        assert (exceptionSupplier != null) : "Exception supplier must not be null.";
        if (condition) {
            return result;
        }

        throw exceptionSupplier.get();
    }

    /**
     * Checks whether a condition for a value is satisfied.
     *
     * @param <X>
     *            the type of the exception to throw
     * @param result
     *            the result of this method
     * @param condition
     *            the condition result
     * @param exceptionSupplier
     *            the supplier of the exception which is thrown when the
     *            condition is not met. It must not be {@code null}.
     *
     * @return the provided result
     *
     * @throws X
     *             if the condition result is {@code false}
     */
    public static <X extends Throwable> // @formatter:break
    short check(short result, boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
        assert (exceptionSupplier != null) : "Exception supplier must not be null.";
        if (condition) {
            return result;
        }

        throw exceptionSupplier.get();
    }

    /**
     * Checks whether a condition for a value is satisfied.
     *
     * @param <X>
     *            the type of the exception to throw
     * @param result
     *            the result of this method
     * @param condition
     *            the condition result
     * @param exceptionSupplier
     *            the supplier of the exception which is thrown when the
     *            condition is not met. It must not be {@code null}.
     *
     * @return the provided result
     *
     * @throws X
     *             if the condition result is {@code false}
     */
    public static <X extends Throwable> // @formatter:break
    int check(int result, boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
        assert (exceptionSupplier != null) : "Exception supplier must not be null.";
        if (condition) {
            return result;
        }

        throw exceptionSupplier.get();
    }

    /**
     * Checks whether a condition for a value is satisfied.
     *
     * @param <X>
     *            the type of the exception to throw
     * @param result
     *            the result of this method
     * @param condition
     *            the condition result
     * @param exceptionSupplier
     *            the supplier of the exception which is thrown when the
     *            condition is not met. It must not be {@code null}.
     *
     * @return the provided result
     *
     * @throws X
     *             if the condition result is {@code false}
     */
    public static <X extends Throwable> // @formatter:break
    long check(long result, boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
        assert (exceptionSupplier != null) : "Exception supplier must not be null.";
        if (condition) {
            return result;
        }

        throw exceptionSupplier.get();
    }

    /**
     * Checks whether a condition for a value is satisfied.
     *
     * @param <X>
     *            the type of the exception to throw
     * @param result
     *            the result of this method
     * @param condition
     *            the condition result
     * @param exceptionSupplier
     *            the supplier of the exception which is thrown when the
     *            condition is not met. It must not be {@code null}.
     *
     * @return the provided result
     *
     * @throws X
     *             if the condition result is {@code false}
     */
    public static <X extends Throwable> // @formatter:break
    float check(float result, boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
        assert (exceptionSupplier != null) : "Exception supplier must not be null.";
        if (condition) {
            return result;
        }

        throw exceptionSupplier.get();
    }

    /**
     * Checks whether a condition for a value is satisfied.
     *
     * @param <X>
     *            the type of the exception to throw
     * @param result
     *            the result of this method
     * @param condition
     *            the condition result
     * @param exceptionSupplier
     *            the supplier of the exception which is thrown when the
     *            condition is not met. It must not be {@code null}.
     *
     * @return the provided result
     *
     * @throws X
     *             if the condition result is {@code false}
     */
    public static <X extends Throwable> // @formatter:break
    double check(double result, boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
        assert (exceptionSupplier != null) : "Exception supplier must not be null.";
        if (condition) {
            return result;
        }

        throw exceptionSupplier.get();
    }

    private Constraint() {
        throw new AssertionError();
    }
}
