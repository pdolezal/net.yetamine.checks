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

    private Argument() {
        throw new AssertionError();
    }
}
