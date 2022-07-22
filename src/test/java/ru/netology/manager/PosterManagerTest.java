package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

public class PosterManagerTest {
    PosterManager manager = new PosterManager();
    MovieItem film1 = new MovieItem(1, 100, "Бладшот", "боевик");
    MovieItem film2 = new MovieItem(2, 101, "Вперёд", "мультфильм");
    MovieItem film3 = new MovieItem(3, 102, "Отель 'Белград'", "комедия");
    MovieItem film4 = new MovieItem(4, 103, "Джентельмены", "боевик");
    MovieItem film5 = new MovieItem(5, 104, "Человек-неведимка", "ужасы");
    MovieItem film6 = new MovieItem(6, 105, "Тролли.Мировой тур", "мультфильм");
    MovieItem film7 = new MovieItem(7, 106, "Номер один", "комедия");
    MovieItem film8 = new MovieItem(8, 107, "Одержимая", "триллер");
    MovieItem film9 = new MovieItem(9, 108, "Секреты Дамблдора", "фэнтези");
    MovieItem film10 = new MovieItem(10, 109, "Неувольняемый", "комедия");

    @BeforeEach
    public void setup() {
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
    }

    @Test
    public void shouldFindAllMovies() {
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);

        MovieItem[] expected = {film1, film2, film3, film4, film5, film6, film7, film8, film9, film10};
        MovieItem[] actual = manager.getFindAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowFistFiveMovies() {
        PosterManager manager = new PosterManager(5);
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);

        MovieItem[] expected = {film1, film2, film3, film4, film5};
        MovieItem[] actual = manager.getFindAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastThreeMovies() {
        PosterManager manager = new PosterManager(3);
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);

        MovieItem[] expected = {film5, film4, film3};
        MovieItem[] actual = manager.getFindLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAllMoviesRevers() {
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);


        MovieItem[] expected = {film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        MovieItem[] actual = manager.getFindLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastFiveMovies() {
        PosterManager manager = new PosterManager(5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);

        MovieItem[] expected = {film10, film9, film8, film7, film6};
        MovieItem[] actual = manager.getFindLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
