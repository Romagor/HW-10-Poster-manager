package ru.netology.manager;

import ru.netology.domain.MovieItem;

public class PosterManager {
    private MovieItem[] items = new MovieItem[0];
    int limitMovie = 10;

    public PosterManager() {
    }

    public PosterManager(int limitMovie) {
        this.limitMovie = limitMovie;
    }

    public void add(MovieItem item) {
        MovieItem[] tmp = new MovieItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public MovieItem[] getFindAll() {
        return items;
    }

    public MovieItem[] getFindLast() {
        MovieItem[] result;
        if (items.length > limitMovie) {
            result = new MovieItem[limitMovie];
        } else {
            result = new MovieItem[items.length];
        }
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
