package com.tom.mapreduce;

import java.util.Iterator;

public interface DataSource {

    public Iterator<String> getIterator();

    public int size();

}
