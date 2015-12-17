# net.yetamine.lang #

This repository provides a tiny Java library for compact runtime checks, especially for ensuring preconditions.


## Examples ##

An example of a more advanced use of `Argument::check`:

```{java}
public void foo(int i) {
    // Following check throws IllegalArgumentException if not satisfied with the detailed message
    bar(Argument.check(i, i > 0, () -> String.format("Requiring a positive number (given: %d)", i)));
}

private void bar(int i) {
    assert (i > 0);
    // Doing some stuff, requiring i to be positive. But this method is private
    // and therefore it relies on the callers to provide already checked values.
}
```


## Prerequisites ##

For building this project is needed:

* JDK 8 or newer.
* Maven 3.3 or newer.
* Yetamine parent POM: see [net.yetamine](http://github.com/pdolezal/net.yetamine).

For using the built library is needed:

* JRE 8 or newer.


## Licensing ##

The whole content of this repository is licensed under the [CC BY-SA 4.0][CC-BY-SA] license. Contributions are accepted only under the same licensing terms, under the terms of [CC BY 4.0][CC-BY], or under a public domain license (like [CC0][CC0]), so that the work based on the contributions might be published under the CC BY-SA license terms.

[CC-BY-SA]:  http://creativecommons.org/licenses/by-sa/4.0/
[CC-BY]:     http://creativecommons.org/licenses/by/4.0/
[CC0]:       http://creativecommons.org/choose/zero/
