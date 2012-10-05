package com.tom.mapreduce.movie;

import com.tom.mapreduce.Emitter;
import com.tom.mapreduce.MapperReducer;

import java.util.List;

public class MovieRatingByYear implements MapperReducer<Movie> {

    public static final String TAB_SEPARATOR = "\t";

    public void map(Emitter<Movie> movieEmitter, String data) {

        Movie movie = buildMovie(data);
        // need movies mapped to their release date
    }

    public void reduce(Emitter<Movie> movieEmitter, String key, List<Movie> movies) {

        // Find the highest rated movie for the year
    }

    private Movie buildMovie(String record) {
        String[] fields = record.split(TAB_SEPARATOR);
        return new Movie(fields[2],
                         Float.parseFloat(fields[1]),
                         Integer.parseInt(fields[0]),
                         Integer.parseInt(fields[3]));
    }
}
