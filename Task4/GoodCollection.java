package ru.kpfu.itis.ibragimov.collections;

import ru.kpfu.itis.ibragimov.algorithms_and_data_structures.CollectionIterator;
import ru.kpfu.itis.ibragimov.generics.ArrayIterator;

import java.util.*;

public class GoodCollection<T> extends AbstractCollection {

    private static final int INIT_SIZE = 10000;

    private T[] data;
    private int size;

    public GoodCollection() {
        this.data = (T[]) new Object[INIT_SIZE];
        this.size = 0;
    }

    public GoodCollection(Collection<? extends T> collection) {
        this.data = (T[]) new Object[collection.size()];
        Iterator<? extends T> iterator = collection.iterator();
        while(iterator.hasNext()) {
            data[size] = iterator.next();
            size++;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor != data.length;
            }

            @Override
            public T next() {
                try {
                    T el = data[cursor];
                    cursor++;
                    return el;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public void remove() {
                for (int i = cursor; i < data.length - 1; i++) {
                    data[i] = data[i+1];
                }
                cursor--;
                size--;
            }
        };
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Object o) {
        T el = (T) o;
        data[size] = el;
        size++;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodCollection<?> that = (GoodCollection<?>) o;

        if (size != that.size) return false;

        return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + size;
        return result;
    }
}
