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

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests {@link StateCondition}.
 */
public final class TestStateCondition {

    /**
     * Tests passing checks.
     */
    @Test
    public void checkPassed() {
        StateCondition.check(true);
        StateCondition.check(true, "");
        StateCondition.check(true, () -> "");
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IllegalStateException.class })
    public void checkFailed1() {
        StateCondition.check(false);
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IllegalStateException.class })
    public void checkFailed2() {
        try {
            StateCondition.check(false, "Error message");
        } catch (IllegalStateException e) {
            Assert.assertEquals(e.getMessage(), "Error message");
            throw e;
        }
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IllegalStateException.class })
    public void checkFailed3() {
        try {
            StateCondition.check(false, () -> "Error message");
        } catch (IllegalStateException e) {
            Assert.assertEquals(e.getMessage(), "Error message");
            throw e;
        }
    }

    /**
     * Tests missing supplier.
     *
     * <p>
     * Works in this way in a testing environment; otherwise relying on JVM to
     * throw {@link NullPointerException} if missing.
     */
    @Test(expectedExceptions = { AssertionError.class })
    public void missingSupplierIfFalse() {
        final Supplier<String> s = null;
        StateCondition.check(false, s);
    }

    /**
     * Tests missing supplier.
     *
     * <p>
     * Works in this way in a testing environment; otherwise relying on JVM to
     * throw {@link NullPointerException} if missing.
     */
    @Test(expectedExceptions = { AssertionError.class })
    public void missingSupplierIfTrue() {
        final Supplier<String> s = null;
        StateCondition.check(true, s);
    }
}
