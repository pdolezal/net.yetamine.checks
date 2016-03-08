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
import org.testng.annotations.Test;

/**
 * Tests {@link ClassCastException}.
 */
public final class TestClassCast {

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
    public void checkPassed() throws FailingException {
        final Object o = new StringBuilder();

        Assert.assertSame(ClassCast.check(o, true, FailingException::new), o);
        Assert.assertSame(ClassCast.check(o, t -> {
            Assert.assertSame(t, o);
            return true;
        }, FailingException::new), o);

        Assert.assertSame(ClassCast.check(o, true), o);
        Assert.assertSame(ClassCast.check(o, StringBuilder.class, e -> e), o);

        ClassCast.check(null, true);
        ClassCast.check(null, true, FailingException::new);
        ClassCast.check(null, t -> true, FailingException::new);

        // Tests assignments
        @SuppressWarnings("unused")
        StringBuilder s = null;
        s = ClassCast.check(o, true);
        s = ClassCast.check(o, true, FailingException::new);
        s = ClassCast.check(o, t -> true, FailingException::new);
        s = ClassCast.check(o, StringBuilder.class, e -> e);

        // Tests unchecked casts
        Collection<String> cs = null;
        final Object co = Arrays.asList("A", "B", "C");

        cs = ClassCast.check(co, co instanceof Collection<?>);
        Assert.assertSame(cs, co);

        cs = ClassCast.check(co, co instanceof Collection<?>, FailingException::new);
        Assert.assertSame(cs, co);

        cs = ClassCast.check(co, t -> t instanceof Collection<?>, FailingException::new);
        Assert.assertSame(cs, co);
    }

    /**
     * Tests failing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test(expectedExceptions = { FailingException.class })
    public void checkFailing0() throws FailingException {
        ClassCast.check(null, false, FailingException::new);
    }

    /**
     * Tests failing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test(expectedExceptions = { FailingException.class })
    public void checkFailing1_O() throws FailingException {
        ClassCast.check(new Object(), false, FailingException::new);
    }

    /**
     * Tests failing checks.
     */
    @Test(expectedExceptions = { ClassCastException.class })
    public void checkFailing2_O() {
        ClassCast.check(new Object(), false);
    }

    /**
     * Tests failing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test(expectedExceptions = { FailingException.class })
    public void checkFailing3_O() throws FailingException {
        final Object o = new StringBuilder();
        ClassCast.check(o, t -> {
            Assert.assertSame(t, o);
            return false;
        }, FailingException::new);
    }

    /**
     * Tests failing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test(expectedExceptions = { FailingException.class })
    public void checkFailing_C() throws FailingException {
        final Object o = new StringBuilder();
        ClassCast.check(o, String.class, e -> new FailingException());
    }
}
