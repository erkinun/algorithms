package com.unlu.erkin;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MiniGoogleTest {

    private MiniGoogle google = new MiniGoogle();

    @Before
    public void setUp() {
        google.add("http://lostmohican.org", "hede");
        google.add("http://hurriyet.com.tr", "turkiyenin lesi");
        google.add("http://imdb.com/lastofthemohicans", "adam gibi film");
        google.add("http://milliyet.com.tr", "hede godo gzt");
    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testSearch() throws Exception {
        List<MiniGoogle.Index> indexList = google.search("mohican");

        assertEquals(indexList.size(), 2);

        indexList.stream().forEach(index -> System.out.println(index.toString()));
    }
}