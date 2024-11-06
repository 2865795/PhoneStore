package main.java.ee.ivkhkdev.handlers;

import java.util.List;

public interface Handler<T> {
    List<T> load();
    void save(List<T> items);
}
