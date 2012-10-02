package com.tom.mapreduce.wordcount;

import com.tom.mapreduce.DataSource;

import java.util.Arrays;
import java.util.Iterator;

public class WordCountDataSource implements DataSource {

    public Iterator<String> getIterator() {
        String[] data = new String[] { "tom kim ian", "nancy bob tom kim", "ian"};
        return Arrays.asList(data).iterator();
    }
}
