package net.yetamine.checks;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Tests {@link Argument}.
 */
public final class TestArgument {

    /**
     * Tests passing checks.
     */
    @Test
    public void checkPassed() {
        final Object o = new Object();

        Assert.assertSame(Argument.check(o, true), o);
        Assert.assertEquals(Argument.check('a', true), 'a');
        Assert.assertEquals(Argument.check((byte) 1, true), (byte) 1);
        Assert.assertEquals(Argument.check((short) 2, true), (short) 2);
        Assert.assertEquals(Argument.check(3, true), 3);
        Assert.assertEquals(Argument.check(4L, true), 4L);
        Assert.assertEquals(Argument.check(1.0f, true), 1.0f);
        Assert.assertEquals(Argument.check(1.0, true), 1.0);

        Assert.assertSame(Argument.check(o, true, ""), o);
        Assert.assertEquals(Argument.check('a', true, ""), 'a');
        Assert.assertEquals(Argument.check((byte) 1, true, ""), (byte) 1);
        Assert.assertEquals(Argument.check((short) 2, true, ""), (short) 2);
        Assert.assertEquals(Argument.check(3, true, ""), 3);
        Assert.assertEquals(Argument.check(4L, true, ""), 4L);
        Assert.assertEquals(Argument.check(1.0f, true, ""), 1.0f);
        Assert.assertEquals(Argument.check(1.0, true, ""), 1.0);

        Assert.assertSame(Argument.check(o, true, () -> ""), o);
        Assert.assertEquals(Argument.check('a', true, () -> ""), 'a');
        Assert.assertEquals(Argument.check((byte) 1, true, () -> ""), (byte) 1);
        Assert.assertEquals(Argument.check((short) 2, true, () -> ""), (short) 2);
        Assert.assertEquals(Argument.check(3, true, () -> ""), 3);
        Assert.assertEquals(Argument.check(4L, true, () -> ""), 4L);
        Assert.assertEquals(Argument.check(1.0f, true, () -> ""), 1.0f);
        Assert.assertEquals(Argument.check(1.0, true, () -> ""), 1.0);
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void checkFailing1_O() {
        Argument.check(null, false);
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void checkFailing2_O() {
        Argument.check(new Object(), false);
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void checkFailing_C() {
        Argument.check('a', false);
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void checkFailing_B() {
        Argument.check((byte) 1, false);
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void checkFailing_S() {
        Argument.check((short) 1, false);
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void checkFailing_I() {
        Argument.check(1, false);
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void checkFailing_L() {
        Argument.check(1L, false);
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void checkFailing_F() {
        Argument.check(1.0f, false);
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void checkFailing_D() {
        Argument.check(1.0, false);
    }

    /**
     * Tests error message passing.
     *
     * @param message
     *            the expected message
     * @param test
     *            the test to run. It must not be {@code null}.
     */
    @Test(expectedExceptions = { IllegalArgumentException.class }, dataProvider = "messageTests")
    public void checkMessage(String message, Runnable test) {
        try {
            test.run();
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(message, e.getMessage());
            throw e;
        }
    }

    @SuppressWarnings("javadoc")
    @DataProvider(name = "messageTests")
    public static Object[][] messageTests() {
        return new Object[][] {
            // @formatter:off

            // Fixed messages
            { "null",   (Runnable) () -> Argument.check(null, false, "null")            },
            { "object", (Runnable) () -> Argument.check(new Object(), false, "object")  },
            { "char",   (Runnable) () -> Argument.check('a', false, "char")             },
            { "byte",   (Runnable) () -> Argument.check((byte) 1, false, "byte")        },
            { "short",  (Runnable) () -> Argument.check((short) 1, false, "short")      },
            { "int",    (Runnable) () -> Argument.check(1, false, "int")                },
            { "long",   (Runnable) () -> Argument.check(1L, false, "long")              },
            { "float",  (Runnable) () -> Argument.check(10.f, false, "float")           },
            { "double", (Runnable) () -> Argument.check(10.f, false, "double")          },

            // Message suppliers
            { "null",   (Runnable) () -> Argument.check(null, false, () -> "null")            },
            { "object", (Runnable) () -> Argument.check(new Object(), false, () -> "object")  },
            { "char",   (Runnable) () -> Argument.check('a', false, () -> "char")             },
            { "byte",   (Runnable) () -> Argument.check((byte) 1, false, () -> "byte")        },
            { "short",  (Runnable) () -> Argument.check((short) 1, false, () -> "short")      },
            { "int",    (Runnable) () -> Argument.check(1, false, () -> "int")                },
            { "long",   (Runnable) () -> Argument.check(1L, false, () -> "long")              },
            { "float",  (Runnable) () -> Argument.check(10.f, false, () -> "float")           },
            { "double", (Runnable) () -> Argument.check(10.f, false, () -> "double")          }
            // @formatter:on
        };
    }
}
