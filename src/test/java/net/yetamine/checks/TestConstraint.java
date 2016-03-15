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

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests {@link Constraint}.
 */
public final class TestConstraint {

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
        final Object o = new Object();

        Assert.assertSame(Constraint.check(o, true, FailingException::new), o);
        Assert.assertSame(Constraint.check(o, t -> {
            Assert.assertSame(t, o);
            return true;
        }, FailingException::new), o);

        Constraint.check(true, FailingException::new);

        Assert.assertEquals(Constraint.check('a', true, FailingException::new), 'a');
        Assert.assertEquals(Constraint.check((byte) 1, true, FailingException::new), (byte) 1);
        Assert.assertEquals(Constraint.check((short) 2, true, FailingException::new), (short) 2);
        Assert.assertEquals(Constraint.check(3, true, FailingException::new), 3);
        Assert.assertEquals(Constraint.check(4L, true, FailingException::new), 4L);
        Assert.assertEquals(Constraint.check(1.0f, true, FailingException::new), 1.0f);
        Assert.assertEquals(Constraint.check(1.0, true, FailingException::new), 1.0);
    }

    /**
     * Tests failing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test(expectedExceptions = { FailingException.class })
    public void checkFailing0() throws FailingException {
        Constraint.check(false, FailingException::new);
    }

    /**
     * Tests failing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test(expectedExceptions = { FailingException.class })
    public void checkFailing1_O() throws FailingException {
        Constraint.check(null, false, FailingException::new);
    }

    /**
     * Tests failing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test(expectedExceptions = { FailingException.class })
    public void checkFailing2_O() throws FailingException {
        Constraint.check(new Object(), false, FailingException::new);
    }

    /**
     * Tests failing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test(expectedExceptions = { FailingException.class })
    public void checkFailing3_O() throws FailingException {
        final Object o = new Object();
        Constraint.check(o, t -> {
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
        Constraint.check('a', false, FailingException::new);
    }

    /**
     * Tests failing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test(expectedExceptions = { FailingException.class })
    public void checkFailing_B() throws FailingException {
        Constraint.check((byte) 1, false, FailingException::new);
    }

    /**
     * Tests failing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test(expectedExceptions = { FailingException.class })
    public void checkFailing_S() throws FailingException {
        Constraint.check((short) 1, false, FailingException::new);
    }

    /**
     * Tests failing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test(expectedExceptions = { FailingException.class })
    public void checkFailing_I() throws FailingException {
        Constraint.check(1, false, FailingException::new);
    }

    /**
     * Tests failing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test(expectedExceptions = { FailingException.class })
    public void checkFailing_L() throws FailingException {
        Constraint.check(1L, false, FailingException::new);
    }

    /**
     * Tests failing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test(expectedExceptions = { FailingException.class })
    public void checkFailing_F() throws FailingException {
        Constraint.check(1.0f, false, FailingException::new);
    }

    /**
     * Tests failing checks.
     *
     * @throws FailingException
     *             if something fails
     */
    @Test(expectedExceptions = { FailingException.class })
    public void checkFailing_D() throws FailingException {
        Constraint.check(1.0, false, FailingException::new);
    }
}
