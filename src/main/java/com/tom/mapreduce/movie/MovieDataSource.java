package com.tom.mapreduce.movie;

import com.tom.mapreduce.DataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MovieDataSource implements DataSource<Movie> {

    List<Movie> movies;

    public MovieDataSource(String fileName) {
        movies = loadFile(fileName);
    }

    public Iterator<Movie> getIterator() {
        return movies.iterator();
    }

    public int size() {
        return movies.size();
    }

    private List<Movie> loadFile(String fileName) {

        Scanner scanner = null;
        List<Movie> movies = new ArrayList<Movie>();

        try {
            scanner = new Scanner(new FileInputStream(fileName));

            while (scanner.hasNextLine()) {
                String record = scanner.nextLine();
                movies.add(buildMovie(record));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (scanner != null) scanner.close();
        }

        return movies;
    }

    private Movie buildMovie(String record) {
        String[] fields = record.split("\t");
        return new Movie(fields[2],
                         Double.parseDouble(fields[1]),
                         Integer.parseInt(fields[0]));
    }

}
