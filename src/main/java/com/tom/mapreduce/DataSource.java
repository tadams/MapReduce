package com.tom.mapreduce;

import java.util.Iterator;

public interface DataSource<T> {

    public Iterator<T> getIterator();

    public int size();

}
