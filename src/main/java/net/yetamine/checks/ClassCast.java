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

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * A utility class for checking class casts.
 */
public final class ClassCast {

    /**
     * Casts an argument to the desired formal type, relying on the result of
     * the type compatibility condition, which is passed as an argument.
     *
     * <p>
     * The usual pattern for using this method uses {@code instanceof} checks to
     * supply the condition resolution. Still, it does not prevent the code from
     * failing due to {@link ClassCastException} later if the cast is unchecked,
     * but it provides usually sufficient protection, which is especially useful
     * when dealing with generics, e.g., when dealing with serializable classes:
     *
     * <pre>
     * final Collection&lt;String&gt; result = ClassCast.check(arg, arg instanceof Collection&lt;?&gt;, ClassCastException::new);
     * </pre>
     *
     * @param <T>
     *            the type of the result
     * @param <X>
     *            the type of the exception to throw
     * @param result
     *            the argument to check and return
     * @param castable
     *            the result of the condition whether the argument may be cast.
     *            If {@code true}, the argument is cast and returned, otherwise
     *            the exception (provided by the exception supplier) is thrown.
     * @param exceptionSupplier
     *            the supplier of the exception which is thrown when the
     *            condition is not met. It must not be {@code null}.
     *
     * @return the argument to check
     *
     * @throws X
     *             if the condition is not satisfied
     */
    @SuppressWarnings("unchecked")
    public static <T, X extends Throwable> // @formatter:break
    T check(Object result, boolean castable, Supplier<? extends X> exceptionSupplier) throws X {
        assert (exceptionSupplier != null) : "Exception supplier must not be null.";

        if (castable) {
            return (T) result;
        }

        throw exceptionSupplier.get();
    }

    /**
     * Casts an argument to the desired formal type, relying on the result of
     * the type compatibility condition, which is passed as an argument.
     *
     * <p>
     * This method uses {@link #check(Object, boolean, Supplier)} to express
     * <code>ClassCast.check(result, castable, ClassCastException::new)</code>.
     *
     * @param <T>
     *            the type of the result
     * @param result
     *            the argument to check and return
     * @param castable
     *            the result of the condition whether the argument may be cast.
     *            If {@code true}, the argument is cast and returned, otherwise
     *            {@link ClassCastException} with no details is thrown.
     *
     * @return the argument to check
     *
     * @throws ClassCastException
     *             if the condition is not satisfied
     */
    public static <T> T check(Object result, boolean castable) {
        return check(result, castable, ClassCastException::new);
    }

    /**
     * Casts an argument to the desired formal type, relying on a compatibility
     * test predicate, which is passed as an argument.
     *
     * @param <T>
     *            the type of the result
     * @param <U>
     *            the type of the argument
     * @param <X>
     *            the type of the exception to throw
     * @param result
     *            the argument to check and return
     * @param castable
     *            the predicate of the condition whether the argument may be
     *            cast. If it returns {@code true}, the argument is cast and
     *            returned, otherwise the exception (provided by the exception
     *            supplier) is thrown.
     * @param exceptionSupplier
     *            the supplier of the exception which is thrown when the
     *            condition is not met. It must not be {@code null}.
     *
     * @return the argument to check
     *
     * @throws NullPointerException
     *             if the predicate is {@code null}
     * @throws X
     *             if the condition is not satisfied
     */
    @SuppressWarnings("unchecked")
    public static <T, U, X extends Throwable> // @formatter:break
    T check(U result, Predicate<? super U> castable, Supplier<? extends X> exceptionSupplier) throws X {
        assert (exceptionSupplier != null) : "Exception supplier must not be null.";

        if (castable.test(result)) {
            return (T) result;
        }

        throw exceptionSupplier.get();
    }

    /**
     * Checks an argument whether it can be cast to the desired class and
     * performs the cast if possible.
     *
     * @param <X>
     *            the type of the exception to throw
     * @param <T>
     *            the type of the result
     * @param result
     *            the argument to check and return
     * @param clazz
     *            the desired class of the result. It must not be {@code null}.
     * @param exceptionMapping
     *            the mapping of the {@link ClassCastException} exception, which
     *            is thrown when the condition is not met, to the exception that
     *            shall be propagated further. It must not be {@code null}.
     *
     * @return the argument to check
     *
     * @throws NullPointerException
     *             if the desired class is {@code null}
     * @throws X
     *             if the condition is not satisfied
     */
    public static <T, X extends Throwable> // @formatter:break
    T check(Object result, Class<? extends T> clazz, Function<? super ClassCastException, ? extends X> exceptionMapping) throws X {
        assert (exceptionMapping != null) : "Exception mapping must not be null.";

        try {
            return clazz.cast(result);
        } catch (ClassCastException e) {
            throw exceptionMapping.apply(e);
        }
    }

    private ClassCast() {
        throw new AssertionError();
    }
}
