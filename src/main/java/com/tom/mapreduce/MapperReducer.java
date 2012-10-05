package com.tom.mapreduce;

import java.util.List;

public interface MapperReducer<T> {

    public void map(Emitter<T> emitter, String record);

    public void reduce(Emitter<T> emitter, String key, List<T> values);

}
