package com.example.blocks.domain;

import java.util.ArrayList;

abstract class AggregateRoot {
    private ArrayList<Event> events;

    void recordThat(Event e) {
        events.add(e);
    }

    ArrayList<Event> pullEvents() {
        ArrayList<Event> recorded = events;
        events = new ArrayList<>();

        return recorded;
    }
}
