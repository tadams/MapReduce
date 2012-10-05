package com.tom.mapreduce.wordcount;

import com.tom.mapreduce.Emitter;
import com.tom.mapreduce.MapperReducer;

import java.util.List;

public class WordCountMapperReducer implements MapperReducer<Integer> {

    public void map(Emitter<Integer> emitter, String record) {

        for (String word : record.split(" ")) {
            // Count each word, emit a count of one
        }
    }

    public void reduce(Emitter<Integer> emitter, String key, List<Integer> values) {
        Integer total = 0;
        // Reduce all the values to a total for the key
        emitter.emit(key, total);
    }
}
