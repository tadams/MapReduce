package com.tom.mapreduce.movie;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MovieDataSourceTest {

    @Test
    public void shouldReadMovieFile() {

        MovieDataSource dataSource = new MovieDataSource("src/main/data/movies.txt");
        assertThat(dataSource.size(), is(999));

    }



}
