/*
 * Copyright 2016 Yetamine
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.yetamine.checks;

import java.util.function.Supplier;

/**
 * A utility class for checking argument pre-conditions.
 */
public final class Argument {

    /**
     * Prevents creating instances of this class.
     */
    private Argument() {
        throw new AssertionError();
    }

    // Value casting methods

    /**
     * Casts an argument to the desired formal type, relying on the result of
     * the type compatibility condition, which is passed as an argument.
     *
     * <p>
     * This method equals basically to {@link #cast(Object, boolean, Supplier)}
     * invoked as <code>cast(result, castable, ClassCastException::new)</code>.
     *
     * @param <T>
     *            the type of the result
     * @param result
     *            the argument to check and return
     * @param castable
     *            the result of the condition whether the argument may be cast.
     *            If {@code true}, the argument is cast and returned, otherwise
     *            {@link ClassCastException} with no details is thrown.
     *
     * @return the argument to check
     *
     * @throws ClassCastException
     *             if the condition is not satisfied
     */
    public static <T> T cast(Object result, boolean castable) {
        return cast(result, castable, ClassCastException::new);
    }

    /**
     * Casts an argument to the desired formal type, relying on the result of
     * the type compatibility condition, which is passed as an argument.
     *
     * <p>
     * The usual pattern for using this method uses {@code instanceof} checks to
     * supply the condition resolution. Still, it does not prevent the code from
     * failing due to {@link ClassCastException} later if the cast is unchecked,
     * but it provides usually sufficient protection, which is especially useful
     * when dealing with generics, e.g., when dealing with serializable classes:
     *
     * <pre>
     * final Collection&lt;String&gt; result = cast(arg, arg instanceof Collection&lt;?&gt;, ClassCastException::new);
     * </pre>
     *
     * Note that the unchecked conversion needs assigning to a variable of the
     * desired type, so that JVM could throw {@link ClassCastException} if the
     * assignment is impossible despite of the condition.
     *
     * @param <T>
     *            the type of the result
     * @param <X>
     *            the type of the exception to throw
     * @param result
     *            the argument to check and return
     * @param castable
     *            the result of the condition whether the argument may be cast.
     *            If {@code true}, the argument is cast and returned, otherwise
     *            the exception (provided by the exception supplier) is thrown.
     * @param exceptionSupplier
     *            the supplier of the exception which is thrown when the
     *            condition is not met. It must not be {@code null}.
     *
     * @return the argument to check
     *
     * @throws X
     *             if the condition is not satisfied
     */
    @SuppressWarnings("unchecked")
    public static <T, X extends Throwable> T cast(Object result, boolean castable, Supplier<? extends X> exceptionSupplier) throws X {
        assert (exceptionSupplier != null) : "Exception supplier must not be null.";

        if (castable) {
            return (T) result;
        }

        throw exceptionSupplier.get();
    }

    // Regular checking methods

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param <T>
     *            the type of the result
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static <T> T check(T result, boolean condition) {
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException();
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param <T>
     *            the type of the result
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     * @param message
     *            the message of the exception thrown when the check fails
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static <T> T check(T result, boolean condition, String message) {
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException(message);
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param <T>
     *            the type of the result
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     * @param messageSupplier
     *            the supplier of the message for the exception that is thrown
     *            when the check fails. It must not be {@code null}.
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static <T> T check(T result, boolean condition, Supplier<String> messageSupplier) {
        assert (messageSupplier != null) : "Message supplier must not be null.";
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException(messageSupplier.get());
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static char check(char result, boolean condition) {
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException();
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     * @param message
     *            the message of the exception thrown when the check fails
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static char check(char result, boolean condition, String message) {
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException(message);
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     * @param messageSupplier
     *            the supplier of the message for the exception that is thrown
     *            when the check fails. It must not be {@code null}.
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static char check(char result, boolean condition, Supplier<String> messageSupplier) {
        assert (messageSupplier != null) : "Message supplier must not be null.";
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException(messageSupplier.get());
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static byte check(byte result, boolean condition) {
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException();
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     * @param message
     *            the message of the exception thrown when the check fails
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static byte check(byte result, boolean condition, String message) {
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException(message);
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     * @param messageSupplier
     *            the supplier of the message for the exception that is thrown
     *            when the check fails. It must not be {@code null}.
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static byte check(byte result, boolean condition, Supplier<String> messageSupplier) {
        assert (messageSupplier != null) : "Message supplier must not be null.";
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException(messageSupplier.get());
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static short check(short result, boolean condition) {
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException();
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     * @param message
     *            the message of the exception thrown when the check fails
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static short check(short result, boolean condition, String message) {
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException(message);
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     * @param messageSupplier
     *            the supplier of the message for the exception that is thrown
     *            when the check fails. It must not be {@code null}.
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static short check(short result, boolean condition, Supplier<String> messageSupplier) {
        assert (messageSupplier != null) : "Message supplier must not be null.";
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException(messageSupplier.get());
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static int check(int result, boolean condition) {
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException();
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     * @param message
     *            the message of the exception thrown when the check fails
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static int check(int result, boolean condition, String message) {
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException(message);
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     * @param messageSupplier
     *            the supplier of the message for the exception that is thrown
     *            when the check fails. It must not be {@code null}.
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static int check(int result, boolean condition, Supplier<String> messageSupplier) {
        assert (messageSupplier != null) : "Message supplier must not be null.";
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException(messageSupplier.get());
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static long check(long result, boolean condition) {
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException();
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     * @param message
     *            the message of the exception thrown when the check fails
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static long check(long result, boolean condition, String message) {
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException(message);
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     * @param messageSupplier
     *            the supplier of the message for the exception that is thrown
     *            when the check fails. It must not be {@code null}.
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static long check(long result, boolean condition, Supplier<String> messageSupplier) {
        assert (messageSupplier != null) : "Message supplier must not be null.";
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException(messageSupplier.get());
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static float check(float result, boolean condition) {
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException();
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     * @param message
     *            the message of the exception thrown when the check fails
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static float check(float result, boolean condition, String message) {
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException(message);
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     * @param messageSupplier
     *            the supplier of the message for the exception that is thrown
     *            when the check fails. It must not be {@code null}.
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static float check(float result, boolean condition, Supplier<String> messageSupplier) {
        assert (messageSupplier != null) : "Message supplier must not be null.";
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException(messageSupplier.get());
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static double check(double result, boolean condition) {
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException();
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     * @param message
     *            the message of the exception thrown when the check fails
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static double check(double result, boolean condition, String message) {
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException(message);
    }

    /**
     * Checks an argument whether it satisfies a condition.
     *
     * @param result
     *            the argument to check and returned
     * @param condition
     *            the condition to check
     * @param messageSupplier
     *            the supplier of the message for the exception that is thrown
     *            when the check fails. It must not be {@code null}.
     *
     * @return the argument to check
     *
     * @throws IllegalArgumentException
     *             if the condition is not satisfied
     */
    public static double check(double result, boolean condition, Supplier<String> messageSupplier) {
        assert (messageSupplier != null) : "Message supplier must not be null.";
        if (condition) {
            return result;
        }

        throw new IllegalArgumentException(messageSupplier.get());
    }
}
