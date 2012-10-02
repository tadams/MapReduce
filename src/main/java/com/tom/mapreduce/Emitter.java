package com.tom.mapreduce;

public interface Emitter<T> {

    public void emit(String key, T value);

}
