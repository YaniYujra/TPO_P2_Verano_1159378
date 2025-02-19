package org.example.util;

import org.example.model.Set;
import org.example.model.Stack;
import org.example.model.StaticSet;

public class SetUtil {


    public static <T> void print(Set<T> set) {
        Set<T> copy = copy(set);
        while(!copy.isEmpty()) {
            T element = copy.choose();
            System.out.println(element);
            copy.remove(element);
        }
    }

    public static <T> Set<T> copy(Set<T> set) {

        Set<T> copy = new StaticSet<>();
        Set<T> aux = new StaticSet<>();

        while(!set.isEmpty()) {
            T element = set.choose();
            copy.add(element);
            aux.add(element);
            set.remove(element);
        }

        while(!aux.isEmpty()) {
            T element = aux.choose();
            set.add(element);
            aux.remove(element);
        }

        return copy;
    }

}
