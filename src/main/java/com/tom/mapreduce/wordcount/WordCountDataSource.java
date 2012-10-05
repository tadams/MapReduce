package com.tom.mapreduce.wordcount;

import com.tom.mapreduce.DataSource;

import java.util.Arrays;
import java.util.Iterator;

public class WordCountDataSource implements DataSource<String> {

    private static final String[] DATA = new String[] { "tom kim ian", "nancy bob tom kim", "ian"};

    public Iterator<String> getIterator() {

        return Arrays.asList(DATA).iterator();
    }

    public int size() {
        return DATA.length;
    }
}
