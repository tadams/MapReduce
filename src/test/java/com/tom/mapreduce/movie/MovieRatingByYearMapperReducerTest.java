package com.tom.mapreduce.movie;

import com.tom.mapreduce.MapReduceJob;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MovieRatingByYearMapperReducerTest {

    @Test
    public void shouldFindHighestRatedMovieFor1994() {

        MovieDataSource dataSource = new MovieDataSource("src/main/data/movies.txt");
        MapReduceJob<Movie> job = new MapReduceJob<Movie>(new MovieRatingByYearMapperReducer(), dataSource);

        assertThat(job.getResults().get("1994").getName(), is("The Shawshank Redemption"));
    }


}
