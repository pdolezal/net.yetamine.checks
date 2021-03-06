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

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * A utility class for checking general conditions.
 */
public final class Constraint {

    /**
     * Prevents creating instances of this class.
     */
    private Constraint() {
        throw new AssertionError();
    }

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
    public static <X extends Throwable> void check(boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
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
    public static <T, X extends Throwable> T check(T result, Predicate<? super T> condition, Supplier<? extends X> exceptionSupplier) throws X {
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
    public static <T, X extends Throwable> T check(T result, boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
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
    public static <X extends Throwable> char check(char result, boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
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
    public static <X extends Throwable> byte check(byte result, boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
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
    public static <X extends Throwable> short check(short result, boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
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
    public static <X extends Throwable> int check(int result, boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
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
    public static <X extends Throwable> long check(long result, boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
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
    public static <X extends Throwable> float check(float result, boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
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
    public static <X extends Throwable> double check(double result, boolean condition, Supplier<? extends X> exceptionSupplier) throws X {
        assert (exceptionSupplier != null) : "Exception supplier must not be null.";
        if (condition) {
            return result;
        }

        throw exceptionSupplier.get();
    }
}
