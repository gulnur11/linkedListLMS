package sevice.serviceImpl;

import database.Database;
import enums.Genre;
import models.Actor;
import models.Movie;
import sevice.MovieFindableService;

import java.time.LocalDate;
import java.util.List;

public class MovieFindableServiceImpl implements MovieFindableService {

    @Override
    public List<Movie> getAllMovies() {
        return Database.movies;
    }


    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        for (Movie movie : Database.movies) {
            if (movie.getName().toLowerCase().contains(name.toLowerCase())) {
                return movie;
            }
        }
        return null;
    }


    @Override
    public Movie findMovieByActorName(String actorName) {
        for (Movie movie : Database.movies) {
            if (movie.getActors() != null) {
                for (Actor actor : movie.getActors()) {
                    if (actor.getActorFullName().equalsIgnoreCase(actorName)) {
                        return movie;
                    }
                }
            }
        }
        return null;
    }


    @Override
    public Movie findMovieByYear(LocalDate year) {
        for (Movie movie : Database.movies) {
            if (movie.getYear().equals(year)) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByProducer(String producerFullName) {
        for (Movie movie : Database.movies) {
            if (movie.getProducer() != null &&
                    (movie.getProducer().getFirstName() + " " + movie.getProducer().getLastName())
                            .equalsIgnoreCase(producerFullName)) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        for (Movie movie : Database.movies) {
            if (movie.getGenre() == genre) {
                return movie;
            }
        }
        return null;
    }


    @Override
    public Movie findMovieByRole(String role) {
        for (Movie movie : Database.movies) {
            if (movie.getActors() != null) {
                for (Actor actor : movie.getActors()) {
                    if (actor.getRole().equalsIgnoreCase(role)) {
                        return movie;
                    }
                }
            }
        }
        return null;
    }


}
