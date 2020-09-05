package com.aritra.sample;

public class LambdaInterfaces {
}

interface Foo1 { boolean equals(Object obj); }
// Not functional because equals is already an implicit member (Object class)

interface Comparator<T> {
    boolean equals(Object obj);
    int compare(T o1, T o2);
}
// Functional because Comparator has only one abstract non-Object method

interface Foo2 {
    int m();
    Object clone();
}
// Not functional because method Object.clone is not public

interface X1 { int m(Iterable<String> arg); }
interface Y1 { int m(Iterable<String> arg); }
interface Z1 extends X1, Y1 {}
// Functional: two methods, but they have the same signature

interface X2 { Iterable m(Iterable<String> arg); }
interface Y2 { Iterable<String> m(Iterable arg); }
interface Z2 extends X2, Y2 {}
// Functional: Y.m is a subsignature & return-type-substitutable

interface X3 { int m(Iterable<String> arg); }
interface Y3 { int m(Iterable<Integer> arg); }
//interface Z3 extends X3, Y3 {}
// Not functional: No method has a subsignature of all abstract methods

interface X4 { int m(Iterable<String> arg, Class c); }
interface Y4 { int m(Iterable arg, Class<?> c); }
//interface Z4 extends X4, Y4 {}
// Not functional: No method has a subsignature of all abstract methods

interface X5 { long m(); }
interface Y5 { int m(); }
//interface Z5 extends X5, Y5 {}
// Compiler error: no method is return type substitutable

interface Foo5<T> { void m(T arg); }
interface Bar5<T> { void m(T arg); }
//interface FooBar5<X, Y> extends Foo5<X>, Bar5<Y> {}
// Compiler error: different signatures, same erasure
