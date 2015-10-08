package com.unlu.erkin.functional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by eunlu on 08/10/2015.
 */
public class NearbyWords {

    public Set<String> findNearbyWords(String word) {

        Set<String> nearbyWords = new HashSet<>();


        final int[] i = {0};
        word.chars()
                .forEach(c -> {
                    Set<Character> nearChars = nearbyChars((char)c);
                    i[0]++;
                    nearChars.stream()
                            .forEach(nc -> nearbyWords.add(word.substring(0, i[0]) + nc + word.substring(i[0]+1)));

                });

        return nearbyWords.stream()
                .filter(w -> isWord(w))
                .distinct()
                .collect(Collectors.toSet());
    }

    private boolean isWord(String w) {
        return true;
    }

    private Set<Character> nearbyChars(char c) {
        return null;
    }
}
