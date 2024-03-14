package com.erich.api.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void systemOut() {
        Item s = new Item();
        String s3 = s.systemOut();
        System.out.println("-->"+s3);
        String s2 = "Hello";
        Assertions.assertEquals(s.systemOut(), "Hello");
    }

    @Test
    void add() {
        Item i = new Item();
        int result = i.add(1,2);
        assertEquals(3, result);
    }
}