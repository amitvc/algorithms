package com.algorithms.practice2022.arrays;

public class MinPQ<T extends Comparable<T>> {

    private final T[] values;
    private int position;
    public MinPQ(int size) {
        values = (T[]) new Object[size + 1];
        position = 1;
    }

    public void add(T value) {
        if (position == 0) {
            values[++position] = value;
        } else {
            if (position >= values.length) {
                throw new ArrayIndexOutOfBoundsException("");
            }

            values[++position] = value;
            swim(position);
        }
    }

    private void swim(int pos) {

    }

    public T remove() {
        return null;
    }



}
