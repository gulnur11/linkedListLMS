package sevice.serviceImpl;

import database.Database;
import models.Movie;
import sevice.MovieSortableService;

import java.util.Comparator;

public class MovieSortableServiceImpl implements MovieSortableService {

    @Override
    public void sortMovieByName(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            Database.movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie movie1, Movie movie2) {
                    return movie1.getName().compareTo(movie2.getName());
                }
            });
        } else {
            Database.movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie movie1, Movie movie2) {
                    return movie2.getName().compareTo(movie1.getName());
                }
            });
        }
    }

    @Override
    public void sortByYear(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            Database.movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie movie1, Movie movie2) {
                    return movie1.getYear().compareTo(movie2.getYear());
                }
            });
        } else {
            Database.movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie movie1, Movie movie2) {
                    return movie2.getYear().compareTo(movie1.getYear());
                }
            });
        }
    }



    @Override
    public void sortByProducer(String nameOrLastName) {
        if (nameOrLastName.equalsIgnoreCase("firstName")) {
            Database.movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie movie1, Movie movie2) {
                    return movie1.getProducer().getFirstName().compareTo(movie2.getProducer().getFirstName());
                }
            });
        } else {
            Database.movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie movie1, Movie movie2) {
                    return movie1.getProducer().getLastName().compareTo(movie2.getProducer().getLastName());
                }
            });
        }
    }





}
