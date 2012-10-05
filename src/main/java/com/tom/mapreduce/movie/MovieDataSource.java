package com.tom.mapreduce.movie;

import com.tom.mapreduce.DataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MovieDataSource implements DataSource {

    List<String> movies;

    public MovieDataSource(String fileName) {
        movies = loadFile(fileName);
    }

    public Iterator<String> getIterator() {
        return movies.iterator();
    }

    public int size() {
        return movies.size();
    }

    private List<String> loadFile(String fileName) {

        Scanner scanner = null;
        List<String> movies = new ArrayList<String>();

        try {
            scanner = new Scanner(new FileInputStream(fileName));

            while (scanner.hasNextLine()) {
                movies.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (scanner != null) scanner.close();
        }

        return movies;
    }



}
