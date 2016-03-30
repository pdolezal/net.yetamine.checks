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

import java.util.Arrays;
import java.util.Collection;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Tests {@link Argument}.
 */
public final class TestArgument {

    /**
     * A helper private exception that can't definitely be used elsewhere.
     */
    private static final class FailingException extends Exception {

        /** Serialization version: 1 */
        private static final long serialVersionUID = 1L;

        /**
         * Creates a new instance.
         */
        public FailingException() {
            // Default constructor
        }
    }

    /**
     * Tests passing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test
    public void castPassed() throws FailingException {
        final Object o = new StringBuilder();

        Assert.assertSame(Argument.cast(o, true, FailingException::new), o);
        Assert.assertSame(Argument.cast(o, true), o);

        Argument.cast(null, true);
        Argument.cast(null, true, FailingException::new);

        // Tests assignments
        @SuppressWarnings("unused")
        StringBuilder s = null;
        s = Argument.cast(o, true);
        s = Argument.cast(o, true, FailingException::new);

        // Tests unchecked casts
        Collection<String> cs = null;
        final Object co = Arrays.asList("A", "B", "C");

        cs = Argument.cast(co, co instanceof Collection<?>);
        Assert.assertSame(cs, co);

        cs = Argument.cast(co, co instanceof Collection<?>, FailingException::new);
        Assert.assertSame(cs, co);
    }

    /**
     * Tests failing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test(expectedExceptions = { FailingException.class })
    public void castFailing0() throws FailingException {
        Argument.cast(null, false, FailingException::new);
    }

    /**
     * Tests failing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test(expectedExceptions = { FailingException.class })
    public void castFailing1_O() throws FailingException {
        Argument.cast(new Object(), false, FailingException::new);
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { ClassCastException.class })
    public void castFailing2_O() {
        Argument.cast(new Object(), false);
    }

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
