package ru.netology.repository;

import ru.netology.domain.MovieItem;

public class PosterRepository {

    int limitMovie = 10;
    private MovieItem[] items = new MovieItem[0];

    public MovieItem[] findAll() {
        int filmsToShow;
        if (limitMovie >= items.length) {
            filmsToShow = items.length;
        }
        filmsToShow = limitMovie;
        MovieItem[] result = new MovieItem[filmsToShow];
        for (int i = 0; i < result.length; i++) {
            int index = filmsToShow - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public MovieItem[] save(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
        return items;
    }

    public MovieItem findById(int id) {
        for (MovieItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public MovieItem[] removeById(int id) {
        MovieItem[] tmp = new MovieItem[items.length - 1];
        int index = 0;
        for (MovieItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return items;
    }

    public void removeAll() {
        MovieItem[] tmp = new MovieItem[0];
        items = tmp;
    }
}
