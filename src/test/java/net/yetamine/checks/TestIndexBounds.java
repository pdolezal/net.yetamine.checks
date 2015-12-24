package net.yetamine.checks;

import java.util.function.Supplier;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests {@link IndexBounds}.
 */
public final class TestIndexBounds {

    /**
     * Tests passing checks.
     */
    @Test
    public void checkPassed() {
        Assert.assertEquals(IndexBounds.check(1, true), 1);
        Assert.assertEquals(IndexBounds.check(2, true, ""), 2);
        Assert.assertEquals(IndexBounds.check(3, true, () -> ""), 3);

        Assert.assertEquals(IndexBounds.check(4L, true), 4L);
        Assert.assertEquals(IndexBounds.check(5L, true, ""), 5L);
        Assert.assertEquals(IndexBounds.check(6L, true, () -> ""), 6L);

        final Object o = new Object();
        Assert.assertSame(IndexBounds.check(o, true), o);
        Assert.assertSame(IndexBounds.check(o, true, ""), o);
        Assert.assertSame(IndexBounds.check(o, true, () -> ""), o);
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IndexOutOfBoundsException.class })
    public void checkFailed1_I() {
        IndexBounds.check(1, false);
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IndexOutOfBoundsException.class })
    public void checkFailed1_L() {
        IndexBounds.check(1L, false);
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IndexOutOfBoundsException.class })
    public void checkFailed1_O() {
        IndexBounds.check(null, false);
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IndexOutOfBoundsException.class })
    public void checkFailed2_I() {
        try {
            IndexBounds.check(2, false, "Error message");
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "Error message");
            throw e;
        }
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IndexOutOfBoundsException.class })
    public void checkFailed2_L() {
        try {
            IndexBounds.check(2L, false, "Error message");
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "Error message");
            throw e;
        }
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IndexOutOfBoundsException.class })
    public void checkFailed2_O() {
        try {
            IndexBounds.check(null, false, "Error message");
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "Error message");
            throw e;
        }
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IndexOutOfBoundsException.class })
    public void checkFailed3_I() {
        try {
            IndexBounds.check(3, false, () -> "Error message");
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "Error message");
            throw e;
        }
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IndexOutOfBoundsException.class })
    public void checkFailed3_L() {
        try {
            IndexBounds.check(3L, false, () -> "Error message");
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "Error message");
            throw e;
        }
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IndexOutOfBoundsException.class })
    public void checkFailed3_O() {
        try {
            IndexBounds.check(null, false, () -> "Error message");
        } catch (IndexOutOfBoundsException e) {
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
    public void missingSupplierIfFalse_I() {
        final Supplier<String> s = null;
        IndexBounds.check(1, false, s);
    }

    /**
     * Tests missing supplier.
     *
     * <p>
     * Works in this way in a testing environment; otherwise relying on JVM to
     * throw {@link NullPointerException} if missing.
     */
    @Test(expectedExceptions = { AssertionError.class })
    public void missingSupplierIfFalse_L() {
        final Supplier<String> s = null;
        IndexBounds.check(1L, false, s);
    }

    /**
     * Tests missing supplier.
     *
     * <p>
     * Works in this way in a testing environment; otherwise relying on JVM to
     * throw {@link NullPointerException} if missing.
     */
    @Test(expectedExceptions = { AssertionError.class })
    public void missingSupplierIfFalse_O() {
        final Supplier<String> s = null;
        IndexBounds.check(null, false, s);
    }

    /**
     * Tests missing supplier.
     *
     * <p>
     * Works in this way in a testing environment; otherwise relying on JVM to
     * throw {@link NullPointerException} if missing.
     */
    @Test(expectedExceptions = { AssertionError.class })
    public void missingSupplierIfTrue_I() {
        final Supplier<String> s = null;
        IndexBounds.check(1, true, s);
    }

    /**
     * Tests missing supplier.
     *
     * <p>
     * Works in this way in a testing environment; otherwise relying on JVM to
     * throw {@link NullPointerException} if missing.
     */
    @Test(expectedExceptions = { AssertionError.class })
    public void missingSupplierIfTrue_L() {
        final Supplier<String> s = null;
        IndexBounds.check(1L, true, s);
    }

    /**
     * Tests missing supplier.
     *
     * <p>
     * Works in this way in a testing environment; otherwise relying on JVM to
     * throw {@link NullPointerException} if missing.
     */
    @Test(expectedExceptions = { AssertionError.class })
    public void missingSupplierIfTrue_O() {
        final Supplier<String> s = null;
        IndexBounds.check(null, true, s);
    }
}
