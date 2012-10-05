package com.tom.mapreduce.wordcount;

import com.tom.mapreduce.DataSource;
import com.tom.mapreduce.MapReduceJob;
import com.tom.mapreduce.wordcount.WordCountDataSource;
import com.tom.mapreduce.wordcount.WordCountMapperReducer;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordCountTest {

    @Test
    public void shouldCountWordsContainedInDataSource() {

        DataSource dataSource = new WordCountDataSource();

        MapReduceJob<Integer> job = new MapReduceJob<Integer>(new WordCountMapperReducer(),
                                                              dataSource);
        assertThat(job.getResults().get("tom"), is(2));
        assertThat(job.getResults().get("kim"), is(2));
        assertThat(job.getResults().get("ian"), is(2));
        assertThat(job.getResults().get("nancy"), is(1));
        assertThat(job.getResults().get("bob"), is(1));
    }


}
