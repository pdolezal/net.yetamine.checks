# net.yetamine.checks #

This repository provides a tiny Java library for compact runtime checks, especially for ensuring preconditions.


## Examples ##

An example of a more advanced use of `Argument::check`:

```{java}
public void foo(int i) {
    // Following check throws IllegalArgumentException if not satisfied with the detailed message
    bar(Argument.check(i, i > 0, () -> String.format("Requiring a positive number (given: %d).", i)));
}

private void bar(int i) {
    assert (i > 0);
    // Doing some stuff, requiring 'i' to be positive. But this method is private
    // and therefore it relies on the callers to provide already checked values.
}
```


## Prerequisites ##

For building this project is needed:

* JDK 8 or newer.
* Maven 3.3 or newer.

For using the built library is needed:

* JRE 8 or newer.


## Licensing ##

The project is licensed under the [Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0). For previous versions of this repository the original or current license can be chosen, i.e., the current license applies as an option for all previously published content.

Contributions to the project are welcome and accepted if they can be incorporated without the need of changing the license or license conditions and terms.


[![Yetamine logo](https://github.com/pdolezal/net.yetamine/raw/master/about/Yetamine_small.png "Our logo")](https://github.com/pdolezal/net.yetamine/blob/master/about/Yetamine_large.png)
