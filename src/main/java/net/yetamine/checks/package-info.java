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
 *     bar(Argument.check(i, i &gt; 0, () -&gt; String.format("Requiring a positive number (given: %d).", i)));
 * }
 *
 * private void bar(int i) {
 *     assert (i &gt; 0);
 *     // Doing some stuff, requiring 'i' to be positive. But this method is private
 *     // and therefore it relies on the callers to provide already checked values.
 * }
 * </pre>
 *
 * <p>
 * To make the checks cheaper, the exception suppliers are not checked whether
 * not being {@code null}; all such cases are guarded with {@code assert}, so
 * that code defects could be still detected in a testing environment.
 */
package net.yetamine.checks;
