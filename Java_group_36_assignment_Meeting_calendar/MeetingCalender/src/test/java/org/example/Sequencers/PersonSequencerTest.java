package org.example.Sequencers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonSequencerTest {

    @Test
    void nextPersonId() {
        int a = PersonSequencer.nextPersonId();
       int b = PersonSequencer.nextPersonId();

       assertNotEquals(a, b);
    }

    @Test
    void reset() {


    }
}