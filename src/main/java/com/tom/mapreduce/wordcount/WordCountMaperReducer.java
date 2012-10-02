package com.tom.mapreduce.wordcount;

import com.tom.mapreduce.Emitter;
import com.tom.mapreduce.MaperReducer;

import java.util.List;

public class WordCountMaperReducer implements MaperReducer<Integer> {

    public void map(Emitter<Integer> emitter, String record) {

        for (String word : record.split(" ")) {
            emitter.emit(word, 1);
        }
    }

    public void reduce(Emitter<Integer> emitter, String key, List<Integer> values) {
        Integer total = 0;
        for (Integer value : values) {
            total = total + value;
        }
        emitter.emit(key, total);
    }
}
