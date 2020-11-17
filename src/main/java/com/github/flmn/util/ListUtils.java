package com.github.flmn.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class ListUtils {

    public static <E> List<E> distinct(List<E> input) {
        return new ArrayList<>(new HashSet<>(input));
    }

    public static <E> void batch(List<E> list, int batchSize, Consumer<List<E>> consumer) {
        for (int i = 0, j = Math.min(batchSize, list.size());
             i < list.size();
             i += batchSize, j += batchSize) {
            consumer.accept(list.subList(i, Math.min(j, list.size())));
        }
    }

    public static <E> String join(List<E> list, CharSequence delimiter, Function<E, String> supplier) {
        final StringJoiner joiner = new StringJoiner(delimiter);
        list.forEach(e -> joiner.add(supplier.apply(e)));

        return joiner.toString();
    }
}