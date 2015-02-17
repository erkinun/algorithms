package com.unlu.erkin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ERKIN on 15/02/15.
 */
public class MiniGoogle {

    private List<Index> indexList = new ArrayList<Index>();

    //public void add
    public void add(String url, String body) {
        indexList.add(new Index(url, body));
    }

    public List<Index> search(String term) {
        return indexList.stream()
                .filter(index -> index.url.contains(term))
                .collect(Collectors.toList());
    }

    public static class Index {
        String url;
        String index;

        private Index(String url, String index) {
            this.url = url;
            this.index = index;
        }

        public String toString() {
            return "url: " + url + ", body: " + index;
        }
    }
}
