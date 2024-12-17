package org.sberuniversity;


import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams<T> {
    private Collection<T> collection;

    public Streams(Collection<T> collection) {
        this.collection = collection;
    }

    public static <T> Streams<T> of(Collection<T> collection) {
        return new Streams<>(collection);
    }

    public Streams<T> filter(Predicate<T> predicate) {
        Iterator<T> iterator = collection.iterator();
        Collection<T> result = new ArrayList<>();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return new Streams<>(result);
    }

    public Streams<T> transform(Function<? super T, ? extends T> function) {
        Collection<T> result = new ArrayList<>();
        for (T element : collection) {
            result.add(function.apply(element));
        }
        return new Streams<T>(result);
    }

    public <K, V> Map<K, V> toMap(Function<? super T, ? extends K> keyMapper,
                                  Function<? super T, ? extends V> valueMapper) {
        Map<K, V> map = new HashMap<>();
        for (T item : collection) {
            map.put(keyMapper.apply(item), valueMapper.apply(item));
        }
        return map;
    }
}

