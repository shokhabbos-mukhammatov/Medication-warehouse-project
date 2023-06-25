package edu.itpu.fopjava_course_work.dao;

import java.util.Objects;

public record Range<T extends Comparable<T>>(T from, T to) {
    public Range {
        if (from == null || to == null || from.compareTo(to) > 0) {
            throw new IllegalArgumentException(from + " must be less than " + to);
        }
    }

    public boolean isIn(T value) {
        boolean within = true;
        Objects.requireNonNull(value);
        if (from != null)
            within = from.compareTo(value) <= 0;
        if (to != null)
            within &= value.compareTo(to) <= 0;
        return within;
    }
}
