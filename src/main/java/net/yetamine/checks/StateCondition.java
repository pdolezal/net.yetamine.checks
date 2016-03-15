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
        assert (messageSupplier != null) : "Message supplier must not be null.";
        if (condition) {
            return;
        }

        throw new IllegalStateException(messageSupplier.get());
    }

    private StateCondition() {
        throw new AssertionError();
    }
}
