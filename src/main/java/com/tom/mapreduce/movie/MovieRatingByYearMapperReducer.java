package com.tom.mapreduce.movie;

import com.tom.mapreduce.Emitter;
import com.tom.mapreduce.MapperReducer;

import java.util.List;

public class MovieRatingByYearMapperReducer implements MapperReducer<Movie> {

    public void map(Emitter<Movie> movieEmitter, String data) {

        Movie movie = buildMovie(data);
        movieEmitter.emit(movie.getReleaseYear().toString(), movie);
    }

    public void reduce(Emitter<Movie> movieEmitter, String key, List<Movie> movies) {

        Movie highestRated = findHighestRated(movies);
        movieEmitter.emit(key, highestRated);
    }

    private Movie findHighestRated(List<Movie> movies) {

        Movie highestRated = movies.get(0);
        for (Movie movie : movies) {
            if (highestRated.getOneToTenRating() < movie.getOneToTenRating()) {
                highestRated = movie;
            }
        }
        return highestRated;
    }

    private Movie buildMovie(String record) {
        String[] fields = record.split("\t");
        return new Movie(fields[2],
                         Float.parseFloat(fields[1]),
                         Integer.parseInt(fields[0]),
                         Integer.parseInt(fields[3]));
    }
}
