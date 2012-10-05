package com.tom.mapreduce.movie;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MovieDataSourceTest {

    @Test
    public void shouldReadMovieFile() {

        MovieDataSource dataSource = new MovieDataSource("src/main/data/movies.txt");
        assertThat(dataSource.size(), is(999));
    }

    @Test
    public void shouldThrowExceptionWhenFileNotFound() {
        try {
            new MovieDataSource("file/does/not/exist.txt");
        } catch(RuntimeException e) {
            assertTrue("Should Throw FileNotFoundException",
                       e.getCause() instanceof FileNotFoundException);
        }
    }



}
