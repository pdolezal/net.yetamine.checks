/**
 * Utility classes for easy runtime condition checks.
 *
 * <h1>Overview</h1>
 *
 * Using classes from this package can make pre-condition checks more compact
 * and readable when employing lambdas than usual if-then-throw code pattern:
 *
 * <pre>
 * public void foo(int i) {
 *     // Following check throws IllegalArgumentException if not satisfied with the detailed message
 *     bar(Argument.check(i, i > 0, () -> String.format("Requiring positive number (given: %d)", i)));
 * }
 *
 * private void bar(int i) {
 *     assert (i > 0);
 *     // Doing some stuff, requiring i to be positive. But this method is private
 *     // and therefore it relies on the callers to provide already checked values.
 * }
 * </pre>
 *
 * <p>
 * To make the checks cheaper, the exception suppliers are not checked whether
 * not being {@code null} when they are not needed. However, each such case is
 * guarded at least with {@code assert}, so that it is still possible to detect
 * code defects in the positive cases in a testing environment.
 */
package net.yetamine.checks;
