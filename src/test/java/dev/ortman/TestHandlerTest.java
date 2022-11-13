package dev.ortman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestHandlerTest {

    @Test
    void shoudlListAllSubscribers() {
        var sut = new TestHandler();

        assertEquals(2, sut.handleRequest().size());
    }
}