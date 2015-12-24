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
