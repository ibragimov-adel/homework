package ru.kpfu.itis.ibragimov.collections;

import ru.kpfu.itis.ibragimov.generics.ArrayIterator;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class SimpleCollection<T> extends AbstractCollection<T> {

    private static final int INIT_SIZE = 0;

    private T[] data;

    public SimpleCollection() {
        this.data = (T[]) new Object[INIT_SIZE];
    }

    public SimpleCollection(Collection<? extends T> collection) {
        this.data = (T[]) new Object[collection.size()];
        Iterator<? extends T> iterator = collection.iterator();
        int i = 0;
        while(iterator.hasNext()) {
            data[i] = iterator.next();
            i++;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(Arrays.copyOf(data, data.length));
    }

    @Override
    public int size() {
        return data.length;
    }
}
