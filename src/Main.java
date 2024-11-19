import database.Database;
import enums.Genre;
import models.Actor;
import models.Movie;
import models.Producer;
import sevice.MovieFindableService;
import sevice.MovieSortableService;
import sevice.serviceImpl.MovieFindableServiceImpl;
import sevice.serviceImpl.MovieSortableServiceImpl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Database.actors.add(new Actor("Brad Pit", "Police officer"));
        Database.actors.add(new Actor("Cillian Murphy", "Scientist"));

        Database.producers.add(new Producer("James", "Cameron"));
        Database.producers.add(new Producer("Christopher", "Nolan"));

        Database.movies.add(new Movie("Seven", LocalDate.of(1995, 7, 16), Genre.THRILLER,
                Database.producers.get(0), List.of(Database.actors.get(0))));

        Database.movies.add(new Movie("Oppenheimer", LocalDate.of(2024, 7, 6), Genre.BIOGRAPHICAL,
                Database.producers.get(1), List.of(Database.actors.get(1))));

        MovieFindableService findableService = new MovieFindableServiceImpl();
        MovieSortableService sortableService = new MovieSortableServiceImpl();


        while (true) {
            System.out.println("Select Method: \n" +
                    "1.List<Movie> getAllMovies();\n" +
                    "2.Movie findMovieByFullNameOrPartName(String name);\n" +
                    "3. Movie findMovieByActorName(String actorName);\n" +
                    "4.Movie findMovieByYear(LocalDate year);\n" +
                    "5.Movie findMovieByProducer(String producerFullName);\n" +
                    "6.Movie findMovieByGenre(Genre genre);\n" +
                    "7.Movie findMovieByRole(String role);\n" +
                    "8.Movies before sorting by Name:\n"+
                    "9.void sortMovieByName(String ascOrDesc);\n" +
                    "10.void sortByYear(String ascOrDesc);\n" +
                    "11.void sortByProducer(String nameOrlastName); ");


            Scanner scanner = new Scanner(System.in);
            int selection = scanner.nextInt();
            if (selection == 12) {
                System.out.println("EXIT ! ");
                break;
            }
            switch (selection) {
                case 1:
                    System.out.println("All Movies: " + findableService.getAllMovies());
                    break;
                case 2:
                    System.out.println("Find by Name (Seven): " + findableService.findMovieByFullNameOrPartName("Seven"));
                    break;
                case 3:
                    System.out.println("Find by Actor Name (Cillian Murphy): " + findableService.findMovieByActorName("Cillian Murphy"));
                    break;
                case 4:
                    System.out.println("Find by Year (1995): " + findableService.findMovieByYear(LocalDate.of(1995, 7, 16)));
                    break;
                case 5:
                    System.out.println("Find by Producer (Christopher Nolan): " + findableService.findMovieByProducer("Christopher Nolan"));
                    break;
                case 6:
                    System.out.println("Find by Genre (BIOGRAPHICAL): " + findableService.findMovieByGenre(Genre.BIOGRAPHICAL));
                    break;
                case 7:
                    System.out.println("Find by Role (Police officer): " + findableService.findMovieByRole("Police officer"));
                    break;
                case 8:System.out.println("\nMovies before sorting by Name:");
                Database.movies.forEach(System.out::println);
                break;
                case 9: sortableService.sortMovieByName("asc");
             System.out.println("\nMovies sorted by Name (asc):");
               Database.movies.forEach(System.out::println);
               break;
                case 10:
        sortableService.sortByYear("desc");
        System.out.println("\nMovies sorted by Year (desc):");
        Database.movies.forEach(System.out::println);
        break;
                case 11: sortableService.sortByProducer("lastName");
         System.out.println("\nMovies sorted by Producer's Last Name:");
         Database.movies.forEach(System.out::println);
         break;
                default:
                    System.out.println("Method not found!");

            }

        }




















}}