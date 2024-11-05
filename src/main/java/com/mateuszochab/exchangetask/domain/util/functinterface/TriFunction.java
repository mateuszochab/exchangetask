package com.mateuszochab.exchangetask.domain.util.functinterface;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

