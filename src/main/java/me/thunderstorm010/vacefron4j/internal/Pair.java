package me.thunderstorm010.vacefron4j.internal;

public class Pair<F,S> {
    public F first;
    public S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public static <T,R> Pair<T,R> pair(T first, R second) {
        return new Pair<>(first, second);
    }
}
