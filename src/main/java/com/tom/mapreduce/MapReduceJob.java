package com.tom.mapreduce;

import java.util.*;

public class MapReduceJob<T> implements Emitter<T> {

    private enum Phase {
        MAP,
        REDUCE
    }

    private Phase phase;
    private MaperReducer maperReducer;

    private Map<String, T> finalResults = new HashMap<String, T>();
    private Map<String, List<T>> results = new HashMap<String, List<T>>();

    public MapReduceJob(MaperReducer maperReducer, DataSource dataSource) {

        this.maperReducer = maperReducer;
        map(dataSource);
        reduce();
        print();
    }

    private void map(DataSource dataSource) {
        phase = Phase.MAP;

        Iterator<String> iterator = dataSource.getIterator();
        while(iterator.hasNext()) {
            maperReducer.map(this, iterator.next());
        }
    }

    private void reduce() {
        phase = Phase.REDUCE;

        for (Map.Entry<String, List<T>> mapResult : results.entrySet()) {
            maperReducer.reduce(this, mapResult.getKey(), mapResult.getValue());
        }
    }

    private void print() {
        System.out.println(finalResults);
    }

    public void emit(String key, T value) {

        switch (phase) {
            case MAP :
                addResult(key, value);
                break;

            case REDUCE:
                finalResults.put(key, value);
                break;
        }
    }

    private void addResult(String key, T value) {

        List<T> values = results.get(key);
        if (values == null) {
            values = new ArrayList<T>();
        }
        values.add(value);
        results.put(key, values);
    }

    public Map<String, T> getResults() {
        return finalResults;
    }
}
